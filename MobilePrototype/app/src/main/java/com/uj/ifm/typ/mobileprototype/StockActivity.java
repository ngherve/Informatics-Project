package com.uj.ifm.typ.mobileprototype;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StockActivity extends AppCompatActivity {

    private MenuItem menuItemSearch;
    private MenuItem menuItemDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        Response.Listener<String> respList = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try{
                    ArrayList<Product> products = new ArrayList<Product>();
                    JSONArray jsonarray = new JSONArray(response);
                    for(int i=0; i<jsonarray.length(); i++) {
                        JSONObject jsonRes = jsonarray.getJSONObject(i);

                        int P_ID = Integer.parseInt(jsonRes.getString("P_ID"));
                        String P_Name = jsonRes.getString("P_Name");
                        int P_Price = Integer.parseInt(jsonRes.getString("P_Price"));
                        String P_Image = jsonRes.getString("P_Image");
                        int P_Quantity = Integer.parseInt(jsonRes.getString("P_Quantity"));
                        String Supplier_Name = jsonRes.getString("Supplier_Name");
                        String P_Type = jsonRes.getString("P_Type");
                        String W_Name = jsonRes.getString("W_Name");
                        String P_Code = jsonRes.getString("P_Code");
                        Product product = new Product(P_ID, P_Name, P_Price, P_Image, P_Quantity, Supplier_Name, P_Type, W_Name, P_Code);

                        products.add(product);
                    }

                    List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

                    for (Product p : products) {
                        System.out.println(p.toString());
                        HashMap<String, String> hm = new HashMap<String, String>();
                        hm.put("listview_title", p.getP_Name());
                        hm.put("listview_discription", p.toString());
                        hm.put("listview_image", Integer.toString(R.drawable.person));
                        aList.add(hm);
                    }

                    String[] from = {"listview_image", "listview_title", "listview_discription"};
                    int[] to = {R.id.listview_image, R.id.listview_item_title, R.id.listview_item_short_description};

                    final SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), aList, R.layout.activity_stock, from, to);
                    final ListView androidListView = (ListView) findViewById(R.id.list_view);
                    androidListView.setAdapter(simpleAdapter);

                }catch (JSONException e){
                    e.printStackTrace();
                }
            }
        };

        ServerRequests loginReq = new ServerRequests(respList);
        RequestQueue queue = Volley.newRequestQueue(StockActivity.this);
        queue.add(loginReq);
    }
}
