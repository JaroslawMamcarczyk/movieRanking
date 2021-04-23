package com.mamra.start.movies.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mamra.start.movies.api.response.MovieResponse;
import com.mamra.start.movies.domain.Movie;
import com.mamra.start.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
@CrossOrigin
    @PostMapping("/movie/add")
    public ResponseEntity addMovie(@RequestBody MovieResponse movie) throws JsonProcessingException {
        Movie newMovie = new Movie(movie.getTitle(),movie.getLogo(), movie.getYear());
        String isAdded = movieService.addMovie(newMovie);
        return ResponseEntity.ok(isAdded);
    }

    @CrossOrigin
    @DeleteMapping("/deleteMovie/id/{}")
    public ResponseEntity deleteMovie(@RequestParam Long id) throws  JsonProcessingException{
       boolean isDelete = movieService.deleteMovie(id);
       if(isDelete){
           return ResponseEntity.ok("isDelete");
       }else{
           return ResponseEntity.ok("brak filmu");
       }
    }
}
