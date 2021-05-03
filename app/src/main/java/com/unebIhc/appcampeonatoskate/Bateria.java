package com.unebIhc.appcampeonatoskate;

public class Bateria {
    private  Integer id;
    private String skatista;
    private String nome;

    public Bateria() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSkatista() {
        return skatista;
    }

    public void setSkatista(String skatista) {
        this.skatista = skatista;
    }

    @Override
    public String toString(){
        return nome;
    }
}
