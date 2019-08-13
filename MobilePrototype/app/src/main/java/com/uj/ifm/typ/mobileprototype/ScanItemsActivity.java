package com.uj.ifm.typ.mobileprototype;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScanItemsActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * Called when the activity is first created.
     */
    public static TextView resultView = null;

    Button btnscan;
    public static boolean issearch2 = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanitems);
        resultView = (TextView) findViewById(R.id.textView2);
        resultView.setText("");
        btnscan = (Button) findViewById(R.id.scanner);
        btnscan.setOnClickListener(this);


    }

    public void backAction(View view) {
        super.onBackPressed();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.scanner:

                if(HomeActivity.isSearch==true && ScanItemsActivity.issearch2 == true) {
                    startActivity(new Intent(getApplicationContext(), ScannerSearchActivity.class));
                    ScanItemsActivity.issearch2 = true;
                }
                else
                    startActivity(new Intent(getApplicationContext(), ScannerActivity.class));
                break;
        }
    }
}
