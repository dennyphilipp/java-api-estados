package com.github.dennyphilipp.servico;

import com.github.dennyphilipp.dto.CidadeDTO;
import com.github.dennyphilipp.relatorio.CidadeRelatorio;
import com.github.dennyphilipp.terceiro.IIBGECidade;
import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@CacheConfig(cacheNames = "cidade")
@Service
public class CidadeService {

    @Lazy
    @Autowired()
    private IIBGECidade ibgeCidade;

    @Cacheable(unless = "#result == null or #result.size() == 0")
    public List<CidadeDTO> obterPorEstado(String uf) {

        return this.ibgeCidade.obterPorEstado(uf.toLowerCase());
    }

    @Cacheable(unless = "#result == null or #result.size() == 0")
    public List<CidadeDTO> obterTodos() {

        return this.ibgeCidade.obterTodos();
    }

    @CacheEvict(allEntries = true)
    public void renovarCache() {
        return;
    }


    public ByteArrayOutputStream gerarPDF(String uf) throws DocumentException {
        List<CidadeDTO> lista;
        if (uf.isEmpty())
            lista = this.obterTodos();
        else
            lista = this.obterPorEstado(uf);

        CidadeRelatorio relatorio = new CidadeRelatorio(lista);
       return relatorio.Gerar();
    }
}
