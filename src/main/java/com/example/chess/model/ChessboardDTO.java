package com.example.chess.model;

import com.example.chess.model.ChessBoard;

public class ChessboardDTO {
    private Long id;
    private String name;
    private int moveCount;

    public ChessboardDTO(ChessBoard chessboard, int moveCount) {
        this.id = chessboard.getId();
        this.name = chessboard.getName();
        this.moveCount = moveCount;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void setMoveCount(int moveCount) {
        this.moveCount = moveCount;
    }
}
