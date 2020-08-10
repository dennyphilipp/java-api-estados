package com.github.dennyphilipp.api.api;

import com.github.dennyphilipp.api.api.interfaces.IEstadoController;
import com.github.dennyphilipp.servico.EstadoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebMvcTest(IEstadoController.class)
@ActiveProfiles("teste")
@AutoConfigureMockMvc
public class EstadoControllerTeste {

    @MockBean
    private EstadoService estadoService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void injetarDependenciaSucesso()  {
        assertThat(this.estadoService).isNotNull();
    }

    @Test
    public void obterTodosSucesso() throws Exception {
        this.mockMvc.perform(get("/api/estado/obter-todos")).andDo(print()).andExpect(status().isOk());
    }
}
