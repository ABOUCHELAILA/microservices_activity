package com.sdia.custumorservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "customer.params")
public record CustumorConfigParams(int x, int y) {
}
