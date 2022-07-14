package com.colmeia.api_curriculo.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import com.colmeia.api_curriculo.api.model.CompetenciaModelo;
import com.colmeia.api_curriculo.domain.model.Competencia;
import org.modelmapper.ModelMapper;

public class CompetenciaAssembler {
    private ModelMapper modelMapper;
    
    public CompetenciaModelo toModel(Competencia ocorrencia){
        return modelMapper.map(ocorrencia, CompetenciaModelo.class);
    }


    public List<CompetenciaModelo> toCollectionModel(List<Competencia> ocorrencia){
        return ocorrencia.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }
}
