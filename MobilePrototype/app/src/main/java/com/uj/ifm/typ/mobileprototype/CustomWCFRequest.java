package com.uj.ifm.typ.mobileprototype;

import android.app.Activity;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class CustomWCFRequest<T> {

    private Activity mContext;

    public CustomWCFRequest(Activity context){
        this.mContext = context;
    }

    public void execute(int method, String url, Class<T> responseType, Object requestObject,
                        Response.Listener<T> listener, Response.ErrorListener errorListener) {
        url = url.replace(" ", "%20");
        Gson gson = new Gson();
        String json = gson.toJson(requestObject);
        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(json);
        } catch (JSONException e) {
            jsonObject = new JSONObject();
        }
        CustomJsonRequest customRequest = new CustomJsonRequest(method, url, responseType, jsonObject,
                listener, errorListener);
        customRequest.setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        Volley.newRequestQueue(mContext).add(customRequest);
    }

    private class CustomJsonRequest extends JsonRequest<T> {

        private Class<T> mType;
        private String mEncodedCharSetProtocol = "utf-8";

        CustomJsonRequest(int method, String url, Class<T> type, JSONObject jsonRequest,
                          Response.Listener<T> listener, Response.ErrorListener errorListener) {
            super(method, url, (jsonRequest == null) ? null : jsonRequest.toString(), listener,
                    errorListener);
            this.mType = type;
        }


        @Override
        protected Response<T> parseNetworkResponse(NetworkResponse response) {
            try {
                String parsed;
                try {
                    if (mEncodedCharSetProtocol != null) {
                        parsed = new String(response.data, mEncodedCharSetProtocol);
                    } else {
                        parsed = new String(response.data,
                                HttpHeaderParser.parseCharset(response.headers));
                    }
                } catch (UnsupportedEncodingException e) {
                    parsed = new String(response.data);
                }
                Gson gson = new Gson();
                return Response.success(gson.fromJson(parsed, mType),HttpHeaderParser.parseCacheHeaders(response));
            } catch (Throwable e) {
                return Response.error(new ParseError(e));
            }
        }
    }
}