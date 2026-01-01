package com.crawford.content_calendar.controller;


import com.crawford.content_calendar.model.Content;
import com.crawford.content_calendar.repository.ContentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/content")
public class ContentController {


    private final ContentRepository contentRepository;

    public ContentController(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    @GetMapping
    public List<Content> getAll() {
        return contentRepository.findAll();
    }

    @GetMapping("{id}")
    public Optional<Content> findById(@PathVariable int id) {
        return contentRepository.findById(id);

    }


}
