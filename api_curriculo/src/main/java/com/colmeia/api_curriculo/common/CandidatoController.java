package com.colmeia.api_curriculo.common;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;

import com.colmeia.api_curriculo.domain.service.CandidatoService;
import com.colmeia.api_curriculo.domain.model.Candidato;
import org.springframework.http.HttpStatus;



@AllArgsConstructor
@RestController
@RequestMapping("/api/candidato")
public class CandidatoController {
  
    private CandidatoService candidatoService;
    @GetMapping("/hello")
    public String hello(){
        return "Hello, World";
    }

    @GetMapping
    public List<Candidato> listar(){
        return candidatoService.listaCandidato();
    }

    @GetMapping("/cpf/{candidatoCpf}")
    public List<Candidato> buscarCpf(@PathVariable String candidatoCpf){
        System.out.println("buscando cpf");
        return candidatoService.buscarCpf(candidatoCpf);
    }

    @GetMapping("/status/{status}")
    public Long quantidadePorStatus(@PathVariable String status){
        System.out.println("buscando status");
        return candidatoService.quantidadePorStatus(status);
    }

    @GetMapping("/escolaridade/{escolaridade}")
    public Long quantidadePorEscolaridade(@PathVariable String escolaridade){
        System.out.println("buscando escolaridade");
        return candidatoService.quantidadePorEscolaridade(escolaridade);
    }

    @GetMapping("/{candidatoId}")
    public ResponseEntity<Candidato> buscarId(@PathVariable Long candidatoId){
        return candidatoService.buscarID(candidatoId);
    }

    @PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Candidato adicionar(@RequestBody Candidato candidato) {
        System.out.println(candidato.getNome());
		return candidatoService.salvar(candidato);
	}

    @PutMapping("/{candidatoId}")
    public ResponseEntity<Candidato> atualizar(@PathVariable Long candidatoId,@RequestBody Candidato candidato){
        return candidatoService.atualizar(candidatoId, candidato);
    }

    @DeleteMapping("/{candidatoId}")
    public ResponseEntity<Candidato> deletar(@PathVariable Long candidatoId){
        return candidatoService.deletar(candidatoId);
    }
}
