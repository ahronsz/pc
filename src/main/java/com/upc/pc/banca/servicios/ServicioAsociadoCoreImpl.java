package com.upc.pc.banca.servicios;

import com.upc.pc.banca.Util.DateUtil;
import com.upc.pc.banca.entidades.Asociado;
import com.upc.pc.banca.repositorio.RepositorioAsociado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;

@Service
public class ServicioAsociadoCoreImpl implements ServicioAsociadoCore{

    @Autowired
    private RepositorioAsociado repositorioAsociado;

    @Autowired
    private DateUtil dateUtil;

    @Override
    public Asociado registrarAsociado(Asociado asociado) {
        this.asignarPuntos(asociado);
        asociado.setSaldo((float) 0.00);
        repositorioAsociado.save(asociado);
        return asociado;
    }

    @Override
    public Asociado abonar(Asociado asociado) {
        Asociado a = repositorioAsociado.getAsociadoXDni(asociado.getDni());
        a.setSaldo(a.getSaldo() + asociado.getAbono());
        if (asociado.getAbono() > 1000) a.setPuntos(a.getPuntos() + 100);

        return repositorioAsociado.save(a);
    }

    @Override
    public List<Asociado> listarAsociados() {
        return (List<Asociado>) repositorioAsociado.findAll();
    }

    private void asignarPuntos(Asociado asociado) {
        DecimalFormat df = new DecimalFormat();
        df.setRoundingMode(RoundingMode.DOWN);
        int edad = dateUtil.obtenerEdad(asociado.getFecha_nacimiento());
        int puntos = 1000;
        if (edad >= 50) { // condificional q evita la multiplicacion de 40 X 0
            puntos = puntos + (100 * Integer.parseInt(df.format((edad - 40) / 10)));
        }
        asociado.setPuntos(puntos);
    }
}
