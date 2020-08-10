package com.github.dennyphilipp.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.dennyphilipp.dto.json.JSONCidadeDTO;
import lombok.Data;
import lombok.Getter;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@JsonDeserialize(using = JSONCidadeDTO.class)
@Getter
public class CidadeDTO {

    public  CidadeDTO() {

    }

    public  CidadeDTO(long idEstado, String  siglaEstado, String regiaoNome, String nomeCidade, String nomeMesorregiao, String nomeFormatado) {
        this.idEstado = idEstado;
        this.siglaEstado = siglaEstado;
        this.regiaoNome = regiaoNome;
        this.nomeCidade = nomeCidade;
        this.nomeMesorregiao = nomeMesorregiao;
        this.nomeFormatado = nomeFormatado;
    }

    private long idEstado;
    private  String siglaEstado;
    private  String regiaoNome;
    private  String nomeCidade;
    private  String nomeMesorregiao;
    private  String nomeFormatado;


}
