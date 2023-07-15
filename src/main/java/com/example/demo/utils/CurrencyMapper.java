package com.example.demo.utils;

import com.example.demo.repo.UserHistory;
import com.example.demo.web.dto.UserHistoryDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CurrencyMapper {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static UserHistoryDTO mapUserHistoryToDTO(UserHistory user) {
        return objectMapper.convertValue(user, UserHistoryDTO.class);
    }
}
