package com.example.chess.model;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "student_chess")
public class StudentChess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "chess_id")
    private ChessBoard chessBoard;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private User student;
}
