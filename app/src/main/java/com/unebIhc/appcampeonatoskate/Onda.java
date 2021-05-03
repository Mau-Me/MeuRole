package com.unebIhc.appcampeonatoskate;

public class Onda {
    private  Integer id;
    private Skatista skatista;
    private Bateria bateria;


    public Onda() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Skatista getSkatista() {
        return skatista;
    }

    public void setSkatista(Skatista skatista) {
        this.skatista = skatista;
    }

    public Bateria getBateria() {
        return bateria;
    }

    public void setBateria(Bateria bateria) {
        this.bateria = bateria;
    }
}
