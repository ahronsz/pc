package com.upc.pc.banca.repositorio;

import com.upc.pc.banca.entidades.Asociado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioAsociado extends CrudRepository<Asociado, Long> {
    @Query(value = "SELECT * FROM asociado WHERE dni = :dni", nativeQuery = true)
    public Asociado getAsociadoXDni(String dni);
}
