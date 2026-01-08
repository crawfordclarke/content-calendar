package com.crawford.content_calendar.controller;


import com.crawford.content_calendar.model.Content;
import com.crawford.content_calendar.repository.ContentRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

// REST controller exposing CRUD endpoints for content

@RestController
@RequestMapping("/api/content")
public class ContentController {


    // repo injection

    private final ContentRepository contentRepository;

    public ContentController(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    // Content retrieval endpoints

    @GetMapping
    public List<Content> getAll() {
        return contentRepository.findAll();
    }

    // returns optional incase it doesn't exist

    @GetMapping("{id}")
    public Optional<Content> findById(@PathVariable int id) {
        return contentRepository.findById(id);

    }


    // POST method for creating new blog posts
    @PostMapping
    public void save(@RequestBody @Valid Content content) {
        contentRepository.create(content);
    }


    // PUT method for updating DB entries
    @PutMapping("/{id}")
    public void update(@PathVariable Integer id,@RequestBody @Valid Content content) {
        // Ensure resource exists before attempting update
        if(!contentRepository.findById(id).isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found");
        }
        contentRepository.update(content);
    }


    // Deletes entries
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        // Ensure resource exists before attempting delete
        if(!contentRepository.findById(id).isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found");
        }
        contentRepository.delete(id);

    }

}
