package com.jotajr.jbankapi.controllers;

import com.jotajr.jbankapi.dto.Agencia;
import com.jotajr.jbankapi.repository.AgenciaRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/agencia")
@Api(value="agencia", description="Operacoes pertinentes as agencias")
public class AgenciaRestController {

    final AgenciaRepository agenciaRepository;

    public AgenciaRestController(AgenciaRepository agenciaRepository) {
        this.agenciaRepository = agenciaRepository;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Lista de todas as agencias", response = Iterable.class)
    public List<Agencia> allAgencias() {
        return (List<Agencia>) agenciaRepository.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Busca agencia por id", response = Agencia.class)
    public ResponseEntity<Agencia> getAgenciaById(@PathVariable Long id) {
        Agencia agencia = agenciaRepository.findByIdAgencia(id);
        if(agencia != null) {
            return new ResponseEntity<Agencia>(agencia, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
