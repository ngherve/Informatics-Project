package com.uj.ifm.typ.mobileprototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class NotifyActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnviewnot:
                startActivity(new Intent(NotifyActivity.this, ViewNotifications.class));
                break;
            case R.id.btnnotuser:
                startActivity(new Intent(NotifyActivity.this, NotifictionActivity.class));
                break;
        }
    }
}
