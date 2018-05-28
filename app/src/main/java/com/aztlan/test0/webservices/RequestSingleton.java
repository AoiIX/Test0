package com.aztlan.test0.webservices;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

public class RequestSingleton {
    private static Context context;
    private static RequestSingleton singleton;
    private RequestQueue requestQueue;

    private RequestSingleton (final Context context) {
        RequestSingleton.context = context;
        requestQueue = getRequestQueue();
    }


    public static synchronized RequestSingleton getInstance(Context context) {
        if (singleton == null) {
            singleton = new RequestSingleton(context);
        }
        return singleton;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }

        return requestQueue;
    }

    public  void addToRequestQueue(Request req) {
        getRequestQueue().add(req);
    }
}