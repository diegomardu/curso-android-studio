package com.example.cursoudemy.activity.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cursoudemy.R;

public class MyViewHolderPostagem extends RecyclerView.ViewHolder {

    TextView textNome;
    TextView textPostagem;
    ImageView imagePostagem;



    public MyViewHolderPostagem(@NonNull View itemView) {
        super(itemView);
        this.textNome = itemView.findViewById(R.id.textNome);
        this.textPostagem = itemView.findViewById(R.id.textPostagem);
        this.imagePostagem = itemView.findViewById(R.id.imagePostagem);
    }
}
