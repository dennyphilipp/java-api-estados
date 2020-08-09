package com.github.dennyphilipp.servico;

import com.github.dennyphilipp.dto.CidadeDTO;
import com.github.dennyphilipp.terceiro.IIBGECidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@CacheConfig(cacheNames = "cidade")
@Service
public class CidadeService {

    @Lazy
    @Autowired()
    private IIBGECidade ibgeCidade;

    @Cacheable
    public List<CidadeDTO> obterPorEstado(String uf) {

        return this.ibgeCidade.obterPorEstado(uf.toLowerCase());
    }

    @Cacheable
    public List<CidadeDTO> obterTodos() {

        return this.ibgeCidade.obterTodos();
    }


}
