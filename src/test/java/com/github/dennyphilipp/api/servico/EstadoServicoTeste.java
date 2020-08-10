package com.github.dennyphilipp.api.servico;

import com.github.dennyphilipp.dto.EstadoDTO;
import com.github.dennyphilipp.servico.EstadoService;
import com.github.dennyphilipp.terceiro.IIBGEEstado;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("teste")
public class EstadoServicoTeste {
    @Autowired
    private EstadoService estadoService;

    @Mock
    private IIBGEEstado ibgeEstado;

    @Test
    public void injetarDependenciaSucesso()  {
        assertThat(ibgeEstado).isNotNull();
    }

    @Test
    public void injetarDependenciaIBGESucesso()  {
        assertThat(ibgeEstado).isNotNull();
    }

    @Test
    public  void  obterTodosSucesso() {
        List<EstadoDTO> estados = this.estadoService.obterTodos();

        assertThat(estados).isNotNull();
        assertThat(estados).isNotEmpty();
        assertThat(estados.size()).isGreaterThan(0);
    }
}
