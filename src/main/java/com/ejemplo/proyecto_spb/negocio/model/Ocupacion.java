package com.ejemplo.proyecto_spb.negocio.model;

public record Ocupacion(String curso, int cupoMaximo, int matriculados,
                        int cuposDisponibles, double porcentajeOcupacion) {
}
