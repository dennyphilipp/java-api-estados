package com.github.dennyphilipp.terceiro;

import com.github.dennyphilipp.dto.EstadoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "IIBGEEstado", url = "https://servicodados.ibge.gov.br", fallback = FallBackIBGEEstado.class)
public interface IIBGEEstado {

    @GetMapping(value = "api/v1/localidades/estados")
    List<EstadoDTO> obterTodos();
}
