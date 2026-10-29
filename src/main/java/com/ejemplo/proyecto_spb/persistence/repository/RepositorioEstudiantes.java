package com.ejemplo.proyecto_spb.persistence.repository;

import com.ejemplo.proyecto_spb.negocio.model.Estudiante;
import java.util.List;
import java.util.Optional;

public interface RepositorioEstudiantes {

    Estudiante guardar(Estudiante estudiante);

    List<Estudiante> listar();

    Optional<Estudiante> buscarPorId(Long id);

    boolean existePorCorreo(String correo);
}
