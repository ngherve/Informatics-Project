package com.uj.ifm.typ.mobileprototype;

import android.content.DialogInterface;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class EditItemsActivity extends AppCompatActivity implements View.OnClickListener {

    private Spinner eItem;
    private Button btnEdit, btnDelete, btnSearch, btnscan;
    public static TextView txtresult;
    public static JSONObject jsonRes;
    public static Product p = null;
    private ArrayList<String> products = new ArrayList<>();
    private static String results, code;
    public static boolean isEdit = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edititems);

        eItem = (Spinner) findViewById(R.id.etitem);
        products.add("Select an Item");
        QueryProducts();
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(EditItemsActivity.this,
                android.R.layout.simple_list_item_1, products);
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        eItem.setAdapter(myAdapter);
        eItem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        txtresult = (TextView) findViewById(R.id.tresults);
        txtresult.setOnClickListener(this);

        btnEdit = (Button) findViewById(R.id.btnedit);
        btnEdit.setOnClickListener(this);

        btnDelete = (Button) findViewById(R.id.btndelete);
        btnDelete.setOnClickListener(this);

        btnSearch = (Button) findViewById(R.id.btnsearch);
        btnSearch.setOnClickListener(this);

        btnscan = (Button) findViewById(R.id.btnsearchscan);
        btnscan.setOnClickListener(this);
    }


    public void QueryProducts(){
        StringRequest strRequest = new StringRequest(Request.Method.POST, ServerRequests.REQUEST_URL + "QueryProducts.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONArray jsonarray = new JSONArray(response);
                            for (int i = 0; i < jsonarray.length(); i++) {
                                JSONObject jsonRes = jsonarray.getJSONObject(i);
                                products.add(jsonRes.getString("P_Code") + " (" + jsonRes.getString("P_Name") + ")");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(EditItemsActivity.this, "Try Again" + e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(EditItemsActivity.this, "Try Again! " + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                return params;
            }
        };

        RequestQueue reqQue = Volley.newRequestQueue(EditItemsActivity.this);
        reqQue.add(strRequest);
    }

    public void backAction(View view) {
        Intent intent2 = new Intent(EditItemsActivity.this, HomeActivity.class);
        intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent2);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btndelete:
                AlertDialog builder = new AlertDialog.Builder(EditItemsActivity.this)
                        .setTitle("Delete Item")
                        .setMessage("Are you sure?")
                        .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                        code = eItem.getSelectedItem().toString();
                        StringTokenizer st = new StringTokenizer(code);
                        code = st.nextToken();
                        Response.Listener<String> respList = new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                try{
                                    JSONObject jsonRes = new JSONObject(response);
                                    boolean success = jsonRes.getBoolean("success");

                                    if(success){
                                        results = jsonRes.toString();
                                        txtresult.setText("Item Deleted Successfully!!! : " + results);
                                        code = eItem.getSelectedItem().toString();
                                        products.remove(code);
                                        Toast.makeText(EditItemsActivity.this, "Item Deleted Successfully!!! !", Toast.LENGTH_LONG).show();

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
                    }
                    })
            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // do nothing
                        }
                    })
            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();

                break;
            case R.id.btnsearch:
                code = eItem.getSelectedItem().toString();
                StringTokenizer st = new StringTokenizer(code);
                code = st.nextToken();
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
                                String bin_location = jsonRes.getString("bin_location");
                                p = new Product(userID, P_Name, P_Price, P_Image, P_Quantity, Supplier_Name, P_Type, W_Name, P_Code, bin_location);

                                String formatted = userID+": Name: "+P_Name+"" +
                                        " Price: "+P_Price+"\nQuantity: "+P_Quantity+" Supplier Name: " + Supplier_Name
                                        +"\nType: "+P_Type+" Warehouse: "+W_Name+"\nCode: " + P_Code+" ImageURL: "+ P_Image
                                        + "\nLocation: " + bin_location;
                                txtresult.setText(formatted);
                                Toast.makeText(EditItemsActivity.this, "Item Found!! !", Toast.LENGTH_LONG).show();

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

                if(p!=null) {
                    Intent intent = new Intent(EditItemsActivity.this, EditActivity.class);
                    intent.putExtra("P_Name", p.getP_Name());
                    intent.putExtra("P_Price", String.valueOf(p.getP_Price()));
                    intent.putExtra("P_Image", p.getP_Image());
                    intent.putExtra("P_Quantity", String.valueOf(p.getP_Quantity()));
                    intent.putExtra("Supplier_Name", p.getSupplier_Name());
                    intent.putExtra("P_Type", p.getP_Type());
                    intent.putExtra("W_Name", p.getW_Name());
                    intent.putExtra("P_Code", p.getP_Code());
                    intent.putExtra("bin_location", p.getBin_location());
                    EditItemsActivity.this.startActivity(intent);
                }else{
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(EditItemsActivity.this);
                    builder2.setMessage("Please search product!!").setNegativeButton("Retry", null).create().show();
                }
                break;
            case R.id.btnsearchscan:
                EditItemsActivity.isEdit=true;
                startActivity(new Intent(EditItemsActivity.this, ScannerSearchActivity.class));
                break;
        }
    }
}
