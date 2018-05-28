package com.aztlan.test0.details;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.aztlan.test0.R;
import com.aztlan.test0.main.model.ObjectBean;
import com.aztlan.test0.utils.AppConstants;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ObjectBean objectBean = (ObjectBean) getIntent().getSerializableExtra(AppConstants.OBJECT_DETAILS);

        TextView id = findViewById(R.id.id);
        TextView userId = findViewById(R.id.userId);
        TextView title = findViewById(R.id.title);
        TextView body = findViewById(R.id.body);
        Button buttonBack = findViewById(R.id.buttonBack);

        id.setText(getString(R.string.id) + objectBean.id);
        userId.setText(getString(R.string.userId) + objectBean.userId);
        title.setText(objectBean.title);
        body.setText(objectBean.body);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
