package com.aztlan.test0.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.aztlan.test0.R;
import com.aztlan.test0.details.DetailsActivity;
import com.aztlan.test0.main.adapter.RecyclerAdapter;
import com.aztlan.test0.main.model.ObjectBean;
import com.aztlan.test0.utils.AppConstants;
import com.aztlan.test0.webservices.VolleyManager;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MAINACTIVITY";
    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private ProgressBar progressBar;
    private VolleyManager volleyManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        volleyManager = new VolleyManager();
        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);

        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(llm);

        try {
            if(isConnected())
                volleyManager.getServiceData(this);
            else{
                Toast.makeText(this, getString(R.string.error_internet), Toast.LENGTH_SHORT).show();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getResponse(int responseCode, List<ObjectBean> objectBeanList){
        if (responseCode == 200){
            adapter = new RecyclerAdapter(this, objectBeanList);
            recyclerView.setAdapter(adapter);
        }
        else
            Toast.makeText(getApplicationContext(), getString(R.string.error_server), Toast.LENGTH_SHORT).show();
    }

    public void goToDetails(ObjectBean objectBean){
        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
        intent.putExtra(AppConstants.OBJECT_DETAILS, objectBean);
        startActivity(intent);
    }

    public boolean isConnected() throws InterruptedException, IOException {
        String command = "ping -c 1 google.com";
        return (Runtime.getRuntime().exec (command).waitFor() == 0);
    }
}