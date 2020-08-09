package com.github.dennyphilipp.dto.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.github.dennyphilipp.dto.CidadeDTO;

import java.io.IOException;

public class JSONCidadeDTO extends StdDeserializer<CidadeDTO> {
    protected JSONCidadeDTO(Class<?> vc) {
        super(vc);
    }

    public JSONCidadeDTO() {
        this(null);
    }

    @Override
    public CidadeDTO deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        String siglaEstado = node.get("microrregiao").get("mesorregiao").get("UF").get("sigla").textValue();
        String nomeMesorregiao = node.get("microrregiao").get("mesorregiao").get("nome").textValue();
        long idEstado = node.get("microrregiao").get("mesorregiao").get("UF").get("id").longValue();
        String regiaoNome = node.get("microrregiao").get("mesorregiao").get("UF").get("regiao").get("nome").textValue();
        String nomeCidade = node.get("nome").textValue();
        String nomeFormatado = nomeCidade.concat("/").concat(siglaEstado);

        return new CidadeDTO(idEstado, siglaEstado, regiaoNome, nomeCidade, nomeMesorregiao, nomeFormatado);
    }
}
