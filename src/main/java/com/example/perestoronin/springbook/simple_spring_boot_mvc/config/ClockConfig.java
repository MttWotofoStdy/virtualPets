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
    @Profile({"test-dao", "test-mock-mvc"})
    @Bean
    public Clock clock() {
        ZoneId zoneId = ZoneId.of("Europe/Moscow");
        TemporalAccessor offsetDateTime = ZonedDateTime.of(
                2025, 12, 12, 18, 52, 0, 0, zoneId);
        Instant instant = Instant.from(offsetDateTime);
        return Clock.fixed(instant, zoneId);

    }

}
