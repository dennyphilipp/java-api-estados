package com.github.dennyphilipp.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.dennyphilipp.dto.json.JSONCidadeDTO;
import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement
@JsonDeserialize(using = JSONCidadeDTO.class)
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

    public long getIdEstado() {
        return idEstado;
    }

    public String getSiglaEstado() {
        return siglaEstado;
    }

    public String getRegiaoNome() {
        return regiaoNome;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public String getNomeMesorregiao() {
        return nomeMesorregiao;
    }

    public String getNomeFormatado() {
        return nomeFormatado;
    }

    private  String nomeCidade;
    private  String nomeMesorregiao;
    private  String nomeFormatado;


}
