package com.crawford.content_calendar.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;


// record for less boilerplate, with validation
// Validation annotations enforce API input constraints
public record Content(
        @Id
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
