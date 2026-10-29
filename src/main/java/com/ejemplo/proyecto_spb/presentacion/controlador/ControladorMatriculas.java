package com.ejemplo.proyecto_spb.presentacion.controlador;

import com.ejemplo.proyecto_spb.negocio.model.Matricula;
import com.ejemplo.proyecto_spb.negocio.service.ServicioMatriculas;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/matriculas")
public class ControladorMatriculas {

    private final ServicioMatriculas servicio;

    public ControladorMatriculas(ServicioMatriculas servicio) {
        this.servicio = servicio;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Matricula matricular(@RequestBody SolicitudMatricula solicitud) {
        return servicio.matricular(solicitud.estudianteId(), solicitud.cursoId());
    }
}
