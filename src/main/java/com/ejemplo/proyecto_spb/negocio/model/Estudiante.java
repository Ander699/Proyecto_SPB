package com.ejemplo.proyecto_spb.negocio.model;

public class Estudiante {

    private Long id;
    private String nombre;
    private int edad;
    private String correo;

    public Estudiante(String nombre, int edad, String correo) {
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public String getCorreo() { return correo; }
}
