package com.example.parcial2.clases;



public class Usuario {
    private String curso;
    private String nombre;

    private String fotoUrl;

    private String descripcion;



    public Usuario(String curso, String nombre, String fotoUrl,String descripcion) {
        this.curso = curso;
        this.nombre = nombre;
        this.fotoUrl = fotoUrl;
        this.descripcion = descripcion;
    }

    public String getCurso() { return curso; }
    public String getNombre() { return nombre; }

    public String getFotoUrl() { return fotoUrl; }

    public String getDescripcion() { return descripcion; }
}

