package com.github.dennyphilipp.api.api;

import com.github.dennyphilipp.api.api.interfaces.ICidadeController;
import static org.mockito.Mockito.when;
import com.github.dennyphilipp.servico.CidadeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ICidadeController.class)
@ActiveProfiles("teste")
@AutoConfigureMockMvc
public class CidadeControllerTeste {

    @MockBean
    private CidadeService cidadeService;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HttpServletResponse response;

    @Test
    public void injetarDependenciaSucesso()  {
        assertThat(this.cidadeService).isNotNull();
    }

    @Test
    public void obterTodosSucesso() throws Exception {
        this.mockMvc.perform(get("/api/cidade/obter-todos")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void obterTodosPorEstadoSucesso() throws Exception {
        this.mockMvc.perform(get("/api/cidade/obter-por-estado/sc")).andDo(print()).andExpect(status().isOk());
    }


    /*
    @Test
    public void gerarPDFSucesso() throws Exception {
        ByteArrayOutputStream pdf = new ByteArrayOutputStream();
        when(response.getBufferSize()).thenReturn(pdf.size());

        this.mockMvc.perform(get("/api/cidade/gerar-pdf/sc")).andDo(print());
    }
     */
}
