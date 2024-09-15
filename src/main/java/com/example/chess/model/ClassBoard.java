package com.example.chess.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "class_board")
public class ClassBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private ChessBoard chessBoard;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Classes classes;
}
