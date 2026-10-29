package com.ejemplo.proyecto_spb.presentacion.controlador;

import com.ejemplo.proyecto_spb.negocio.model.Curso;
import com.ejemplo.proyecto_spb.negocio.model.Ocupacion;
import com.ejemplo.proyecto_spb.negocio.service.ServicioCursos;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cursos")
public class ControladorCursos {

    private final ServicioCursos servicio;

    public ControladorCursos(ServicioCursos servicio) {
        this.servicio = servicio;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Curso registrar(@RequestBody Curso curso) {
        return servicio.registrar(curso);
    }

    @GetMapping
    public List<Curso> listar() {
        return servicio.listar();
    }

    @GetMapping("/economicos")
    public List<Curso> listarEconomicos() {
        return servicio.listarEconomicos();
    }

    @GetMapping("/{id}/ocupacion")
    public Ocupacion ocupacion(@PathVariable Long id) {
        return servicio.calcularOcupacion(id);
    }
}
