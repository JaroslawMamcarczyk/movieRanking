package com.mamra.start.remik.domain;

import lombok.*;
import com.mamra.start.remik.domain.Game;
import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Table(name="part")
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int playerOneResult;
    private int playerTwoResult;
    private int playerThreeResult;
    private int playerFourResult;
    @ManyToOne
    private Player crupper;
    @ManyToOne
    private Game gamePart;

}
