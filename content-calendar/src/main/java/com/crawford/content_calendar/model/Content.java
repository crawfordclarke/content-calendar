package com.crawford.content_calendar.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDateTime;

public record Content(
        Integer id,
        @NotBlank
        String title,
        String description,
        @NotNull
        Status status,
        Type contentType,
        @PastOrPresent
        LocalDateTime dateCreated,
        LocalDateTime dateUpdated,
        String url
) {
}
