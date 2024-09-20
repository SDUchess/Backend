package com.example.chess.model.DTO;

import com.example.chess.model.User;
import lombok.Data;

@Data
public class StudentDTO {
    private Long id;
    private Long totalScore;
    private String username;

    public StudentDTO(User student, Long totalScore) {
        this.id = student.getId();
        this.username = student.getUsername();
        this.totalScore = totalScore;
    }
}
