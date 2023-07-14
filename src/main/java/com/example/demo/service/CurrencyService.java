package com.example.demo.service;

import com.example.demo.client.dto.CurrencyTable;
import com.example.demo.client.NBPClient;
import com.example.demo.repo.UserHistory;
import com.example.demo.repo.UserHistoryRepository;
import com.example.demo.utils.Currency;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CurrencyService {

    private final NBPClient nbpClient;
    private final UserHistoryRepository userHistoryRepository;

    public Double getUserCurrencyValue(Currency currency, String userName) {
        CurrencyTable[] currencyTable = nbpClient.getCurrencyTable();
        Double currencyValue = findCurrencyValue(currency, currencyTable[0]);
        saveUserSearchHistory(currency, userName, currencyValue);
        return currencyValue;
    }

    private Double findCurrencyValue(Currency currency, CurrencyTable currencyTable) {
        return currencyTable.getRates().stream()
                .filter(x -> x.getCode().equals(currency.toString()))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Currency not found in the table"))
                .getMid();
    }

    private void saveUserSearchHistory(Currency currency, String userName, Double currencyValue) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        UserHistory userHistory = UserHistory.builder()
                .currency(currency)
                .name(userName)
                .date(currentDateTime)
                .value(currencyValue)
                .build();
        userHistoryRepository.save(userHistory);
    }

    public List<UserHistory> getAllUsersSearchHistory() {
        return userHistoryRepository.findAll();
    }
}


