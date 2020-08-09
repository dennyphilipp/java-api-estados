package com.github.dennyphilipp.api.api;

import com.github.dennyphilipp.api.api.interfaces.ICidadeController;
import com.github.dennyphilipp.dto.CidadeDTO;
import com.github.dennyphilipp.servico.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
public class CidadeController implements ICidadeController {


    @Lazy
    @Autowired
    private CidadeService cidadeService;

    @Override
    public ResponseEntity<List<CidadeDTO>> obterPorEstado(@PathVariable(value = "uf", required = true) String uf) {
        return ResponseEntity.ok(this.cidadeService.obterPorEstado(uf));
    }

    @Override
    public ResponseEntity<List<CidadeDTO>> obterTodos() {
        return ResponseEntity.ok(this.cidadeService.obterTodos());

    }

    @Override
    public void gerarPDF(HttpServletResponse response, @PathVariable(value = "uf") String uf) throws Exception {
        ServletOutputStream servletOutputStream = response.getOutputStream();
        ByteArrayOutputStream bout = cidadeService.gerarPDF(uf);
        bout.writeTo(servletOutputStream);

        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=cidades.pdf");
        response.flushBuffer();
    }

}
