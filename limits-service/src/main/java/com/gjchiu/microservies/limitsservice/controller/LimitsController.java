package com.gjchiu.microservies.limitsservice.controller;

import com.gjchiu.microservies.limitsservice.bean.Limits;
import com.gjchiu.microservies.limitsservice.configuration.LimitsServiceConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {

    @Autowired
    private LimitsServiceConfiguration limitsServiceConfiguration;

    @GetMapping("/limits")
    public Limits retrieveLimits() {
        return new Limits(limitsServiceConfiguration.getMinimum(), limitsServiceConfiguration.getMaximum());
    }

}
