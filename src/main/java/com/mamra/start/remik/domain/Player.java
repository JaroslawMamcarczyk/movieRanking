package com.mamra.start.remik.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Table(name="player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @JsonIgnore
    @OneToMany(mappedBy = "playerOne")
    private List<Game> gameOne;
    @JsonIgnore
    @OneToMany (mappedBy = "playerTwo")
    private List<Game>gameTwo;
    @JsonIgnore
    @OneToMany (mappedBy = "playerThree")
    private List<Game> gameThree;
    @JsonIgnore
    @OneToMany (mappedBy = "playerFour")
    private List<Game> gameFour;
    @JsonIgnore
    @OneToMany (mappedBy = "playerFive")
    private List<Game> gameFive;
    @JsonIgnore
    @OneToMany(mappedBy = "crupper")
    private List<Part> partList;
}
