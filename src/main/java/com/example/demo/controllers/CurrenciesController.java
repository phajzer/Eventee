package com.example.demo.controllers;

import com.example.demo.services.CurrencyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currencies")
public class CurrenciesController {
    private CurrencyService currencyService;

    @GetMapping("/get-current-currency-value-command")
    public CurrencyValue getCurrentCurrency(@RequestBody GetValue getValue) {
        return CurrencyValue.builder()
                .value(currencyService.getUserCurrencyValue(getValue.getCurrency(), getValue.getName()))
                .build();
    }

}
