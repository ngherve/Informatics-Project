package com.uj.ifm.typ.mobileprototype;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
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

public class ViewInvoices extends AppCompatActivity {

    private TextView txtInvoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_inv);

        txtInvoice = (TextView) findViewById(R.id.txtinvoices);
        StringRequest strRequest = new StringRequest(Request.Method.POST, ServerRequests.REQUEST_URL + "QueryInvoices.php",
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonarray = new JSONArray(response);
                            String message = "";
                            int count = 0;
                            for (int i = 0; i < jsonarray.length(); i++) {
                                JSONObject jsonRes = jsonarray.getJSONObject(i);
                                if(String.valueOf(jsonRes.getInt("UserID")).equals(String.valueOf(LoginActivity.userID))) {
                                    count++;
                                    message += count + "- " + jsonRes.getString("P_Code") + "\t" +
                                            "Quantity: " + jsonRes.getInt("Quantity") + "\t" +
                                            //"Tot Price: R" + jsonRes.getInt("Total_Price") + "\t" +
                                            //"User: " + jsonRes.getString("UserID") + "\t" +
                                            "Date: " + jsonRes.getString("INV_Date") + "\n"+
                                            "Invoice Type: " + jsonRes.getString("Inv_Type") + "\n";

                                }
                            }
                            txtInvoice.setText(message);
                            txtInvoice.setMovementMethod(new ScrollingMovementMethod());
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(ViewInvoices.this, "Try Again" + e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ViewInvoices.this, "Try Again! " + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();

                return params;
            }
        };

        RequestQueue reqQue = Volley.newRequestQueue(ViewInvoices.this);
        reqQue.add(strRequest);

    }

    public void backAction(View view) {
        super.onBackPressed();
    }
}

