package com.github.dennyphilipp.terceiro;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "IIGBECidade", url = "https://servicodados.ibge.gov.br", fallback = FallBackIGBEEstado.class)
public interface IIGBECidade {

    @GetMapping(value = "api/v1/localidades/estados/{UF}/municipios")
    public abstract List<Object> obterPorEstado(@PathVariable(value = "UF", required = true) String uf);

    @GetMapping(value = "api/v1/localidades/municipios")
    public abstract List<Object> obterTodos();
}
