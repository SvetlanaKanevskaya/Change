package android.start.change;


import android.content.Context;
import android.graphics.Color;
import android.provider.Telephony;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class CommonAdapter extends BaseAdapter {

    public Context context;
    public ArrayList<Currency> currencies;

    public CommonAdapter(Context context) {

        this.context = context;

    }


    @Override
    public int getCount() {
        return Singleton.makeArray().getArray().size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        RelativeLayout relative = (RelativeLayout) inflater.inflate(R.layout.currency, parent, false);


        Currency curr = Singleton.makeArray().getArray().get(position);

        ImageView imageView = (ImageView) relative.findViewById(R.id.imageView);


        TextView country = (TextView) relative.findViewById(R.id.countryTXT);
        country.setText("Country: " + curr.getCountry());
        country.setTextColor(Color.BLACK);

        TextView currText = (TextView) relative.findViewById(R.id.currencyTXT);
        currText.setText("Currency: " + curr.getCurrency());
        country.setTextColor(Color.BLACK);

        TextView rate = (TextView) relative.findViewById(R.id.courseTXT);
        rate.setText("Rate: " + curr.getRate());
        rate.setTextColor(Color.BLACK);


        imageView.setImageResource(curr.getPic());
        return relative;
    }

}
