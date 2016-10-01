package com.uniquexiaobai.androiddemos.recyclerviewwidget;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private List<String> lists;
    private List<Integer> heights;

    public MyAdapter(List<String> lists) {
        this.lists = lists;
        getRandomHeight(lists);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_view, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        ViewGroup.LayoutParams params = holder.itemView.getLayoutParams();
        params.height = heights.get(position);
        holder.itemView.setLayoutParams(params);

        holder.tvName.setText(lists.get(position));
    }

    private void getRandomHeight(List<String> lists) {
        heights = new ArrayList<>();
        for(int i=0; i<lists.size(); i++) {
            heights.add((int)(200+Math.random()*400));
        }
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder {
    TextView tvName;

    public MyViewHolder(View itemView) {
        super(itemView);
        tvName = (TextView) itemView.findViewById(R.id.tvName);
    }
}