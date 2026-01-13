package com.example.perestoronin.springbook.simple_spring_boot_mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAccessor;

@Configuration

public class ClockConfig {

    @Bean
    public Clock clock() {
        return Clock.systemDefaultZone();
    }


}
