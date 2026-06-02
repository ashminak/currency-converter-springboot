package com.currencyApplication.currencyApplication.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CurrencyResponseDto {
    private String fromCurrency;
    private String toCurrency;
    private double amount;
    private double exchangeRate;
    private double convertedAmount;
}
