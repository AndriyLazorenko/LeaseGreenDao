package com.example.andriylazorenko.leasegreendao;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.leasegreendao.model.Lease;

import java.util.List;

/**
 * Created by User on 22.09.2015.
 */

public class MainActivityListAdapter extends RecyclerView.Adapter<MainActivityListAdapter.ViewHolder> {

    private List<Lease> mData ;

    public MainActivityListAdapter(List<Lease> subcategoryData) {
        this.mData = subcategoryData;
    }

    @Override
    public int getItemCount(){
        return mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewItem;
        public TextView textViewPersonName;

        public ViewHolder (View itemLayoutView){
            super(itemLayoutView);
            textViewItem = (TextView) itemLayoutView.findViewById (R.id.activity_main_item_item);
            textViewPersonName = (TextView) itemLayoutView.findViewById (R.id.activity_main_item_person_name);

        }

    }
    @Override
    public MainActivityListAdapter.ViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        //create a new view
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_main_item, null);
        //create ViewHolder
        ViewHolder viewHolder = new MainActivityListAdapter.ViewHolder(itemLayoutView);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder (ViewHolder viewHolder, int position){
        viewHolder.textViewItem.setText(mData.get(position).getItem());

        viewHolder.textViewPersonName.setText(mData.get(position).getPerson().getName());
    }
}
