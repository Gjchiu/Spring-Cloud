package com.gjchiu.microservices.currencyconversionservice.feignproxy;

import com.gjchiu.microservices.currencyconversionservice.bean.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="currency-exchange")
public interface CurrencyExchangeProxy {
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversion retrieveExchangeValue(@PathVariable String from,
                                                    @PathVariable String to);
}
