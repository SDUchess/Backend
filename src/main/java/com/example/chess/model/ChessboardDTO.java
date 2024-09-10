package com.example.chess.model;

import lombok.Data;

@Data
public class ChessboardDTO {
    private Long id;
    private String name;
    private int moveCount;
    private String description;

    public ChessboardDTO(ChessBoard chessboard, int moveCount) {
        this.id = chessboard.getId();
        this.name = chessboard.getName();
        this.moveCount = moveCount;
        this.description = chessboard.getDescription();
    }
}
