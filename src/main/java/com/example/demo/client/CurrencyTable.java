package com.example.demo.client;

import lombok.Data;

import java.util.ArrayList;

@Data
public class CurrencyTable {
    private String table;
    private String no;
    private String effectiveDate;
    private ArrayList<Rate> rates;
}
