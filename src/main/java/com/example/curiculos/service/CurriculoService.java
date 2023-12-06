package com.example.curiculos.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.curiculos.entidade.Curriculo;
import com.example.curiculos.entidade.dto.EntradaDto;
import com.example.curiculos.entidade.dto.SaidaDto;
import com.example.curiculos.repository.CurriculoRepository;

@Service
public class CurriculoService {

    @Autowired
    private CurriculoRepository repository;

    @Autowired
    public ModelMapper mapper;

    public SaidaDto criar(EntradaDto curriculoEntrada) {

        Curriculo curriculo = mapper.map(curriculoEntrada, Curriculo.class);
        repository.save(curriculo);

        SaidaDto saida = mapper.map(curriculo, SaidaDto.class);
        return saida;
    }

    public boolean alterar(Long id, EntradaDto curriculoEntrada) {

        Optional <Curriculo> buscandoCurriculo = repository.findById(id);

        if(buscandoCurriculo.isPresent()){
            Curriculo curriculo = buscandoCurriculo.get();
            mapper.map(curriculoEntrada, Curriculo.class);
            repository.save(curriculo);
            return true;
        }
        return false;
    }

    public SaidaDto pegarUm(Long id) {
        Optional<Curriculo> buscandoCurriculo = repository.findById(id);
        if(buscandoCurriculo.isPresent()){
            Curriculo curriculo = buscandoCurriculo.get();
            SaidaDto saida = mapper.map(curriculo, SaidaDto.class);
            return saida;
        }
        return null;
    }

    public boolean excluir(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<SaidaDto> listar() {
        List<Curriculo> listaCurriculos = repository.findAll();
        return listaCurriculos.stream().map(curriculo -> mapper.map(curriculo, SaidaDto.class)).collect(Collectors.toList());
    }
}
