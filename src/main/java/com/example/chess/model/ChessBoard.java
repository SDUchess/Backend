package com.example.chess.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "chessboards")
public class ChessBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @Column(columnDefinition = "TEXT")
    private String initialBoard; // Store as JSON string

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private User publisher;

    //得分
    private Long score;
}
