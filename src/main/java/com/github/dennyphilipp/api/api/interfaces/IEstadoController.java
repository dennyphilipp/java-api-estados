package com.github.dennyphilipp.api.api.interfaces;

import com.github.dennyphilipp.dto.EstadoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;


@RequestMapping(value = "/api/estado")
public interface IEstadoController {

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value="/obter-todos", method= RequestMethod.GET)
    public abstract ResponseEntity<List<EstadoDTO>> obterTodos();
}
