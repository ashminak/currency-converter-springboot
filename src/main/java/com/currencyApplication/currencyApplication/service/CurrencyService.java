package com.currencyApplication.currencyApplication.service;

import com.currencyApplication.currencyApplication.dto.CurrencyResponseDto;

public interface CurrencyService {
     CurrencyResponseDto convertCurrency(String fromCurrency,
                                               String toCurrency,
                                               Double amount);
}