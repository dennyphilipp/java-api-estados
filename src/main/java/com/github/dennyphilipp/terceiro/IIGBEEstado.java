package com.github.dennyphilipp.terceiro;

import com.github.dennyphilipp.dto.EstadoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "IIGBEEstado", url = "https://servicodados.ibge.gov.br", fallback = FallBackIGBEEstado.class)
public interface IIGBEEstado {

    @GetMapping(value = "api/v1/localidades/estados")
    List<EstadoDTO> obterTodos();
}
