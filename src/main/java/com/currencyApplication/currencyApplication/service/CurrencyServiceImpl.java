package com.currencyApplication.currencyApplication.service;

import com.currencyApplication.currencyApplication.client.CurrencyApiClient;
import com.currencyApplication.currencyApplication.dto.CurrencyResponseDto;
import com.currencyApplication.currencyApplication.entity.ConversionHistory;
import com.currencyApplication.currencyApplication.repository.ConversionHistoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {
    private final ConversionHistoryRepository conversionHistoryRepository;
    private final CurrencyApiClient currencyApiClient;
    @Override
    public CurrencyResponseDto convertCurrency(String fromCurrency, String toCurrency, Double amount) {
        log.info("currency conversion started");
        Double rate = currencyApiClient.getExchangeRate(fromCurrency, toCurrency);
        log.info("Exchange rate fetched{}",rate);

        Double convertedAmount = rate*amount;
        ConversionHistory  conversionHistory = new ConversionHistory();
        conversionHistory.setFromCurrency(fromCurrency);
        conversionHistory.setToCurrency(toCurrency);
        conversionHistory.setAmount(amount);
        conversionHistory.setExchangeRate(rate);
        conversionHistory.setConvertedAmount(convertedAmount);
        conversionHistoryRepository.save(conversionHistory);
        log.info("conversion saved to database");
        return CurrencyResponseDto
                .builder()
                .fromCurrency(fromCurrency)
                .toCurrency(toCurrency)
                .amount(amount)
                .exchangeRate(rate)
                .convertedAmount(convertedAmount)
                .build();


    }
}
