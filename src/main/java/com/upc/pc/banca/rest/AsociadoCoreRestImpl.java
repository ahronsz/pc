package com.upc.pc.banca.rest;

import com.upc.pc.banca.entidades.Asociado;
import com.upc.pc.banca.servicios.ServicioAsociadoCore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/asociado")
public class AsociadoCoreRestImpl implements AsociadoCoreRest{
    @Autowired
    private ServicioAsociadoCore servicioAsociadoCore;

    @PostMapping("/crear")
    public Asociado registrarAsociado(@RequestBody Asociado asociado) {
        Asociado a = null;
        try {
            a = servicioAsociadoCore.registrarAsociado(asociado);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No se pudo crear asociado, revise su request");
        }
        return a;
    }

    @PutMapping("/abonar")
    public Asociado abonar(@RequestBody Asociado asociado) {
        Asociado a = null;
        try {
            a = servicioAsociadoCore.abonar(asociado);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No se pudo abonar al cliente, revise su request");
        }
        return a;
    }

    @GetMapping("/listar")
    public List<Asociado> listarAsociado() {
        List<Asociado> asociados = null;
        try {
            asociados = servicioAsociadoCore.listarAsociados();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error, revise su request");
        }
        return asociados;
    }
}
