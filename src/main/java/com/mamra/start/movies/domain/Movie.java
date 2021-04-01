package com.mamra.start.movies.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String logo;
    private int year;
    @JsonIgnore
    @ManyToMany
    private List<Ranking> movieRanking;
  //  @OneToMany(mappedBy = "firstMovie")
  //  private List <Battle> battle;
   // @OneToMany(mappedBy = "secondMovie")
   // private List <Battle> battleSecond;
}
