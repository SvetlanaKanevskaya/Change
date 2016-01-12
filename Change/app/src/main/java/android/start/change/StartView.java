package android.start.change;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;

public class StartView extends AppCompatActivity {
    private ListView listView;
    private CommonAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_view);

        new DownloadInfo().start();

        adapter = new CommonAdapter(getApplicationContext());
        listView = (ListView) findViewById(R.id.listCountry);
        listView.setAdapter(adapter);
        listView.invalidateViews();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent in = new Intent(getApplicationContext(), Shekels.class);
                in.putExtra("objId", position);
                startActivity(in);
            }
        });
    }

    class DownloadInfo extends Thread {
        private String str;
        private String nameOfCountry;
        private String rateOfCountry;
       private String currenc;
        int pic=0 ;
        @Override
        public void run() {
            super.run();
            String linkName[] = {
                    "http://www.boi.org.il/currency.xml?curr=01",
                    "http://www.boi.org.il/currency.xml?curr=27",
                    "http://www.boi.org.il/currency.xml?curr=70",
                    "http://www.boi.org.il/currency.xml?curr=05",
                    "http://www.boi.org.il/currency.xml?curr=06",
                    "http://www.boi.org.il/currency.xml?curr=02",
                    "http://www.boi.org.il/currency.xml?curr=12",
                    "http://www.boi.org.il/currency.xml?curr=31",
                    "http://www.boi.org.il/currency.xml?curr=79",
                    "http://www.boi.org.il/currency.xml?curr=69",
            };
            Singleton.makeArray().getArray().clear();

            for (String link : linkName) {
                try {
                    URL url = new URL(link);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    BufferedReader br = new BufferedReader(new InputStreamReader(
                            conn.getInputStream()));
                    while ((str = br.readLine()) != null) {
                        if (str.toLowerCase().contains("country")) {
                            String[] a = str.split("[><]");
                            nameOfCountry = a[2];
                        }
                        if (str.toLowerCase().contains("rate")) {
                            String[] a = str.split("[><]");
                            rateOfCountry = a[2];
                        }
                        if (str.toLowerCase().contains("name")) {
                            String[] a = str.split("[><]");
                            currenc = a[2];
                        }

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }


                switch (nameOfCountry) {
                    case "USA":
                        pic = R.drawable.dolar;
                        break;
                    case "EMU":
                        pic = R.drawable.euros;
                        break;
                    case "Lebanon":
                        pic = R.drawable.lirabrit;
                        break;
                    case "Switzerland":
                        pic = R.drawable.franc;
                        break;
                    case "Canada":
                        pic = R.drawable.dolarcanada;
                        break;
                    case "Great Britain":
                        pic = R.drawable.pound;
                        break;
                    case "Denmark":
                        pic = R.drawable.krona;
                        break;
                    case "Japan":
                        pic = R.drawable.yen;
                        break;
                    case "Egypt":
                        pic = R.drawable.lira;
                        break;
                    case "Jordan":
                        pic = R.drawable.dinars;
                        break;

                }

                final Currency currency = new Currency(nameOfCountry, currenc,
                        rateOfCountry, pic);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Singleton.makeArray().getArray().add(currency);
                        listView.invalidateViews();
                    }
                });
            }

        }
    }
}