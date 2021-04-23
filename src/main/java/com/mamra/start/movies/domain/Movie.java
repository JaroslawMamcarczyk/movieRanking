package com.mamra.start.movies.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Table(name="movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int year;
    @JsonIgnore
    @ManyToMany
    private List<Ranking> movieRanking;
    @JsonIgnore
    @OneToMany(mappedBy = "firstMovie")
    private List <Battle> battle;
    @JsonIgnore
    @OneToMany(mappedBy = "secondMovie")
    private List <Battle> battleSecond;


    public Movie(String title, int year) {
        this.title = title;
        this.year = year;
        this.movieRanking = new ArrayList<>();
    }
}
