package com.ejemplo.proyecto_spb.persistence.repository;

import com.ejemplo.proyecto_spb.negocio.model.Estudiante;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioEstudiantesEnMemoria implements RepositorioEstudiantes {

    private final List<Estudiante> estudiantes = new ArrayList<>();
    private long siguienteId = 1;

    @Override
    public Estudiante guardar(Estudiante estudiante) {
        estudiante.setId(siguienteId++);
        estudiantes.add(estudiante);
        return estudiante;
    }

    @Override
    public List<Estudiante> listar() {
        return new ArrayList<>(estudiantes);
    }

    @Override
    public Optional<Estudiante> buscarPorId(Long id) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getId().equals(id)) {
                return Optional.of(estudiante);
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean existePorCorreo(String correo) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCorreo().equalsIgnoreCase(correo)) {
                return true;
            }
        }
        return false;
    }
}
