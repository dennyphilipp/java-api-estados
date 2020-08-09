package com.github.dennyphilipp.servico;

import com.github.dennyphilipp.dto.EstadoDTO;
import com.github.dennyphilipp.terceiro.IIGBEEstado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@CacheConfig(cacheNames = "estado")
public class EstadoService {

    @Lazy
    @Autowired
    private IIGBEEstado ibgeEstado;

    @Cacheable
    public List<EstadoDTO> obterTodos() {
        return this.ibgeEstado.obterTodos();
    }
}
