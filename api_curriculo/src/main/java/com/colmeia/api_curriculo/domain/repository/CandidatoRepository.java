package com.colmeia.api_curriculo.domain.repository;

import java.util.List;
import java.util.Optional;

import com.colmeia.api_curriculo.domain.model.Candidato;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, Long>{
    
    List<Candidato> findByNome(String nome);
    List<Candidato> findByNomeContaining(String nome);
    Optional<Candidato> findByEmail(String email);
    Optional<Candidato> findById(Long id);

    @Query(value = "select * from candidato WHERE cpf = :cpf ", nativeQuery = true)
    public List<Candidato> findByCpf(@Param("cpf")String cpf);

    @Query(value = "select count(status) from colmeiacurriculo.candidato where status = :status ", nativeQuery = true)
    public Long quantidadePorStatus(@Param("status")String status);

    @Query(value = "select count(status) from colmeiacurriculo.candidato where escolaridade = :escolaridade ", nativeQuery = true)
    public Long quantidadePorEscolaridade(@Param("escolaridade")String escolaridade);
}
