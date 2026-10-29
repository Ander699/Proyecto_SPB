package com.ejemplo.proyecto_spb.persistence.repository;

import com.ejemplo.proyecto_spb.negocio.model.Matricula;

public interface RepositorioMatriculas {

    Matricula guardar(Matricula matricula);

    boolean existe(Long estudianteId, Long cursoId);

    int contarPorCurso(Long cursoId);
}
