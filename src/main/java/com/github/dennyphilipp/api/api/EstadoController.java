package com.github.dennyphilipp.api.api;

import com.github.dennyphilipp.api.api.interfaces.IEstadoController;
import com.github.dennyphilipp.dto.EstadoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.github.dennyphilipp.servico.EstadoService;
import java.util.List;

@RestController
public class EstadoController implements IEstadoController {

    @Autowired
    @Lazy
    private EstadoService estadoService;

    @Override
    public ResponseEntity<List<EstadoDTO>> obterTodos() {
        return ResponseEntity.ok(this.estadoService.obterTodos());
    }

}
