package com.colmeia.api_curriculo.domain.service;

import java.util.List;

import javax.transaction.Transactional;

import com.colmeia.api_curriculo.domain.exception.NegocioExeption;
import com.colmeia.api_curriculo.domain.model.Candidato;
import com.colmeia.api_curriculo.domain.model.StatusEntrega;
import com.colmeia.api_curriculo.domain.repository.CandidatoRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CandidatoService {
    private CandidatoRepository candidatoRepository;

    public List<Candidato> listaCandidato(){
        return candidatoRepository.findAll();
    }
    public List<Candidato> buscarCpf(String cpf){
        return candidatoRepository.findByCpf(cpf);
    }

    public ResponseEntity<Candidato> buscarID(Long candidatoId){
        return candidatoRepository.findById(candidatoId)
                .map(candidato -> ResponseEntity.ok(candidato))
                .orElse(ResponseEntity.notFound().build());
    }

    @Transactional
    public Candidato salvar(Candidato candidato){
        candidato.setStatusCandidato(StatusEntrega.Aguardando);
        return candidatoRepository.save(candidato);
    }

    public ResponseEntity<Candidato> atualizar(Long candidatoId, Candidato candidato){
        if(!candidatoRepository.existsById(candidatoId)){
            return ResponseEntity.notFound().build(); //não existe, retorna 404
        }

        candidato.setId(candidatoId);
        candidato = candidatoRepository.save(candidato);
        return ResponseEntity.ok(candidato);
    }

    public Candidato verificarCandidado(Long candidatoId){
        return candidatoRepository.findById(candidatoId)
                .orElseThrow(() -> new NegocioExeption("Referencia do candidato não encontrada"));
    }

    
    public ResponseEntity<Candidato> deletar(Long candidatoId){
        if(!candidatoRepository.existsById(candidatoId)){
            return ResponseEntity.notFound().build(); //não existe, retorna 404
        }

       // clienteRepository.deleteById(clienteId);
       candidatoRepository.deleteById(candidatoId);
        return ResponseEntity.noContent().build(); //excluido e não tem o que mostrar, retorna 204
    }

    public Long quantidadePorStatus(String status){
        return candidatoRepository.quantidadePorStatus(status);
    }

    public Long quantidadePorEscolaridade(String escolaridade){
        return candidatoRepository.quantidadePorEscolaridade(escolaridade);
    }
}
