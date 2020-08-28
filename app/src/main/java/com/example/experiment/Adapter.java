package com.example.experiment;


import android.content.Context;
import android.graphics.Color;
import android.transition.Slide;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ncorti.slidetoact.SlideToActView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    Context context;
    ArrayList<String> title;
    Set<Integer> itemClicked;

    public Adapter(Context context, ArrayList<String> title) {
        this.context = context;
        this.title = title;
        this.itemClicked = new HashSet<>();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_sample, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        switch (position) {
            case 0:
            case 3:
            case 6:
                holder.imageView.setImageResource(R.drawable.x);
                break;
            case 1:
            case 4:
            case 7:
                holder.imageView.setImageResource(R.drawable.y);
                break;
            case 2:
            case 5:
                holder.imageView.setImageResource(R.drawable.z);
                break;
            case 8:
                holder.imageView.setImageResource(R.drawable.z);
                break;
        }

        if (itemClicked.contains(position)) {
            holder.button.setTextColor(Color.RED);
        } else {
            holder.button.setTextColor(Color.BLACK);
        }

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (itemClicked.contains(position)) {
                    itemClicked.remove(position);
                } else {
                    itemClicked.add(position);
                }
                notifyItemChanged(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return title.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        SlideToActView button;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            button = itemView.findViewById(R.id.slide_button);
        }
    }
}