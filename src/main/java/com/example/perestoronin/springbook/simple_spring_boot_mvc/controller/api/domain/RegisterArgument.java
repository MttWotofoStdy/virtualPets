package com.example.perestoronin.springbook.simple_spring_boot_mvc.controller.api.domain;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.jspecify.annotations.NonNull;

public record RegisterArgument(
        @NonNull @Size(min = 3, max = 50) String login,
        @NonNull @Size(min = 3, max = 50) String name,
        @NonNull @Size(min = 3, max = 50) String password,
        @NonNull @Size(min = 3, max = 50) String email,
        @NonNull @Size(min = 3, max = 50) String version
) {
}