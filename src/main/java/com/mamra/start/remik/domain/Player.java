package com.mamra.start.remik.domain;

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
    @OneToMany(mappedBy = "playerOne")
    private List<Game> gameOne;
    @OneToMany (mappedBy = "playerTwo")
    private List<Game>gameTwo;
    @OneToMany (mappedBy = "playerThree")
    private List<Game> gameThree;
    @OneToMany (mappedBy = "playerFour")
    private List<Game> gameFour;
    @OneToMany (mappedBy = "playerFive")
    private List<Game> gameFive;
    @OneToMany(mappedBy = "crupper")
    private List<Part> partList;
}
