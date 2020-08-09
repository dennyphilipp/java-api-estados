package com.github.dennyphilipp.terceiro;

import com.github.dennyphilipp.dto.CidadeDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class FallbackIBGECidade implements IIBGECidade {
    @Override
    public List<CidadeDTO> obterPorEstado(String uf) {
        log.error("Fallback IGBE Cidade obter por estado " + uf);

        return new ArrayList<CidadeDTO>();
    }

    @Override
    public List<CidadeDTO> obterTodos() {
        log.error("Fallback IGBE Cidade obter todos ");

        return new ArrayList<CidadeDTO>();
    }
}
