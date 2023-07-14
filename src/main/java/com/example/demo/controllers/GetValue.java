package com.example.demo.controllers;

import com.example.demo.utils.Currency;
import lombok.Data;

@Data
public class GetValue {
    private Currency currency;
    private String name;
}
