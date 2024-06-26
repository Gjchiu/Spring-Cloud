package com.gjchiu.microservices.currencyconversionservice.controller;

import com.gjchiu.microservices.currencyconversionservice.feignproxy.CurrencyExchangeProxy;
import com.gjchiu.microservices.currencyconversionservice.bean.CurrencyConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@RestController
public class CurrencyConversionController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CurrencyExchangeProxy currencyExchangeProxy;

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversion(@PathVariable String from,
                                                          @PathVariable String to,
                                                          @PathVariable BigDecimal quantity) {
        ResponseEntity<CurrencyConversion> responseEntity = restTemplate
                .getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class, from, to);
        CurrencyConversion currencyConversion = responseEntity.getBody();
        return new CurrencyConversion(currencyConversion.getId(),
                currencyConversion.getFrom(),
                currencyConversion.getTo(),
                quantity,
                currencyConversion.getConversionMultiple(),
                quantity.multiply(currencyConversion.getConversionMultiple()),
                currencyConversion.getEnvironment() + " " + "rest template");
    }

    @GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversionFeign(@PathVariable String from,
                                                               @PathVariable String to,
                                                               @PathVariable BigDecimal quantity) {

        CurrencyConversion currencyConversion = currencyExchangeProxy.retrieveExchangeValue(from, to);
        return new CurrencyConversion(currencyConversion.getId(),
                currencyConversion.getFrom(),
                currencyConversion.getTo(),
                quantity,
                currencyConversion.getConversionMultiple(),
                quantity.multiply(currencyConversion.getConversionMultiple()),
                currencyConversion.getEnvironment() + " " + "feign");
    }
}
