package com.github.dennyphilipp.api.api.interfaces;

import com.github.dennyphilipp.dto.CidadeDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_OCTET_STREAM_VALUE;

@RequestMapping(value = "/api/cidade")
public interface ICidadeController {


    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value="/obter-por-estado/{uf}", method= RequestMethod.GET)
    public abstract ResponseEntity<List<CidadeDTO>> obterPorEstado(@PathVariable(value = "uf", required = true) String uf);

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value="/obter-todos", method= RequestMethod.GET)
    public abstract ResponseEntity<List<CidadeDTO>> obterTodos();

    @RequestMapping(value="/gerar-pdf/{uf}", method= RequestMethod.GET, produces = APPLICATION_OCTET_STREAM_VALUE)
    public  abstract void gerarPDF(HttpServletResponse response, @PathVariable(value = "uf") String uf) throws IOException, Exception;

}
