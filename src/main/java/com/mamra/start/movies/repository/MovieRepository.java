package com.mamra.start.movies.repository;

import com.mamra.start.movies.domain.Movie;
import com.mamra.start.movies.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {
    Optional<Movie> findByName(String movieName);
}
