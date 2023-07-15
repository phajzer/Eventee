package com.example.demo.web.dto;

import lombok.Data;

import java.util.ArrayList;

@Data
public class CurrencyTableDTO {
    private String table;
    private String no;
    private String effectiveDate;
    private ArrayList<Rate> rates;

}
