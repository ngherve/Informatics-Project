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
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;

public class EditQuantActivity<getSim> extends AppCompatActivity implements View.OnClickListener {

    private Bitmap bitmap;
    private String URL_Upload = "http://10.254.17.96:80/script/UploadProduct.php";
    private Button btnSave, btnImage;
    private String image, id;
    private EditText epName, eprice, eQuant, esuppname, ep_type, eW_name, ePCode, newQuant;
    private String P_Name, P_Price, P_Image, P_Quantity, P_Type, Supplier_Name, W_Name, P_Code;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_quant);

        newQuant = (EditText) findViewById(R.id.editetstQuantity2);
        epName = (EditText) findViewById(R.id.editetpName1);
        eprice = (EditText) findViewById(R.id.editetprice1);
        eQuant = (EditText) findViewById(R.id.editetstQuantity1);
        esuppname = (EditText) findViewById(R.id.editetsupp_name1);
        ep_type = (EditText) findViewById(R.id.editetp_type1);
        eW_name = (EditText) findViewById(R.id.editetwarehouse1);
        ePCode = (EditText) findViewById(R.id.editetpcode1);

        btnSave = (Button) findViewById(R.id.editbtnSaveItem1);
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
        String newQuanttity = newQuant.getText().toString();

        int totalQuent = Integer.parseInt(P_Quantity) + Integer.parseInt(newQuanttity);
        id = P_Code;

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonresp = new JSONObject(response);
                    AlertDialog.Builder builder = new AlertDialog.Builder(EditQuantActivity.this);
                    builder.setMessage("The Quantity has been Updated successfully !!!").setNegativeButton("OK", null).create().show();

                } catch (JSONException ex) {
                    ex.printStackTrace();
                }
            }
        };

        ServerRequests request = new ServerRequests(1,1, P_Name, P_Price, Integer.toString(totalQuent), Supplier_Name, P_Type, W_Name, P_Code, responseListener);
        RequestQueue queue = Volley.newRequestQueue(EditQuantActivity.this);
        queue.add(request);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.editbtnback_save1:
                super.onBackPressed();
                break;
            case R.id.editbtnSaveItem1:
                saveItem();
                break;
        }
    }
}
