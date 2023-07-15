package com.example.demo.repo;
import com.example.demo.utils.Currency;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;


@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    private Currency currency;

    private String name;

    private LocalDateTime date;

    private double currencyValue;
}
