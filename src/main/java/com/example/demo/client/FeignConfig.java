//package com.example.demo.client;
//
//import ch.qos.logback.classic.encoder.JsonEncoder;
//import feign.Feign;
//import feign.;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cloud.openfeign.EnableFeignClients;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.codec.cbor.Jackson2CborEncoder;
//
//@Configuration
//@EnableFeignClients
//public class FeignConfig {
//
//    @Value("${example-service.url}")
//    private String exampleServiceUrl;
//
//    @Bean
//    public NBPClient feignClient() {
//        return Feign.builder()
//                .encoder(new Jackson2CborEncoder())
//                .decoder(new JacksonDecoder())
//                .target(NBPClient.class, exampleServiceUrl);
//    }
//}
