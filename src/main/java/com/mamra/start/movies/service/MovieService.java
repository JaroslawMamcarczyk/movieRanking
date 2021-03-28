package com.mamra.start.movies.service;
import com.mamra.start.movies.domain.Movie;
import com.mamra.start.movies.repository.MovieRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
public class MovieService {
    private final MovieRepository movieRepository;


    MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    public List<Movie> getMovie() {
        List<Movie> listMovie = movieRepository.findAll();
        return listMovie;
    }

    public Optional<Movie> getMovieById(Long id) {
        Optional<Movie> movie = movieRepository.findById(id);
        return movie;
    }

    public String addMovie(Movie movie){
        Optional<Movie> movieFromDb = movieRepository.findByTitle(movie.getTitle());
        if(movieFromDb.isPresent()){
            return "Nie można zapisać";
        }else {
            movieRepository.save(movie);
            return movie.getTitle()+" został zapisany";
        }
    }

    public boolean deleteMovie(Movie movie){
        Optional<Movie> movieFromDb = movieRepository.findByTitle(movie.getTitle());
        if(movieFromDb.isPresent()){
            movieRepository.delete(movie);
            return true;
        }else{
            return false;
        }
    }
}
