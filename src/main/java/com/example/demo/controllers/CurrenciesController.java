package com.example.demo.controllers;

import com.example.demo.client.CurrencyTable;
import com.example.demo.client.NBPClient;
import com.example.demo.services.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/currencies")
@RequiredArgsConstructor
public class CurrenciesController {

    private final CurrencyService currencyService;

    private final NBPClient nbpClient;

    @PostMapping("/get-current-currency-value-command")
    public CurrencyValue getCurrentCurrency(@RequestBody GetValue getValue) {
        return CurrencyValue.builder()
                .value(currencyService.getUserCurrencyValue(getValue.getCurrency(), getValue.getName()))
                .build();
    }

    @GetMapping("/test")
    public CurrencyTable[] getCurrencyTable(){
        return nbpClient.getCurrencyTable();
    }


}
