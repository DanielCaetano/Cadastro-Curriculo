package com.colmeia.api_curriculo.common;

import java.util.List;

import javax.validation.Valid;

import com.colmeia.api_curriculo.domain.model.Competencia;
import com.colmeia.api_curriculo.domain.service.CompetenciaService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/candidato/{candidatoId}/competencia")
public class CompetenciaController {
    private CompetenciaService competenciaService;

    @PostMapping
    @ResponseStatus
    public Competencia adicionar(@PathVariable Long candidatoId, @Valid @RequestBody Competencia competencia){
        competenciaService.verificaCandidato(candidatoId);
        return competenciaService.salvar(candidatoId, competencia);
    }
    
    
    @GetMapping
    public List<Competencia> listar(@PathVariable Long candidatoId){
        competenciaService.verificaCandidato(candidatoId);
        return competenciaService.Listar(candidatoId);
    }
}