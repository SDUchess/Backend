package com.example.chess.model;

import jakarta.persistence.*;

@Entity
@Table(name = "chess_moves")
public class ChessMove {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long chessboardId;
    private Integer moveOrder;
    private String move; // Store as string like "6,7->6,6"

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getChessboardId() {
        return chessboardId;
    }

    public void setChessboardId(Long chessboardId) {
        this.chessboardId = chessboardId;
    }

    public Integer getMoveOrder() {
        return moveOrder;
    }

    public void setMoveOrder(Integer moveOrder) {
        this.moveOrder = moveOrder;
    }

    public String getMove() {
        return move;
    }

    public void setMove(String move) {
        this.move = move;
    }

    // Getters and Setters
}
