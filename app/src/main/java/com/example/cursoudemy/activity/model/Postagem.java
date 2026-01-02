package com.example.cursoudemy.activity.model;

public class Postagem {

    private String nome;
    private String comentario;
    private int imagem;

    public Postagem(String nome) {
        this.nome = nome;
    }

    public Postagem(String nome, String comentario, int imagem) {
        this.nome = nome;
        this.comentario = comentario;
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }
}


