package com.example.chess.model;

import lombok.Data;

@Data
public class ChessboardDTO {
    private Long id;
    private String name;
    private String description;
    private Long score;
    /**
     * 返回给学生时, 表示是否已经完成此挑战
     */
    private boolean finished;

    public ChessboardDTO(ChessBoard chessboard) {
        this.id = chessboard.getId();
        this.name = chessboard.getName();
        this.description = chessboard.getDescription();
        this.score = chessboard.getScore();
    }

    public ChessboardDTO(ChessBoard chessboard, boolean finished) {
        this(chessboard);
        this.finished = finished;
    }
}
