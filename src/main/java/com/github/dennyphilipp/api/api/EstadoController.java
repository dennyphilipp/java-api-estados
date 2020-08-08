package com.github.dennyphilipp.api.api;

import com.github.dennyphilipp.dto.EstadoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.github.dennyphilipp.servico.EstadoServico;
import java.util.List;

@RestController
public class EstadoController {

    @Autowired
    private EstadoServico estadoServio;

    public ResponseEntity<List<EstadoDTO>> obterTodos() {
        return ResponseEntity.ok(this.estadoServio.obterTodos());
    }

}
