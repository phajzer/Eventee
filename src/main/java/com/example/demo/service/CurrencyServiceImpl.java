package com.example.demo.service;

import com.example.demo.utils.CurrencyMapper;
import com.example.demo.web.dto.CurrencyTableDTO;
import com.example.demo.web.client.NBPClient;
import com.example.demo.repo.UserHistory;
import com.example.demo.repo.UserHistoryRepository;
import com.example.demo.utils.Currency;
import com.example.demo.web.dto.UserHistoryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static com.example.demo.utils.CurrencyMapper.mapUserHistoryToDTO;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

    private final UserHistoryRepository userHistoryRepository;
    private final NBPClient nbpClient;

    public Double getUserCurrencyValue(Currency currency, String userName) {
        CurrencyTableDTO[] currencyTableDTO = nbpClient.getCurrencyTable();
        Double currencyValue = findCurrencyValue(currency, currencyTableDTO[0]);
        saveUserSearchHistory(currency, userName, currencyValue);
        return currencyValue;
    }

    public Double findCurrencyValue(Currency currency, CurrencyTableDTO currencyTableDTO) {
        return currencyTableDTO.getRates().stream()
                .filter(x -> x.getCode().equals(currency.toString()))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Currency not found in the table"))
                .getMid();
    }

    public void saveUserSearchHistory(Currency currency, String userName, Double currencyValue) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        UserHistory userHistory = UserHistory.builder()
                .currency(currency)
                .name(userName)
                .date(currentDateTime)
                .currencyValue(currencyValue)
                .build();
        userHistoryRepository.save(userHistory);
    }

    public List<UserHistoryDTO> getAllUsersSearchHistory() {
        return userHistoryRepository.findAll().stream()
                .map(CurrencyMapper::mapUserHistoryToDTO)
                .collect(Collectors.toList());
    }
}


