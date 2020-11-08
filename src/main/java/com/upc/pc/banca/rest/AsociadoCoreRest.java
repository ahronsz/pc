package com.upc.pc.banca.rest;

import com.upc.pc.banca.entidades.Asociado;

import java.util.List;

public interface AsociadoCoreRest {
    public Asociado registrarAsociado(Asociado asociado);
    public Asociado abonar(Asociado asociado);
    public List<Asociado> listarAsociado();
}
