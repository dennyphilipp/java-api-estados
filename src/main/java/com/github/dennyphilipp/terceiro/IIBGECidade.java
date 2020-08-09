package com.github.dennyphilipp.terceiro;

import com.github.dennyphilipp.dto.CidadeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "IIBGECidade", url = "https://servicodados.ibge.gov.br", configuration = FeignConfiguracao.class, fallback = FallbackIBGECidade.class)
public interface IIBGECidade {

    @GetMapping(value = "api/v1/localidades/estados/{UF}/municipios")
    public abstract List<CidadeDTO> obterPorEstado(@PathVariable(value = "UF", required = true) String uf);

    @GetMapping(value = "api/v1/localidades/municipios")
    public abstract List<CidadeDTO> obterTodos();
}
