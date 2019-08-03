package com.uj.ifm.typ.mobileprototype;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.*;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class NotifictionActivity extends AppCompatActivity implements  View.OnClickListener {

    Button btnSend;
    EditText txtName, txtMessage;
    TextView txtResult;
    String datetime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifiction);
        btnSend = (Button) findViewById(R.id.btnSendMessage);
        btnSend.setOnClickListener(this);

        txtName = (EditText)findViewById(R.id.notifyname);
        txtMessage = (EditText)findViewById(R.id.notmessage);

        Calendar c = Calendar.getInstance();
        SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss aa");
        datetime = dateformat.format(c.getTime());
    }

    public void backAction(View view) {
        super.onBackPressed();
    }

    public static int ReceiverID = 0;
    public static String name= "";
    public void GetUsers(final String email){
        StringRequest strRequest = new StringRequest(Request.Method.POST, "http://10.254.17.96:80/script/QueryUsersByEmail.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonRes = new JSONObject(response);
                            ReceiverID = jsonRes.getInt("UserID");
                            name = jsonRes.getString("Name");
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(NotifictionActivity.this, "Try Again" + e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(NotifictionActivity.this, "Try Again! " + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("Email", email);
                return params;
            }
        };

        RequestQueue reqQue = Volley.newRequestQueue(NotifictionActivity.this);
        reqQue.add(strRequest);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSendMessage:
                GetUsers(txtName.getText().toString());
                StringRequest strRequest = new StringRequest(Request.Method.POST, "http://10.254.17.96:80/script/SendNotification.php",
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                try {
                                    JSONObject jsonRes = new JSONObject(response);
                                    AlertDialog.Builder builder = new AlertDialog.Builder(NotifictionActivity.this);
                                    builder.setMessage("Your Message has been successfully sent to "  + name)
                                            .setNegativeButton("Ok", null).create().show();

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                    Toast.makeText(NotifictionActivity.this, "Try Again" + e.toString(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(NotifictionActivity.this, "Try Again! " + error.toString(), Toast.LENGTH_SHORT).show();
                            }
                        }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();
                        params.put("UserID", Integer.toString(ReceiverID));
                        params.put("Message", txtMessage.getText().toString());
                        params.put("N_Datetime", datetime);
                        params.put("N_Email", LoginActivity.email);

                        return params;
                    }
                };

                RequestQueue reqQue = Volley.newRequestQueue(NotifictionActivity.this);
                reqQue.add(strRequest);
                break;
        }
    }
}