package com.colmeia.api_curriculo.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompetenciaModelo {
    private Long id;
    private String nome;
    private String descricao;
    private String nivel;
}
