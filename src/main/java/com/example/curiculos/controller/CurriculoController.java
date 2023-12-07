package com.example.curiculos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.curiculos.entidade.dto.EntradaDto;
import com.example.curiculos.entidade.dto.SaidaDto;
import com.example.curiculos.service.CurriculoService;

import java.util.List;

@RestController
@RequestMapping("api/curriculos")
public class CurriculoController {

    @Autowired
    private CurriculoService service;

    @PostMapping
    public SaidaDto criar(@RequestBody EntradaDto curriculoEntrada) {
        return service.criar(curriculoEntrada);
    }

    @PutMapping("id/{id}")
    public boolean alterar(@PathVariable("id") Long id, @RequestBody EntradaDto curriculoEntrada) {
        return service.alterar(id, curriculoEntrada);
    }

    @GetMapping("id/{id}")
    public SaidaDto pegarUm(@PathVariable("id") Long id) {
        return service.pegarUm(id);
    }

    @DeleteMapping("id/{id}")
    public boolean excluir(@PathVariable("id") Long id) {
        return service.excluir(id);
    }

    @GetMapping
    public List<SaidaDto> listar() {
        return service.listar();
    }
}
