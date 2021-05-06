package com.mamra.start.remik.domain;
import lombok.*;
import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Table(name="game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    @ManyToOne
    private Player playerOne;
    @ManyToOne
    private Player playerTwo;
    @ManyToOne
    private Player playerThree;
    @ManyToOne
    private Player playerFour;
    @ManyToOne
    private Player playerFive;
    @OneToMany(mappedBy = "gamePart")
    private List<Part> partList;
}
