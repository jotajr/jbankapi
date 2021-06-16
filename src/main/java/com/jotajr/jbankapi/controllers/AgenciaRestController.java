package com.jotajr.jbankapi.controllers;

import com.jotajr.jbankapi.dto.Agencia;
import com.jotajr.jbankapi.exception.AgenciaNotFoundException;
import com.jotajr.jbankapi.repository.AgenciaRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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
    public Agencia getAgenciaById(@PathVariable Long id) throws AgenciaNotFoundException {
        return agenciaRepository.findById(id)
                .orElseThrow(() -> new AgenciaNotFoundException("Agencia nao encontrada"));
    }

    @PostMapping("/add")
    @ApiOperation(value = "Adiciona uma nova agencia", response = Agencia.class)
    Agencia adicionarAgencia(@RequestBody Agencia agencia) {
        return agenciaRepository.save(agencia);
    }

    @PutMapping("/update/{id}")
    @ApiOperation(value = "Modifica agencia pelo id", response = Agencia.class)
    Agencia modificaAgencia(@RequestBody Agencia agencia, @PathVariable Long id) {

        return agenciaRepository.findById(id)
                .map(agenciatmp -> {
                    agenciatmp.setNomeAgencia(agencia.getNomeAgencia());
                    agenciatmp.setEndereco(agencia.getEndereco());
                    agenciatmp.setTelefone(agencia.getTelefone());
                    return agenciaRepository.save(agenciatmp);
                })
                .orElseGet(() -> {
                    agencia.setIdAgencia(id);
                    return agenciaRepository.save(agencia);
                });
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Remove agencia pelo id")
    void apagaAgencia(@PathVariable Long id) {
        agenciaRepository.deleteById(id);
    }
}
