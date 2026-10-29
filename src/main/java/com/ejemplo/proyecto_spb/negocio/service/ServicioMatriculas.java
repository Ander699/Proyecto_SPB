package com.ejemplo.proyecto_spb.negocio.service;

import com.ejemplo.proyecto_spb.negocio.model.Curso;
import com.ejemplo.proyecto_spb.negocio.model.Estudiante;
import com.ejemplo.proyecto_spb.negocio.model.Matricula;
import com.ejemplo.proyecto_spb.persistence.repository.RepositorioMatriculas;
import org.springframework.stereotype.Service;

@Service
public class ServicioMatriculas {

    private final RepositorioMatriculas repositorio;
    private final ServicioEstudiantes servicioEstudiantes;
    private final ServicioCursos servicioCursos;

    public ServicioMatriculas(RepositorioMatriculas repositorio,
                              ServicioEstudiantes servicioEstudiantes,
                              ServicioCursos servicioCursos) {
        this.repositorio = repositorio;
        this.servicioEstudiantes = servicioEstudiantes;
        this.servicioCursos = servicioCursos;
    }

    public Matricula matricular(Long estudianteId, Long cursoId) {
        Estudiante estudiante = servicioEstudiantes.obtener(estudianteId);
        Curso curso = servicioCursos.obtener(cursoId);

        if (repositorio.existe(estudianteId, cursoId)) {
            throw new IllegalStateException(
                    "El estudiante " + estudianteId + " ya está matriculado en el curso " + cursoId);
        }
        if (repositorio.contarPorCurso(cursoId) >= curso.getCupoMaximo()) {
            throw new IllegalStateException("El curso " + cursoId + " no tiene cupos disponibles");
        }
        return repositorio.guardar(new Matricula(estudiante, curso));
    }
}
