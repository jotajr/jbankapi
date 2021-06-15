package com.jotajr.jbankapi.repository;

import com.jotajr.jbankapi.dto.Agencia;
import org.springframework.data.repository.CrudRepository;

public interface AgenciaRepository extends CrudRepository<Agencia, Long> {
    Agencia findByIdAgencia(Long id);
}
