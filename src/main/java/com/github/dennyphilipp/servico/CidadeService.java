package com.github.dennyphilipp.servico;

import com.github.dennyphilipp.terceiro.IIBGECidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {

    @Lazy
    @Autowired()
    private IIBGECidade ibgeCidade;

    public List<Object> obterPorEstado(String uf) {
        return this.ibgeCidade.obterPorEstado(uf);
    }

}
