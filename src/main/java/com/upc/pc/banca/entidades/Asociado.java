package com.upc.pc.banca.entidades;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
public class Asociado implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long idCliente;
    @NotNull
    private String dni;
    @NotNull
    private String nombre;
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "GMT-5")
    @NotNull
    private Date fecha_nacimiento;
    @NotNull
    private float saldo;
    @NotNull
    private int puntos;
    @Transient
    private float abono;
}
