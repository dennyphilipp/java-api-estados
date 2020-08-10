package com.github.dennyphilipp.api.servico;

import com.github.dennyphilipp.dto.CidadeDTO;
import com.github.dennyphilipp.servico.CidadeService;
import com.github.dennyphilipp.terceiro.IIBGECidade;
import com.itextpdf.text.DocumentException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.ByteArrayOutputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("teste")
public class CidadeServicoTeste {

    @Autowired
    CidadeService cidadeService;

    @Mock
    IIBGECidade iibgeCidade;

    @Test
    public void injetarDependenciaSucesso()  {
        assertThat(this.cidadeService).isNotNull();
    }

    @Test
    public void injetarDependenciaIBGESucesso()  {
        assertThat(this.iibgeCidade).isNotNull();
    }

    @Test
    public void obterTodosSucesso() {
        List<CidadeDTO> cidades = this.cidadeService.obterTodos();

        assertThat(cidades).isNotNull();
        assertThat(cidades).isNotEmpty();
        assertThat(cidades.size()).isGreaterThan(0);
    }

    @Test
    public void obterTodosPoEstadoSucesso() {
        List<CidadeDTO> cidades = this.cidadeService.obterPorEstado("sc");

        assertThat(cidades).isNotNull();
        assertThat(cidades).isNotEmpty();
        assertThat(cidades.size()).isGreaterThan(0);
    }

    @Test
    public void gerarPDFSucesso() throws DocumentException {
        ByteArrayOutputStream pdf = this.cidadeService.gerarPDF("sc");

        assertThat(pdf).isNotNull();
        assertThat(pdf.size()).isGreaterThan(0);
    }
}
