package com.colmeia.api_curriculo.domain.service;

import java.util.List;

import javax.transaction.Transactional;

import com.colmeia.api_curriculo.domain.model.Competencia;
import com.colmeia.api_curriculo.domain.repository.CompetenciaRepository;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CompetenciaService {
    private CompetenciaRepository competenciaRepository;
    private CandidatoService candidatoService;
 
    @Transactional
    public Boolean verificaCandidato(Long candidatoId){
        candidatoService.verificarCandidado(candidatoId);
        return true;
    }

    @Transactional
    public Competencia salvar(Long candidatoId, Competencia competencia){
        competencia.setCandidato_id(candidatoId);
        return competenciaRepository.save(competencia);
    }

   /* @Transactional
    public List<CompetenciaModelo> ListaCandidatosId(Long candidatoId){
        return competenciaAssembler.toCollectionModel(competenciaRepository.findByCandidato_idContaining(candidatoId));
    }*/

    @Transactional 
    public List<Competencia> Listar(Long candidato_id){
        //@Query(value = "select * from competencia WHERE candidato_id = ",candidato_id," ", nativeQuery = true);
        return competenciaRepository.findAllCandidatoId(candidato_id);
    }
}
