package com.crawford.content_calendar.controller;


import com.crawford.content_calendar.model.Content;
import com.crawford.content_calendar.repository.ContentRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
    @PostMapping
    public void save(@RequestBody @Valid Content content) {
        contentRepository.create(content);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id,@RequestBody @Valid Content content) {
        if(!contentRepository.findById(id).isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found");
        }
        contentRepository.update(content);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        if(!contentRepository.findById(id).isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found");
        }
        contentRepository.delete(id);

    }

}
