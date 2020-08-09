package com.github.dennyphilipp.api.api.interfaces;

import com.github.dennyphilipp.dto.CidadeDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@RequestMapping(value = "/api/cidade")
public interface ICidadeController {


    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value="/obter-por-estado/{uf}", method= RequestMethod.GET)
    public abstract ResponseEntity<List<CidadeDTO>> obterPorEstado(@PathVariable(value = "uf", required = true) String uf);

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value="/obter-todos", method= RequestMethod.GET)
    public abstract ResponseEntity<List<CidadeDTO>> obterTodos();

}
