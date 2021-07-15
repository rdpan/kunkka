package com.hhl.kunkka.client;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = {"com.hhl.kunkka.client", "com.hhl.kunkka.at"})
public class KunkkaClientConfiguration {
}
