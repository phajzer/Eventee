package com.example.demo.web.controller;

import com.example.demo.service.CurrencyService;
import com.example.demo.web.dto.CurrencyTableDTO;
import com.example.demo.web.client.NBPClient;
import com.example.demo.repo.UserHistory;
import com.example.demo.web.dto.CurrentCurrencyResponse;
import com.example.demo.web.dto.CurrentCurrencyRequest;
import com.example.demo.web.dto.UserHistoryDTO;
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
    public CurrentCurrencyResponse getCurrentCurrency(@RequestBody CurrentCurrencyRequest currentCurrencyRequest) {
        return CurrentCurrencyResponse.builder()
                .value(currencyService.getUserCurrencyValue(currentCurrencyRequest.getCurrency(), currentCurrencyRequest.getName()))
                .build();
    }

    @GetMapping("/requests")
    public List<UserHistoryDTO> getAllRequestsHistory(){
        return currencyService.getAllUsersSearchHistory();
    }

}
