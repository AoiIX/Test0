package com.aztlan.test0.main.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aztlan.test0.R;
import com.aztlan.test0.details.DetailsActivity;
import com.aztlan.test0.main.MainActivity;
import com.aztlan.test0.main.model.ObjectBean;
import com.aztlan.test0.utils.AppConstants;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<MainViewHolder> {
    private final String TAG = "RECYCLERADAPTER";
    private List<ObjectBean> objectBeanList;
    private final int TITLE_LENGTH = 18;
    private Context context;

    public RecyclerAdapter(Context context, List<ObjectBean> objectBeanList){
        this.objectBeanList = objectBeanList;
        this.context = context;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_listview_item, parent, false);
        MainViewHolder viewHolder = new MainViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder viewHolder, final int position) {
        viewHolder.id.setText(context.getString(R.string.id) + String.valueOf(objectBeanList.get(position).id));
        String title = objectBeanList.get(position).title;
        viewHolder.title.setText(title.length() > TITLE_LENGTH? title.substring(1,TITLE_LENGTH) + "...": title);

        viewHolder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)context).goToDetails(objectBeanList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return objectBeanList.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
