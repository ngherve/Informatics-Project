package com.uj.ifm.typ.mobileprototype;

import android.content.Intent;
import android.os.Bundle;
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


public class TaskActivity extends AppCompatActivity {

    private String task, datetime;
    private Spinner spSelectTask;
    private Button btnInitTask;
    private TextView edViewTasks, txtresult;
    private ArrayList<String> tasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        spSelectTask = (Spinner) findViewById(R.id.spselecttask);
        edViewTasks = (TextView) findViewById(R.id.txtTasks);
        btnInitTask = (Button) findViewById(R.id.btnInitiateTask);
        //txtresult = (TextView) findViewById(R.id.txtTaskResult);

        tasks = new ArrayList<>();
        tasks.add("Select a Task");

        StringRequest strRequest = new StringRequest(Request.Method.POST, ServerRequests.REQUEST_URL + "GetTasks.php",
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonarray = new JSONArray(response);

                            String message = "";
                            int count = 0;
                            for (int i = 0; i < jsonarray.length(); i++) {
                                final JSONObject jsonRes = jsonarray.getJSONObject(i);
                                String uID = jsonRes.getString("UserID");
                                String status = jsonRes.getString("Status");
                                if(uID.equals(String.valueOf(LoginActivity.userID)) && !status.equals("done")) {
                                    count++;
                                    message += count + "- Task "+ jsonRes.getString("Task_ID") +": " + jsonRes.getString("TaskContent") + "\n" +
                                            "Task Type: " + jsonRes.getString("T_Type") + "\n" +
                                            "Status: " + status + "\n" +
                                            "Priority: " + jsonRes.getString("Priority") + "\n" +
                                            "Issue Date: " + jsonRes.getString("Start_Date") + "\n";
                                    tasks.add(jsonRes.getString("Task_ID") + " (" + jsonRes.getString("TaskContent") + ")");
                                }
                            }
                            edViewTasks.setText(message);
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(TaskActivity.this, "Try Again" + e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(TaskActivity.this, "Try Again! " + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                return params;
            }
        };

        RequestQueue reqQue = Volley.newRequestQueue(TaskActivity.this);
        reqQue.add(strRequest);


        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(TaskActivity.this,
                android.R.layout.simple_list_item_1, tasks);
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spSelectTask.setAdapter(myAdapter);
        spSelectTask.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnInitTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                task = spSelectTask.getSelectedItem().toString();
                if(!task.equals("Select a Task")) {
                    StringTokenizer st = new StringTokenizer(task);
                    task = st.nextToken();

                    Calendar c = Calendar.getInstance();
                    SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    datetime = dateformat.format(c.getTime());

                    startActivity(new Intent(getApplicationContext(), ScannerActivity.class));
                    //txtresult.setText("Task successfully Completed");

                    DoTask();
                } else {
                    Toast.makeText(TaskActivity.this, "Please Select a task!!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void DoTask(){
        StringRequest strRequest = new StringRequest(Request.Method.POST, ServerRequests.REQUEST_URL + "DoTask.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonRes = new JSONObject(response);

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(TaskActivity.this, "Try Again" + e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(TaskActivity.this, "Try Again! " + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("Task_ID", task);
                params.put("End_Date", datetime);
                params.put("Status", "done");
                return params;
            }
        };

        RequestQueue reqQue = Volley.newRequestQueue(TaskActivity.this);
        reqQue.add(strRequest);
    }

    public void backAction(View view) {
        super.onBackPressed();
    }

}