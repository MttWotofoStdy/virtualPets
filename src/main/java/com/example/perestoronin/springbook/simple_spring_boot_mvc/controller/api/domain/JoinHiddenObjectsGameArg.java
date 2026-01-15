package com.example.perestoronin.springbook.simple_spring_boot_mvc.dao.domain;

import jakarta.validation.constraints.NotNull;

@Schema(description = "Запрос на подключение к игре или создание новой.")
public record JoinHiddenObjectsGameArg(
        @NotNull HiddenObjectsGameType hiddenObjectsGameType) {
}
