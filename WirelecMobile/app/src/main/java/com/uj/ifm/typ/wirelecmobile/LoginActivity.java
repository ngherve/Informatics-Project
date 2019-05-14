package com.uj.ifm.typ.wirelecmobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnLogin;
    EditText edUsername, edPassword;
    TextView registerLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edUsername = (EditText) findViewById(R.id.etUsername);
        edPassword = (EditText) findViewById(R.id.etPassword);
        registerLink = (TextView) findViewById(R.id.etregLink);
        registerLink.setOnClickListener(this);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnLogin:

                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                break;
            case R.id.etregLink:

                break;
        }
    }
}
