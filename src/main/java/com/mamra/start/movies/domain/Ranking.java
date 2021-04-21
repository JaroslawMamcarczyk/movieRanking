package com.mamra.start.movies.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Ranking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rankingCategory;
    private String description;
    @ManyToMany(mappedBy = "movieRanking")
    private List<Movie> rankingMovie;
    @JsonIgnore
    @OneToMany(mappedBy = "ranking")
    private Set<Battle> battleSet;

    public Ranking(String rankingCategory, String description) {
        this.rankingCategory = rankingCategory;
        this.description = description;
    }
}
