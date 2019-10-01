package com.uj.ifm.typ.mobileprototype;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;
import com.android.volley.*;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.*;

public class NotifictionActivity extends AppCompatActivity{

    Button btnSend;
    EditText txtMessage;
    TextView txtResult;
    Spinner txtName;
    String datetime;

    private int ReceiverID = 2;
    private String name= "";
    String email = "";

    ArrayList<String> emails = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifiction);

        txtMessage = (EditText)findViewById(R.id.notmessage);

        txtName = (Spinner)findViewById(R.id.notifyname);
        emails.add("Select User");
        QueryEmails();
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(NotifictionActivity.this,
                android.R.layout.simple_list_item_1, emails);
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        txtName.setAdapter(myAdapter);
        txtName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                email = txtName.getSelectedItem().toString();
                StringTokenizer st = new StringTokenizer(email, " ");
                email = st.nextToken();
                GetUsers(email);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnSend = findViewById(R.id.btnSendMessage);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //email = txtName.getSelectedItem().toString();
                //StringTokenizer st = new StringTokenizer(email, " ");
                //email = st.nextToken();
                //GetUsers(email);

                String id = Integer.toString(ReceiverID);

                Calendar c = Calendar.getInstance();
                SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                datetime = dateformat.format(c.getTime());

                senmes(id);

            }
        });
    }

    public void QueryEmails(){
        StringRequest strRequest = new StringRequest(Request.Method.POST, ServerRequests.REQUEST_URL + "QueryUsers.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONArray jsonarray = new JSONArray(response);
                            for (int i = 0; i < jsonarray.length(); i++) {
                                JSONObject jsonRes = jsonarray.getJSONObject(i);
                                emails.add(jsonRes.getString("Email") + " (" + jsonRes.getString("User_Type") + ")");
                            }
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
                return params;
            }
        };

        RequestQueue reqQue = Volley.newRequestQueue(NotifictionActivity.this);
        reqQue.add(strRequest);
    }


    public void backAction(View view) {
        Intent intent2 = new Intent(NotifictionActivity.this, HomeActivity.class);
        intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent2);
    }

    public void GetUsers(final String email){
        StringRequest strRequest = new StringRequest(Request.Method.POST, ServerRequests.REQUEST_URL + "QueryUsers.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONArray jsonarray = new JSONArray(response);
                            for (int i = 0; i < jsonarray.length(); i++) {

                                JSONObject jsonRes = jsonarray.getJSONObject(i);
                                if(jsonRes.getString("Email").equals(email)) {
                                    ReceiverID = jsonRes.getInt("UserID");
                                    name = jsonRes.getString("Name");
                                }
                            }
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
                return params;
            }
        };

        RequestQueue reqQue = Volley.newRequestQueue(NotifictionActivity.this);
        reqQue.add(strRequest);

    }

    public void senmes(final String id){
        StringRequest strRequest = new StringRequest(Request.Method.POST, ServerRequests.REQUEST_URL + "SendNotification.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonRes = new JSONObject(response);
                            AlertDialog.Builder builder = new AlertDialog.Builder(NotifictionActivity.this);
                            builder.setMessage("Your Message has been successfully sent to "  + name)
                                    .setNegativeButton("Ok", null).create().show();

                            Toast.makeText(NotifictionActivity.this, "Your Message has been successfully sent to "  + name, Toast.LENGTH_LONG).show();
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
                params.put("UserID", id);
                params.put("Message", txtMessage.getText().toString());
                params.put("N_Datetime", datetime);
                params.put("N_Email", LoginActivity.email);
                return params;
            }
        };

        RequestQueue reqQue = Volley.newRequestQueue(NotifictionActivity.this);
        reqQue.add(strRequest);
    }

}