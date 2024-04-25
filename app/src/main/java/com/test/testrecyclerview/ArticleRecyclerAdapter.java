package com.test.testrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ArticleRecyclerAdapter extends RecyclerView.Adapter<ArticleRecyclerAdapter.MyViewHolder> {
    Context context;
    ArrayList<ArticleModel> articleModelArrayList;

    public ArticleRecyclerAdapter(Context context, ArrayList<ArticleModel> articleModelArrayList) {
        this.context = context;
        this.articleModelArrayList = articleModelArrayList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_articles, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_title.setText(articleModelArrayList.get(position).title);
        holder.tv_description.setText(articleModelArrayList.get(position).description);

    }

    @Override
    public int getItemCount() {
        return articleModelArrayList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_title;
        private TextView tv_description;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_description = itemView.findViewById(R.id.tv_description);
        }
    }

}
