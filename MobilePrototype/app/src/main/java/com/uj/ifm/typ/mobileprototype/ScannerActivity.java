package com.uj.ifm.typ.mobileprototype;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.google.zxing.Result;
import me.dm7.barcodescanner.zxing.ZXingScannerView;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.StringTokenizer;

public class ScannerActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    public String qrResult;
    private String P_Name, P_Price, P_Image, P_Quantity, P_Type, Supplier_Name, W_Name, P_Code;

    ZXingScannerView scannerview;
    Vibrator vibrator;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scannerview = new ZXingScannerView(this);
        setContentView(scannerview);
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

    }

    @Override
    public void handleResult(Result result) {
        qrResult = result.getText();
        ScanItemsActivity.resultView.setText(qrResult);

        if (Build.VERSION.SDK_INT >= 26) {
            vibrator.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));
        }else {
            vibrator.vibrate(200);
        }

        StringTokenizer st = new StringTokenizer(qrResult, "\n");
        ScanItemsActivity.resultView.setText("Items Successfully saved!!! :" + qrResult);

        if(st.countTokens()==8)
        {
            P_Name = st.nextToken();
            P_Price = st.nextToken();
            P_Image = st.nextToken();
            P_Quantity = st.nextToken();
            Supplier_Name = st.nextToken();
            P_Type = st.nextToken();
            W_Name = st.nextToken();
            P_Code = st.nextToken();
            //System.out.println(P_Price + " " + P_Quantity);

            Response.Listener<String> respList1 = new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try{
                        JSONObject jsonRes = new JSONObject(response);
                        boolean success = jsonRes.getBoolean("success");

                        if(success && LoginActivity.usertype.equals("stock")){
                            ScanItemsActivity.resultView.setText("Item: " + P_Name + " Code: " + P_Code + " already exists in stock!!!");

                            P_Name = jsonRes.getString("P_Name");
                            P_Price = String.valueOf(jsonRes.getInt("P_Price"));
                            P_Image = jsonRes.getString("P_Image");
                            P_Quantity = String.valueOf(jsonRes.getInt("P_Quantity"));
                            Supplier_Name = jsonRes.getString("Supplier_Name");
                            P_Type = jsonRes.getString("P_Type");
                            W_Name = jsonRes.getString("W_Name");
                            P_Code = jsonRes.getString("P_Code");

                            Intent intent = new Intent(ScannerActivity.this, EditQuantActivity.class);
                            intent.putExtra("P_Name", P_Name);
                            intent.putExtra("P_Price", P_Price);
                            intent.putExtra("P_Image", P_Image);
                            intent.putExtra("P_Quantity", P_Quantity);
                            intent.putExtra("Supplier_Name", Supplier_Name);
                            intent.putExtra("P_Type", P_Type);
                            intent.putExtra("W_Name", W_Name);
                            intent.putExtra("P_Code", P_Code);
                            ScannerActivity.this.startActivity(intent);

                        } else if(success && LoginActivity.usertype.equals("warehouse")){
                            ScanItemsActivity.resultView.setText("Product Info: \nItem: " + P_Name + " Code: " + P_Code + " Price: " +
                                    P_Price + " Quantity: " + P_Quantity + " Supplier: " + Supplier_Name +
                                    " Type: " + P_Type + " Warehouse: " + W_Name);

                        } else if(success==false && LoginActivity.usertype.equals("stock")){
                            Intent intent = new Intent(ScannerActivity.this, SaveItemActivity.class);
                            intent.putExtra("P_Name", P_Name);
                            intent.putExtra("P_Price", P_Price);
                            intent.putExtra("P_Image", P_Image);
                            intent.putExtra("P_Quantity", P_Quantity);
                            intent.putExtra("Supplier_Name", Supplier_Name);
                            intent.putExtra("P_Type", P_Type);
                            intent.putExtra("W_Name", W_Name);
                            intent.putExtra("P_Code", P_Code);
                            ScannerActivity.this.startActivity(intent);
                        }
                    }catch (JSONException e){
                        e.printStackTrace();
                    }
                }
            };

            ServerRequests loginReq1 = new ServerRequests(P_Code, respList1);
            RequestQueue queue1 = Volley.newRequestQueue(ScannerActivity.this);
            queue1.add(loginReq1);

            super.onBackPressed();
        }
        else{
            AlertDialog.Builder builder = new AlertDialog.Builder(ScannerActivity.this);
            builder.setMessage("Invalid Product Format!!").setNegativeButton("Retry", null).create().show();
            startActivity(new Intent(ScannerActivity.this, ScannerActivity.class));
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        scannerview.setResultHandler(this);
        scannerview.startCamera();
    }

    @Override
    protected void onPause() {
        super.onPause();

        scannerview.stopCamera();
    }

}
