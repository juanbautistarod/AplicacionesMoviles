package com.example.appbdtp2.entities;

public class Ciudad {
    private Integer id;
    private String nombre;
    private String pais;
    private Integer poblacion;

    public Ciudad(Integer id, String nombre, String pais, Integer poblacion) {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
        this.poblacion = poblacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Integer getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(Integer poblacion) {
        this.poblacion = poblacion;
    }
}
