package com.github.dennyphilipp.dto;

import lombok.Data;


@Data
public class EstadoDTO {

    public EstadoDTO () {

    }

    public EstadoDTO(long id, String sigla, String nome) {
        this.id = id;
        this.sigla = sigla;
        this.nome = nome;
    }

    private long id;
    private   String sigla;
    private String nome;
}
