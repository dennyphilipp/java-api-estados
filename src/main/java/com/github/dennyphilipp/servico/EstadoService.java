package com.github.dennyphilipp.servico;

import com.github.dennyphilipp.dto.EstadoDTO;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EstadoService {

    public List<EstadoDTO> obterTodos() {
        EstadoDTO estado = new EstadoDTO();
        estado.Teste = "ola mundo";
        List<EstadoDTO> lista = new ArrayList<EstadoDTO>();
        lista.add(estado);
        return lista;
    }
}
