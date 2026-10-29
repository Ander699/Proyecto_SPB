package com.ejemplo.proyecto_spb.persistence.repository;

import com.ejemplo.proyecto_spb.negocio.model.Curso;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioCursosEnMemoria implements RepositorioCursos {

    private final List<Curso> cursos = new ArrayList<>();
    private long siguienteId = 1;

    @Override
    public Curso guardar(Curso curso) {
        curso.setId(siguienteId++);
        cursos.add(curso);
        return curso;
    }

    @Override
    public List<Curso> listar() {
        return new ArrayList<>(cursos);
    }

    @Override
    public Optional<Curso> buscarPorId(Long id) {
        for (Curso curso : cursos) {
            if (curso.getId().equals(id)) {
                return Optional.of(curso);
            }
        }
        return Optional.empty();
    }
}
