package com.sankethsankuri.movieservice.controller;

import com.sankethsankuri.movieservice.model.Movie;
import com.sankethsankuri.movieservice.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class MovieController {
    private MovieService movieService;

    @GetMapping("/{id}")
    public ResponseEntity<Movie> GetMovie(@PathVariable Long id) {
        Movie movie = movieService.read(id);
        return ResponseEntity.ok(movie);
    }

    @PostMapping("/create")
    public ResponseEntity<Movie> CreateMovie(@RequestBody Movie movie) {
        Movie createMovie = movieService.create(movie);
        return ResponseEntity.ok(createMovie);
    }
}


