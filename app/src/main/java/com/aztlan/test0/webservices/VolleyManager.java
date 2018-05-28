package com.aztlan.test0.webservices;

import android.content.Context;
import android.util.Log;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.aztlan.test0.main.MainActivity;
import com.aztlan.test0.main.model.ObjectBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VolleyManager {
    private final String TAG = "VOLLEYMANAGER";

    public void getServiceData(final Context context) {
        String URL_SERVICE = "https://jsonplaceholder.typicode.com/posts";
        final int[] count = {0};

        Log.d(TAG, "URL Z = " + URL_SERVICE);
        StringRequest myReq = new StringRequest(Request.Method.GET, URL_SERVICE, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("COSA", "RESPONSE = " + response);

                Gson gson = new Gson();
                List<ObjectBean> objectBeans = gson.fromJson(response, new TypeToken<List<ObjectBean>>(){}.getType());

                ((MainActivity)context).getResponse(200, objectBeans);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                ((MainActivity)context).getResponse(404, new ArrayList<ObjectBean>());
            }
        }) {
            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                return super.parseNetworkResponse(response);
            }
        };

        RequestSingleton.getInstance(context).addToRequestQueue(myReq);
    }
}