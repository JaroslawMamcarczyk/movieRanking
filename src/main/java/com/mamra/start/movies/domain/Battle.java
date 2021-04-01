package com.mamra.start.movies.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
public class Battle {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Movie firstMovie;
    @ManyToOne
    private Movie secondMovie;
    @ManyToOne
    private Ranking ranking;
}
