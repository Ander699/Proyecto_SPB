package com.ejemplo.proyecto_spb.negocio.service;

import com.ejemplo.proyecto_spb.negocio.model.Curso;
import com.ejemplo.proyecto_spb.negocio.model.Ocupacion;
import com.ejemplo.proyecto_spb.persistence.repository.RepositorioCursos;
import com.ejemplo.proyecto_spb.persistence.repository.RepositorioMatriculas;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

@Service
public class ServicioCursos {

    private static final double PRECIO_ECONOMICO = 200_000;

    private final RepositorioCursos repositorio;
    private final RepositorioMatriculas repositorioMatriculas;

    public ServicioCursos(RepositorioCursos repositorio, RepositorioMatriculas repositorioMatriculas) {
        this.repositorio = repositorio;
        this.repositorioMatriculas = repositorioMatriculas;
    }

    public Curso registrar(Curso curso) {
        if (curso.getPrecio() <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor que cero");
        }
        if (curso.getCupoMaximo() <= 0) {
            throw new IllegalArgumentException("El cupo máximo debe ser mayor que cero");
        }
        return repositorio.guardar(curso);
    }

    public List<Curso> listar() {
        return repositorio.listar();
    }

    public List<Curso> listarEconomicos() {
        List<Curso> economicos = new ArrayList<>();
        for (Curso curso : repositorio.listar()) {
            if (curso.getPrecio() < PRECIO_ECONOMICO) {
                economicos.add(curso);
            }
        }
        return economicos;
    }

    public Curso obtener(Long id) {
        return repositorio.buscarPorId(id)
                .orElseThrow(() -> new NoSuchElementException("No existe el curso " + id));
    }

    public Ocupacion calcularOcupacion(Long id) {
        Curso curso = obtener(id);
        int matriculados = repositorioMatriculas.contarPorCurso(id);
        int disponibles = curso.getCupoMaximo() - matriculados;
        double porcentaje = (double) matriculados / curso.getCupoMaximo() * 100;
        porcentaje = Math.round(porcentaje * 100.0) / 100.0;
        return new Ocupacion(curso.getNombre(), curso.getCupoMaximo(), matriculados, disponibles, porcentaje);
    }
}
