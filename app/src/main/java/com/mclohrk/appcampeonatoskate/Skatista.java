package com.mclohrk.appcampeonatoskate;

public class Skatista {

    private Integer id;
    private String nome;
    private String paiz;

    public Skatista() {
    }

    public Skatista(Integer id, String nome, String paiz) {
        this.id = id;
        this.nome = nome;
        this.paiz = paiz;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPaiz() {
        return paiz;
    }

    public void setPaiz(String paiz) {
        this.paiz = paiz;
    }

    @Override
    public String toString() {
        return nome;
    }


}
