package com.ejemplo.proyecto_spb.persistence.repository;

import com.ejemplo.proyecto_spb.negocio.model.Curso;
import java.util.List;
import java.util.Optional;

public interface RepositorioCursos {

    Curso guardar(Curso curso);

    List<Curso> listar();

    Optional<Curso> buscarPorId(Long id);
}
