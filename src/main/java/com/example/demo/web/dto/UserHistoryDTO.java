package com.example.demo.web.dto;

import com.example.demo.utils.Currency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserHistoryDTO {
    private Currency currency;
    private String name;
    private LocalDateTime date;
    private Double value;
}
