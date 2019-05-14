package com.uj.ifm.typ.wirelecmobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogout = (Button) findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(this);

    }

    private void displayUserDetails(){
        //Display to the gui
    }


   @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnLogout:

                startActivity(new Intent(this, LoginActivity.class));
                break;
        }
    }
}
