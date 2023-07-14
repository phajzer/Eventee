package com.example.demo.web;

import com.example.demo.client.dto.CurrencyTable;
import com.example.demo.client.NBPClient;
import com.example.demo.repo.UserHistory;
import com.example.demo.service.CurrencyService;
import com.example.demo.web.dto.CurrencyValue;
import com.example.demo.web.dto.RequestValue;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/currencies")
@RequiredArgsConstructor
public class CurrenciesController {

    private final CurrencyService currencyService;

    private final NBPClient nbpClient;

    @PostMapping("/get-current-currency-value-command")
    public CurrencyValue getCurrentCurrency(@RequestBody RequestValue requestValue) {
        return CurrencyValue.builder()
                .value(currencyService.getUserCurrencyValue(requestValue.getCurrency(), requestValue.getName()))
                .build();
    }

    @GetMapping("/test")
    public CurrencyTable[] getCurrencyTable(){
        return nbpClient.getCurrencyTable();
    }

    @GetMapping("/requests")
    public List<UserHistory> getAllRequestsHistory(){
        return currencyService.getAllUsersSearchHistory();
    }



}
