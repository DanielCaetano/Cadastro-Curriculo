package com.colmeia.api_curriculo.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity
public class Candidato {
    //@NotNull //(groups = ClienteValidation.ClienteId.class)
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name= "id")
    @JsonProperty("_id")
    private Long id;

    @NotBlank
    @Size(max= 60)
    @Column (name= "nome")
    private String nome;

    @NotBlank
    @Size(max= 14)
    @Column (name= "cpf")
    private String cpf;

    //@NotBlank
    @Size(max= 12)
    @Column (name= "data_nascimento")
    @JsonProperty("data_nascimento")
    private String dataNascimento;

    //@NotBlank
    @Email
    @Size(max= 60)
    @Column (name= "email")
    private String email;

    //@NotBlank
    @Size(max= 20)
    @Column (name= "telefone")
    private String telefone;

    //@NotBlank
    @Size(max= 60)
    @Column (name= "escolaridade")
    private String escolaridade;

    //@NotBlank
    @Size(max= 60)
    @Column (name= "funcao")
    private String funcao;

    //@NotBlank
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    @JsonProperty("status")
    private StatusEntrega statusCandidato;

    /*
    @OneToMany(mappedBy = "candidato", cascade=CascadeType.ALL)
    private List<Competencia> competencia = new ArrayList<>();
    */
 
    /*
    public Competencia adicionarCompetencia(Long candidato_id, Competencia comp) {
        Competencia competencia = new Competencia();
        competencia.setCandidato_id(candidato_id);
        competencia.setNome(comp.getNome());
        competencia.setDescricao(comp.getDescricao());
        competencia.setNivel(comp.getNivel());       

        this.getCompetencia().add(competencia);
        return competencia;
    }*/
}
