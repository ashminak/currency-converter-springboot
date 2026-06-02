package com.currencyApplication.currencyApplication.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;
@Getter
@Setter
public class CurrencyApiResponse {
    private Map<String,Double> data;

}
