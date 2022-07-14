package com.colmeia.api_curriculo.domain.repository;

import java.util.List;

import com.colmeia.api_curriculo.domain.model.Competencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetenciaRepository extends JpaRepository<Competencia, Long>{
    List<Competencia> findByNome(String nome);
    List<Competencia> findByNomeContaining(String nome);
    //List<Competencia> findByCandidato_id(Long candidatoId);

    /*@Query(value = "select * from competencia WHERE candidato_id = 1", nativeQuery = true)
    List<Competencia> findAllAtivas(Long candidato_id);
    //List<Competencia> findByCandidato_idContaining(Long candidatoId);
    List<Competencia> findByIList(Long candidato_id);*/

    @Query(value = "select * from competencia WHERE candidato_id = :candidatoId ", nativeQuery = true)
    public List<Competencia> findAllCandidatoId(@Param("candidatoId")Long candidatoId);

}
