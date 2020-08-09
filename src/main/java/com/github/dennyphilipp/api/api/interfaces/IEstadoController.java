package com.github.dennyphilipp.api.api.interfaces;

import com.github.dennyphilipp.dto.EstadoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(value = "/api/estado")
public interface IEstadoController {

    @RequestMapping(value="/obter-todos", method= RequestMethod.GET)
    public abstract ResponseEntity<List<EstadoDTO>> obterTodos();
}
