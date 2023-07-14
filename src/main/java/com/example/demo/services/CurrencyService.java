package com.example.demo.services;

import com.example.demo.client.CurrencyTable;
import com.example.demo.client.NBPClient;
import com.example.demo.utils.Currency;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CurrencyService {
    private final NBPClient nbpClient;

    public Double getUserCurrencyValue(Currency currency, String userName) {
        CurrencyTable[] currencyTable = nbpClient.getCurrencyTable();
        return findCurrencyValue(currency, currencyTable[0]);
    }

    private Double findCurrencyValue(Currency currency, CurrencyTable currencyTable) {

        return currencyTable.getRates().stream()
                .filter(x -> x.code.equals(currency.toString()))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Currency not found in the table"))
                .mid;

    }
}


