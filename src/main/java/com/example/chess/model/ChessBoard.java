package com.example.chess.model;

import jakarta.persistence.*;

@Entity
@Table(name = "chessboards")
public class ChessBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String initialBoard; // Store as JSON string

    private Long teacherId;

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

    public String getInitialBoard() {
        return initialBoard;
    }

    public void setInitialBoard(String initialBoard) {
        this.initialBoard = initialBoard;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    // Getters and Setters
}
