package com.uj.ifm.typ.mobileprototype;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class DispatchActivity<getSim> extends AppCompatActivity implements View.OnClickListener {

    private Bitmap bitmap;
    private String URL_Upload = ServerRequests.REQUEST_URL + "UploadProduct.php";
    private Button btnSave, btnImage;
    private String image, id;
    private EditText epName, eprice, eQuant, esuppname, ep_type, eW_name, ePCode, newQuant;
    private String P_Name, P_Price, P_Image, P_Quantity, P_Type, Supplier_Name, W_Name, P_Code;
    private String datetime, newQuanttity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispatch);

        Calendar c = Calendar.getInstance();
        SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss aa");
        datetime = dateformat.format(c.getTime());

        newQuant = (EditText) findViewById(R.id.editetstQuantity21);
        epName = (EditText) findViewById(R.id.editetpName11);
        eprice = (EditText) findViewById(R.id.editetprice11);
        eQuant = (EditText) findViewById(R.id.editetstQuantity11);
        esuppname = (EditText) findViewById(R.id.editetsupp_name11);
        ep_type = (EditText) findViewById(R.id.editetp_type11);
        eW_name = (EditText) findViewById(R.id.editetwarehouse11);
        ePCode = (EditText) findViewById(R.id.editetpcode11);

        btnSave = (Button) findViewById(R.id.editbtnSaveItem11);
        btnSave.setOnClickListener(this);

        Intent intent = getIntent();
        P_Name = intent.getStringExtra("P_Name");
        P_Price = intent.getStringExtra("P_Price");
        P_Quantity = intent.getStringExtra("P_Quantity");
        Supplier_Name = intent.getStringExtra("Supplier_Name");
        P_Type = intent.getStringExtra("P_Type");
        W_Name = intent.getStringExtra("W_Name");
        P_Code = intent.getStringExtra("P_Code");

        epName.setText(P_Name);
        eprice.setText(P_Price);
        image = intent.getStringExtra("P_Image");
        eQuant.setText(P_Quantity);
        esuppname.setText(Supplier_Name);
        ep_type.setText(P_Type);
        eW_name.setText(W_Name);
        ePCode.setText(P_Code);

        epName.setEnabled(false);
        epName.setInputType(InputType.TYPE_NULL);
        eprice.setEnabled(false);
        eprice.setInputType(InputType.TYPE_NULL);
        eQuant.setEnabled(false);
        eQuant.setInputType(InputType.TYPE_NULL);
        esuppname.setEnabled(false);
        esuppname.setInputType(InputType.TYPE_NULL);
        ep_type.setEnabled(false);
        ep_type.setInputType(InputType.TYPE_NULL);
        eW_name.setEnabled(false);
        eW_name.setInputType(InputType.TYPE_NULL);
        ePCode.setEnabled(false);
        ePCode.setInputType(InputType.TYPE_NULL);
    }

    public void backAction(View view) {
        super.onBackPressed();
    }

    public void saveItem(){
        newQuanttity = newQuant.getText().toString();

        int totalQuent = Integer.parseInt(P_Quantity) - Integer.parseInt(newQuanttity);
        id = P_Code;
        if(totalQuent >= 0) {
            Response.Listener<String> responseListener = new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject jsonresp = new JSONObject(response);
                        AlertDialog.Builder builder = new AlertDialog.Builder(DispatchActivity.this);
                        builder.setMessage("The Quantity has been Updated successfully !!!").setNegativeButton("OK", null).create().show();
                        saveInvoice();
                    } catch (JSONException ex) {
                        ex.printStackTrace();
                    }
                }
            };

            ServerRequests request = new ServerRequests(1, 1, P_Name, P_Price, Integer.toString(totalQuent), Supplier_Name, P_Type, W_Name, P_Code, responseListener);
            RequestQueue queue = Volley.newRequestQueue(DispatchActivity.this);
            queue.add(request);
        } else{
            AlertDialog.Builder builder = new AlertDialog.Builder(DispatchActivity.this);
            builder.setMessage("Sorry, the quantity entered is more than the available stock !!!").setNegativeButton("Retry", null).create().show();

        }
    }

    public void saveInvoice(){
        StringRequest strRequest = new StringRequest(Request.Method.POST, ServerRequests.REQUEST_URL + "SaveInvoice.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonRes = new JSONObject(response);
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(DispatchActivity.this, "Try Again" + e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(DispatchActivity.this, "Try Again! " + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("P_Code", P_Code);
                params.put("Quantity", newQuanttity);
                params.put("Total_Price", Integer.toString(Integer.parseInt(newQuanttity)*Integer.parseInt(P_Price)));
                params.put("C_ID", "1");
                params.put("INV_Date", datetime);
                params.put("UserID", Integer.toString(LoginActivity.userID));

                return params;
            }
        };

        RequestQueue reqQue = Volley.newRequestQueue(DispatchActivity.this);
        reqQue.add(strRequest);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.editbtnback_save11:
                super.onBackPressed();
                break;
            case R.id.editbtnSaveItem11:
                saveItem();
                break;
        }
    }
}
