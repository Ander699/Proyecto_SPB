package com.ejemplo.proyecto_spb.persistence.repository;

import com.ejemplo.proyecto_spb.negocio.model.Matricula;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioMatriculasEnMemoria implements RepositorioMatriculas {

    private final List<Matricula> matriculas = new ArrayList<>();
    private long siguienteId = 1;

    @Override
    public Matricula guardar(Matricula matricula) {
        matricula.setId(siguienteId++);
        matriculas.add(matricula);
        return matricula;
    }

    @Override
    public boolean existe(Long estudianteId, Long cursoId) {
        for (Matricula matricula : matriculas) {
            if (matricula.getEstudiante().getId().equals(estudianteId)
                    && matricula.getCurso().getId().equals(cursoId)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int contarPorCurso(Long cursoId) {
        int contador = 0;
        for (Matricula matricula : matriculas) {
            if (matricula.getCurso().getId().equals(cursoId)) {
                contador++;
            }
        }
        return contador;
    }
}
