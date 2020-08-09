package com.github.dennyphilipp.api.api;

import com.github.dennyphilipp.api.api.interfaces.ICidadeController;
import com.github.dennyphilipp.servico.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CidadeController implements ICidadeController {


    @Lazy
    @Autowired
    private CidadeService cidadeService;

    @Override
    public ResponseEntity<List<Object>> obterPorEstado(@PathVariable(value = "uf", required = true) String uf) {
        return ResponseEntity.ok(this.cidadeService.obterPorEstado(uf));
    }
}
