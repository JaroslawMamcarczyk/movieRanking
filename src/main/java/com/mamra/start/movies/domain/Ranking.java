package com.mamra.start.movies.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name="rankings")
public class Ranking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rankingCategory;
    private String description;
    @ManyToMany()
    @JoinTable(
            name="movies_rankings",
            joinColumns = {@JoinColumn(name="id_rankings")},
            inverseJoinColumns = {@JoinColumn(name="id_movies")}
    )
    private List<Movie> rankingMovie;
    @JsonIgnore
    @OneToMany(mappedBy = "ranking")
    private Set<Battle> battleSet;

    public Ranking(String rankingCategory, String description) {
        this.rankingCategory = rankingCategory;
        this.description = description;
        this.rankingMovie = new ArrayList<>();
    }

    public void addMovies(Movie movies){
        this.rankingMovie.add(movies);
        if(movies.getRankingMovies()!=null)
        movies.getRankingMovies().add(this);
    }
}
