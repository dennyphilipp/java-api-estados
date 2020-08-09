package com.github.dennyphilipp.terceiro;

import com.github.dennyphilipp.dto.EstadoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j

public class FallBackIGBEEstado implements IIBGEEstado {
    @Override
    public List<EstadoDTO> obterTodos() {
        log.error("Fallback IGBE Estado, retorna lista padrao");
        List<EstadoDTO> lista = new ArrayList<>();
        lista.add(new EstadoDTO(11, "RO", "Rondônia"));
        lista.add(new EstadoDTO(12, "AC", "Acre"));
        lista.add(new EstadoDTO(12, "AM", "Amazonas"));
        lista.add(new EstadoDTO(14, "RR", "Roraima"));
        lista.add(new EstadoDTO(15, "AP", "Amapá"));
        lista.add(new EstadoDTO(17, "TO", "Tocantins"));
        lista.add(new EstadoDTO(21, "MA", "Maranhão"));
        lista.add(new EstadoDTO(22, "PI", "Piauí"));
        lista.add(new EstadoDTO(23, "CE","Ceará"));
        lista.add(new EstadoDTO(24, "RN", "Rio Grande do Norte"));
        lista.add(new EstadoDTO(25, "PB", "Paraíba"));
        lista.add(new EstadoDTO(26, "PE", "Pernambuco"));
        lista.add(new EstadoDTO(27, "AL", "Alagoas"));
        lista.add(new EstadoDTO(28, "SE", "Sergipe"));
        lista.add(new EstadoDTO(29, "BA", "Bahia"));
        lista.add(new EstadoDTO(31, "MG", "Minas Gerais"));
        lista.add(new EstadoDTO(32, "ES", "Espírito Santo"));
        lista.add(new EstadoDTO(33, "RJ", "Rio de Janeiro"));
        lista.add(new EstadoDTO(35, "SP", "São Paulo"));
        lista.add(new EstadoDTO(41, "PR", "Paraná"));
        lista.add(new EstadoDTO(42, "SC", "Santa Catarina"));
        lista.add(new EstadoDTO(43, "RS", "Rio Grande do Sul"));
        lista.add(new EstadoDTO(50, "MS", "Mato Grosso do Sul"));
        lista.add(new EstadoDTO(51, "MT", "Mato Grosso"));
        lista.add(new EstadoDTO(52, "GO", "Goiás"));
        lista.add(new EstadoDTO(53, "DF", "Distrito Federal"));
        return lista;
    }
}
