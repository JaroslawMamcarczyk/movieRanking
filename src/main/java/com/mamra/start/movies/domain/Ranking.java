package com.mamra.start.movies.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;


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
    @OneToOne
    private User rankingCreator;
    @ManyToMany(mappedBy = "movieRanking")
    private List<Movie> rankingMovie;


}
