package com.ejemplo.proyecto_spb.negocio.model;

/* primera Clase

 */

public class Curso {

    private Long id;
    private String nombre;
    private double precio;
    private int cupoMaximo;

    public Curso(String nombre, double precio, int cupoMaximo) {
        this.nombre = nombre;
        this.precio = precio;
        this.cupoMaximo = cupoMaximo;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getCupoMaximo() { return cupoMaximo; }
}
