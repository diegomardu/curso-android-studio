package com.example.cursoudemy.activity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cursoudemy.R;
import com.example.cursoudemy.activity.model.Postagem;

import java.util.List;

public class PostagemAdapter extends RecyclerView.Adapter<MyViewHolderPostagem> {

    private List<Postagem> postagens;

    public PostagemAdapter(List<Postagem> postagens){
        this.postagens = postagens;
    }


    @NonNull
    @Override
    public MyViewHolderPostagem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_postagem, parent, false);
        return new MyViewHolderPostagem(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderPostagem holder, int position) {

        Postagem postagem = postagens.get(position);

        holder.textNome.setText(postagem.getNome());
        holder.textPostagem.setText(postagem.getComentario());
        holder.imagePostagem.setImageResource(postagem.getImagem());

    }

    @Override
    public int getItemCount() {
        return postagens.size();
    }
}
