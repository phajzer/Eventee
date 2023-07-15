package com.example.demo.service;

import com.example.demo.utils.Currency;
import com.example.demo.web.dto.CurrencyTableDTO;
import com.example.demo.web.dto.UserHistoryDTO;

import java.util.List;

public interface CurrencyService {

    Double getUserCurrencyValue(Currency currency, String userName);
    Double findCurrencyValue(Currency currency, CurrencyTableDTO currencyTableDTO);
    void saveUserSearchHistory(Currency currency, String userName, Double currencyValue);
    List<UserHistoryDTO> getAllUsersSearchHistory();
}
