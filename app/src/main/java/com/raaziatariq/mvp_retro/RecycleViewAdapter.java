package com.raaziatariq.mvp_retro;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {
    private List<GitHubRepo> values;
    private Context context;
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public MyViewHolder(View v) {
            super(v);
            mTextView = v.findViewById(R.id.text_item);
        }
    }

    public RecycleViewAdapter(List<GitHubRepo> values) {

        this.values = values;
    }
//    public RecycleViewAdapter(Context context, List<GitHubRepo> values) {
//        this.context = context;
//       this.values = values;
//    }
//
//    public void setRepoList(List<GitHubRepo> values) {
//        this.values = values;
//        notifyDataSetChanged();
//    }

    @Override
    public RecycleViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_pagination_item, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
         GitHubRepo item = values.get(position);
        String message = item.getName();
        holder.mTextView.setText(message);
    }

    @Override
    public int getItemCount() {
      return this.values.size();
    }
}