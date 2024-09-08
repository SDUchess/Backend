package com.example.chess.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "chess_moves")
public class ChessMove {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long chessboardId;
    private Integer moveOrder;
    private String move; // Store as string like "6,7->6,6"
}
