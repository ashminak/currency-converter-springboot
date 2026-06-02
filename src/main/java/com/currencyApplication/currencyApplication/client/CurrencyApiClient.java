package com.currencyApplication.currencyApplication.client;

import com.currencyApplication.currencyApplication.dto.CurrencyApiResponse;
import org.springframework.beans.factory.annotation.Value;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
@RequiredArgsConstructor
public class CurrencyApiClient {
    private final RestClient restClient;

    @Value("${currency.api.key}")
    private String apiKey;

    public Double getExchangeRate(String fromCurrency, String toCurrency) {
        String url =  "https://api.freecurrencyapi.com/v1/latest"
                +"?apikey=" + apiKey
                + "&base_currency=" + fromCurrency
                + "&currencies=" + toCurrency;

        CurrencyApiResponse response= restClient.get()
                .uri(url)
                .retrieve()
                .body(CurrencyApiResponse.class);
        System.out.println(response.getData());
        return response
                .getData()
                .get(toCurrency);
    }
}

