package com.aztlan.test0.main.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.aztlan.test0.R;

public class MainViewHolder  extends RecyclerView.ViewHolder {
    private final String TAG = "MAINVIEWHOLDER";
    public CardView cv;
    public TextView id;
    public TextView title;

    public MainViewHolder(View view) {
        super(view);
        cv = view.findViewById(R.id.cv);
        id = view.findViewById(R.id.id);
        title = view.findViewById(R.id.title);
    }
}