package com.uj.ifm.typ.mobileprototype;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;

public class EditItemsActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText eItem;
    private Button btnEdit, btnDelete, btnSearch;
    public static TextView txtresult;
    public static JSONObject jsonRes;
    public static Product p;
    private static String results, code;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edititems);

        eItem = (EditText) findViewById(R.id.etitem);
        eItem.setOnClickListener(this);

        txtresult = (TextView) findViewById(R.id.tresults);
        txtresult.setOnClickListener(this);

        btnEdit = (Button) findViewById(R.id.btnedit);
        btnEdit.setOnClickListener(this);

        btnDelete = (Button) findViewById(R.id.btndelete);
        btnDelete.setOnClickListener(this);

        btnSearch = (Button) findViewById(R.id.btnsearch);
        btnSearch.setOnClickListener(this);


    }

    public void backAction(View view) {
        super.onBackPressed();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btndelete:
                code = eItem.getText().toString();
                Response.Listener<String> respList = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonRes = new JSONObject(response);
                            boolean success = jsonRes.getBoolean("success");

                            if(success){
                                results = jsonRes.toString();
                                txtresult.setText("Item Deleted Successfully!!! : " + results);

                            } else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(EditItemsActivity.this);
                                builder.setMessage("Product Not Found!!").setNegativeButton("Retry", null).create().show();
                            }
                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                };

                ServerRequests loginReq = new ServerRequests(1,1,code, respList);
                RequestQueue queue = Volley.newRequestQueue(EditItemsActivity.this);
                queue.add(loginReq);
                break;
            case R.id.btnsearch:
                code = eItem.getText().toString();
                Response.Listener<String> respList1 = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonRes = new JSONObject(response);
                            boolean success = jsonRes.getBoolean("success");

                            if(success){
                                results = jsonRes.toString();
                                txtresult.setText(results);
                                int userID = jsonRes.getInt("P_ID");
                                String P_Name = jsonRes.getString("P_Name");
                                int P_Price = jsonRes.getInt("P_Price");
                                String P_Image = jsonRes.getString("P_Image");
                                int P_Quantity = jsonRes.getInt("P_Quantity");
                                String Supplier_Name = jsonRes.getString("Supplier_Name");
                                String P_Type = jsonRes.getString("P_Type");
                                String W_Name = jsonRes.getString("W_Name");
                                String P_Code = jsonRes.getString("P_Code");
                                p = new Product(userID, P_Name, P_Price, P_Image, P_Quantity, Supplier_Name, P_Type, W_Name, P_Code);

                                String formatted = userID+": Name: "+P_Name+"" +
                                        " Price: "+P_Price+"\nQuantity: "+P_Quantity+" Supplier Name: " + Supplier_Name
                                        +"\nType: "+P_Type+" Warehouse: "+W_Name+"\nCode: " + P_Code+" ImageURL: "+ P_Image;
                                txtresult.setText(formatted);
                            } else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(EditItemsActivity.this);
                                builder.setMessage("Product Not Found!!").setNegativeButton("Retry", null).create().show();
                            }
                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                };

                ServerRequests loginReq1 = new ServerRequests(code, respList1);
                RequestQueue queue1 = Volley.newRequestQueue(EditItemsActivity.this);
                queue1.add(loginReq1);
                break;
            case R.id.btnedit:

                Intent intent = new Intent(EditItemsActivity.this, EditActivity.class);
                intent.putExtra("P_Name", p.getP_Name());
                intent.putExtra("P_Price", p.getP_Price());
                intent.putExtra("P_Image", p.getP_Image());
                intent.putExtra("P_Quantity", p.getP_Quantity());
                intent.putExtra("Supplier_Name", p.getSupplier_Name());
                intent.putExtra("P_Type", p.getP_Type());
                intent.putExtra("W_Name", p.getW_Name());
                intent.putExtra("P_Code", p.getP_Code());
                EditItemsActivity.this.startActivity(intent);

                break;
        }
    }
}
