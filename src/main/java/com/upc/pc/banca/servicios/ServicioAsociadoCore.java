package com.upc.pc.banca.servicios;

import com.upc.pc.banca.entidades.Asociado;

import java.util.List;

public interface ServicioAsociadoCore {
    public Asociado registrarAsociado(Asociado asociado);
    public Asociado abonar(Asociado asociado);
    public List<Asociado> listarAsociados();
}
