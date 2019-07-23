package com.uj.ifm.typ.mobileprototype;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class StockActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnRegister;
    EditText eName, eDOB, eEmail, ePassword, eUsername, eAdress, ePhone, eGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock);


        
    }

    @Override
    public void onClick(View v) {

    }
}
