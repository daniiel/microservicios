package com.microservices.limitsservice;

import com.microservices.limitsservice.bean.LimitConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {

    @Autowired
    private Configuration config;

    @GetMapping("/limits")
    public LimitConfiguration retrievesLimitsFromConfigurations() {
        return new LimitConfiguration(config.getMaximum(), config.getMinimum());
    }
}
