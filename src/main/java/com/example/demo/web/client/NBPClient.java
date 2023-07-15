package com.example.demo.web.client;
import com.example.demo.web.dto.CurrencyTableDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "nbp", url = "http://api.nbp.pl/api")
public interface NBPClient {

    @GetMapping(value = "/exchangerates/tables/A?format=json", produces = "application/json")
    CurrencyTableDTO[] getCurrencyTable();

    @GetMapping("/exchangerates/rates/a/{code}/?format=json")
    CurrencyTableDTO getCurrency(@PathVariable("code") String code);
}

