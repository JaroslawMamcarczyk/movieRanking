package com.mamra.start.movies.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mamra.start.movies.domain.Movie;
import com.mamra.start.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
public class MovieApi {
@Autowired
private ObjectMapper objectMapper;
    private MovieService movieService;
    MovieApi(MovieService movieService){
        this.movieService = movieService;
    }

    @CrossOrigin
    @GetMapping("/movies")
    public ResponseEntity getMovie() throws JsonProcessingException {
        List<Movie> listMovie = movieService.getMovie();
        return ResponseEntity.ok(objectMapper.writeValueAsString(listMovie));
    }

    @CrossOrigin
    @GetMapping("/movie/id/{}")
    public ResponseEntity getMovieById(@RequestParam Long id) throws JsonProcessingException {
        Optional<Movie> movie = movieService.getMovieById(id);
        return ResponseEntity.ok(objectMapper.writeValueAsString(movie));
    }

    @PostMapping("/movie/add")
    public ResponseEntity addMovie(@RequestBody Movie movie) throws JsonProcessingException {
        String isAdded = movieService.addMovie(movie);
        return ResponseEntity.ok(isAdded);
    }
}
