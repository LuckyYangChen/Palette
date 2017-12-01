package com.example.kevin;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * 作者：Kevin 时间：2017/10/25
 * 类说明：
 */

public class DemoAdapter extends RecyclerView.Adapter<DemoAdapter.MyViewHolder> {

    public DemoAdapter() {
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_text, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DemoAdapter.MyViewHolder holder, int position) {
        holder.tv_text.setText("==========>" + (position + 1) + "<==========");
    }

    @Override
    public int getItemCount() {
        return 60;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_text;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_text = (TextView) itemView.findViewById(R.id.tv_text);
        }
    }
}
