package com.currencyApplication.currencyApplication.controller;

import com.currencyApplication.currencyApplication.dto.CurrencyResponseDto;
import com.currencyApplication.currencyApplication.entity.ConversionHistory;
import com.currencyApplication.currencyApplication.repository.ConversionHistoryRepository;
import com.currencyApplication.currencyApplication.service.CurrencyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/currency")
@RequiredArgsConstructor
@Tag(name = "Currency APIs")
public class CurrencyController {
    private final CurrencyService currencyService;
    private final ConversionHistoryRepository conversionHistoryRepository;
    @Operation(
            summary = "Convert Currency"
    )
    @GetMapping("/convery")
    public CurrencyResponseDto convertCurrency(@RequestParam String fromCurrency, @RequestParam String toCurrency,@RequestParam Double amount) {
     return currencyService.convertCurrency(fromCurrency, toCurrency, amount);
    }
    @GetMapping("/history")
    public List<ConversionHistory> getConversionHistory(){
        return conversionHistoryRepository.findAll();
    }
}
