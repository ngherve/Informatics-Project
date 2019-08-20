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

public class ScannerSearchActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    public String qrResult;
    private String P_Name, P_Price, P_Image, P_Quantity, P_Type, Supplier_Name, W_Name, P_Code, bin_location;

    public static String result;

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

        if (Build.VERSION.SDK_INT >= 26) {
            vibrator.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));
        }else {
            vibrator.vibrate(200);
        }

        StringTokenizer st = new StringTokenizer(qrResult, "\n");

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
                    try {
                        JSONObject jsonRes = new JSONObject(response);
                        boolean success = jsonRes.getBoolean("success");
                            //ScanItemsActivity.resultView.setText("Items Successfully saved!!! :" + qrResult);


                            if (success) {
                                ScanItemsActivity.resultView.setText("Item: " + P_Name + " Code: " + P_Code + " already exists in stock!!!\n");

                                P_Name = jsonRes.getString("P_Name");
                                P_Price = String.valueOf(jsonRes.getInt("P_Price"));
                                P_Image = jsonRes.getString("P_Image");
                                P_Quantity = String.valueOf(jsonRes.getInt("P_Quantity"));
                                Supplier_Name = jsonRes.getString("Supplier_Name");
                                P_Type = jsonRes.getString("P_Type");
                                W_Name = jsonRes.getString("W_Name");
                                P_Code = jsonRes.getString("P_Code");
                                ScannerSearchActivity.result = "Product Info: \nItem: " + P_Name + " Code: " + P_Code + " Price: " +
                                        P_Price + " Quantity: " + P_Quantity + " Supplier: " + Supplier_Name +
                                        " Type: " + P_Type + " Warehouse: " + W_Name + "\nBin Location: " + bin_location;
                                ScanItemsActivity.resultView.append(ScannerSearchActivity.result);

                            } else {
                                ScannerSearchActivity.result = "Item Does not exit in stock!!!\n:" + "Product Info: \nItem: " + P_Name + " Code: " + P_Code + " Price: " +
                                        P_Price + " Quantity: " + P_Quantity + " Supplier: " + Supplier_Name +
                                        " Type: " + P_Type + " Warehouse: " + W_Name + "\nBin Location: " + bin_location;
                                ScanItemsActivity.resultView.setText(ScannerSearchActivity.result);

                            }
                            if(EditItemsActivity.isEdit==true) {
                                EditItemsActivity.txtresult.setText(ScannerSearchActivity.result);
                                EditItemsActivity.isEdit = false;
                            }
                    }catch(JSONException e){
                        e.printStackTrace();
                    }
                }
            };

            ServerRequests loginReq1 = new ServerRequests(P_Code, respList1);
            RequestQueue queue1 = Volley.newRequestQueue(ScannerSearchActivity.this);
            queue1.add(loginReq1);

            super.onBackPressed();
        }
        else{
            AlertDialog.Builder builder = new AlertDialog.Builder(ScannerSearchActivity.this);
            builder.setMessage("Invalid Product Format!!").setNegativeButton("Retry", null).create().show();
            startActivity(new Intent(ScannerSearchActivity.this, ScannerSearchActivity.class));
            super.onBackPressed();

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
