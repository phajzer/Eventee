package com.example.demo.web.dto;

import com.example.demo.utils.Currency;
import lombok.Data;

@Data
public class CurrentCurrencyRequest {
    private Currency currency;
    private String name;
}
