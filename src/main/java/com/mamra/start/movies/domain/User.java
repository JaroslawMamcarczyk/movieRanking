package com.mamra.start.movies.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @NonNull
    private String name;
    @NonNull
    private String password;
    @OneToOne(mappedBy = "rankingCreator")
    private Ranking creatorRanking;
}