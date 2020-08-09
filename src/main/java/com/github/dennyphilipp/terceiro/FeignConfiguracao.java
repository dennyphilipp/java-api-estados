package com.github.dennyphilipp.terceiro;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import feign.Logger;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.springframework.context.annotation.Bean;

public class FeignConfiguracao {
    private static final ObjectMapper mapper = new ObjectMapper()
            .setSerializationInclusion(JsonInclude.Include.NON_NULL).configure(SerializationFeature.INDENT_OUTPUT, true)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    @Bean
    public OkHttpClient client() {
        return new OkHttpClient();
    }

    @Bean
    public Encoder encoder() {
        return new JacksonEncoder(FeignConfiguracao.mapper);
    }

    @Bean
    public Decoder decoder() {
        return new JacksonDecoder(FeignConfiguracao.mapper);
    }

    @Bean
    public Logger feignLogger() {
        return new Slf4jLogger();
    }

}
