package com.example.demo.client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "nbp", url = "http://api.nbp.pl/api")
public interface NBPClient {
//    @GetMapping("/exchangerates/tables/A?format=json")
    @RequestMapping(method = RequestMethod.GET, value = "/exchangerates/tables/A?format=json", produces = "application/json")
    CurrencyTable[] getCurrencyTable();

    @GetMapping("/exchangerates/rates/a/{code}/?format=json")
    CurrencyTable getCurrency(@PathVariable("code") String code);
}

