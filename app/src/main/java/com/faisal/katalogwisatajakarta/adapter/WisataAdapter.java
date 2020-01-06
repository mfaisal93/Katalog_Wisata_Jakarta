package com.faisal.katalogwisatajakarta.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.faisal.katalogwisatajakarta.R;
import com.faisal.katalogwisatajakarta.model.Wisata;
import com.faisal.katalogwisatajakarta.view.DetailActivity;

import java.util.ArrayList;

public class WisataAdapter extends RecyclerView.Adapter<WisataAdapter.WisataVIewHolder> {
    private Context context;
    private ArrayList<Wisata> wisatas;

    public WisataAdapter(Context context) {
        this.context = context;
    }

    private ArrayList<Wisata> getWisatas() {
        return wisatas;
    }

    public void setWisatas(ArrayList<Wisata> wisatas) {
        this.wisatas = wisatas;
    }

    @NonNull
    @Override
    public WisataVIewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new WisataVIewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WisataVIewHolder holder, int position) {
        final Wisata wisata = getWisatas().get(position);
        holder.imageView.setImageResource(wisata.getPoster());
        holder.textJudul.setText(wisata.getJudul());
        holder.toDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("wisata",wisata);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getWisatas().size();
    }

    public class WisataVIewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textJudul;
        private CardView toDetail;
        public WisataVIewHolder(@NonNull View itemView) {
            super(itemView);
                imageView = itemView.findViewById(R.id.img);
                textJudul = itemView.findViewById(R.id.tv_judul);
                toDetail = itemView.findViewById(R.id.header);
        }
    }
}
