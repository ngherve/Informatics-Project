package com.uj.ifm.typ.mobileprototype;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.*;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ViewNotifications extends AppCompatActivity {

    private TextView txtMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewnot);

        txtMessage = (TextView) findViewById(R.id.txtmessage);
        StringRequest strRequest = new StringRequest(Request.Method.POST, "http://10.254.17.96:80/script/ViewNotifications.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonarray = new JSONArray(response);
                            String message = "";
                            for (int i = 0; i < jsonarray.length(); i++) {
                                JSONObject jsonRes = jsonarray.getJSONObject(i);
                                message += "- " + jsonRes.getString("Message") + " from user: " + jsonRes.getString("UserID") + "\n";
                            }

                            txtMessage.setText(message);

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(ViewNotifications.this, "Try Again" + e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ViewNotifications.this, "Try Again! " + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                if(LoginActivity.usertype.equals("warehouse"))
                    params.put("UserID", String.valueOf(WarehouseHomeActivity.userIDw));
                else if(LoginActivity.usertype.equals("stock"))
                    params.put("UserID", String.valueOf(HomeActivity.userID));
                return params;
            }
        };

        RequestQueue reqQue = Volley.newRequestQueue(ViewNotifications.this);
        reqQue.add(strRequest);

    }

    public void backAction(View view) {
        super.onBackPressed();
    }
}

