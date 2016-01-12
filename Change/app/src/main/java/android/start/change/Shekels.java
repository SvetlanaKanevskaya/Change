package android.start.change;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class Shekels extends AppCompatActivity {

  private   Double rateInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shekels2);

        Intent intent = getIntent();
        Currency co = Singleton.makeArray().getArray().get(intent.getIntExtra("objId",0));

        rateInt = Double.valueOf(co.getRate()) ;

    }


    public void change(View v) {

        EditText et = (EditText) findViewById(R.id.editText);
        String a = et.getText().toString();

        if (!a.equals("")) {
            int val = Integer.valueOf(a);

            TextView tv = (TextView) findViewById(R.id.textView);

            RadioGroup rg = (RadioGroup) findViewById(R.id.rg);
            switch (rg.getCheckedRadioButtonId()) {
                case R.id.rbFromShekel:
                    String valFromShekel = "" + (val / rateInt);
                    tv.setText(valFromShekel);
                    break;
                case R.id.rbToShekel:
                    String valtoShekel = "" + (val * rateInt);
                    tv.setText(valtoShekel);
                    break;
            }
        } else Toast.makeText(getApplicationContext(), "input value please",
                Toast.LENGTH_SHORT).show();
    }

    public void back(View view) {
        finish();
    }
}


