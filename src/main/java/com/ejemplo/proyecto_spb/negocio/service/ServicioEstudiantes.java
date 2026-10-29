package com.ejemplo.proyecto_spb.negocio.service;

import com.ejemplo.proyecto_spb.negocio.model.Estudiante;
import com.ejemplo.proyecto_spb.persistence.repository.RepositorioEstudiantes;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

@Service
public class ServicioEstudiantes {

    private final RepositorioEstudiantes repositorio;

    public ServicioEstudiantes(RepositorioEstudiantes repositorio) {
        this.repositorio = repositorio;
    }

    public Estudiante registrar(Estudiante estudiante) {
        if (repositorio.existePorCorreo(estudiante.getCorreo())) {
            throw new IllegalStateException("Ya existe un estudiante con el correo " + estudiante.getCorreo());
        }
        return repositorio.guardar(estudiante);
    }

    public List<Estudiante> listar() {
        return repositorio.listar();
    }

    public Estudiante obtener(Long id) {
        return repositorio.buscarPorId(id)
                .orElseThrow(() -> new NoSuchElementException("No existe el estudiante " + id));
    }
}
