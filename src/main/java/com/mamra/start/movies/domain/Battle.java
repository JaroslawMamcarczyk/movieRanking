package com.mamra.start.movies.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
@Table(name="battle")
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
    private int winner;
}
