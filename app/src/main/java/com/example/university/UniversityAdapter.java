package com.example.university;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UniversityAdapter extends RecyclerView.Adapter<UniversityAdapter.UniversityViewHolder>{

    ArrayList<UniversityView> university;
    private Context context;

    public UniversityAdapter(ArrayList<UniversityView> university, Context context) {
        this.university = university;
        this.context = context;
    }

    @NonNull
    @Override
    public UniversityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_university, null, false);
        UniversityViewHolder uh = new UniversityViewHolder(v);
        return uh;
    }

    @Override
    public void onBindViewHolder(@NonNull UniversityViewHolder holder, int position) {
        UniversityView us = university.get(position);
        holder.tv_name.setText(us.getTv_name());
        holder.img.setImageDrawable(us.getImg());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View v, int position) {
                //click on card view

            }
        });

    }

    @Override
    public int getItemCount() {
        return university.size();
    }

    class UniversityViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tv_name;
        ImageView img;
        ItemClickListener itemClickListener;

        public UniversityViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.card_tv);
            img     = itemView.findViewById(R.id.card_img);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            this.itemClickListener.onItemClickListener(v, getLayoutPosition());
        }

        public void setItemClickListener(ItemClickListener ic){
            this.itemClickListener = ic;
        }
    }

}
