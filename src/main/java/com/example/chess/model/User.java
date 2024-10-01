package com.example.chess.model;

import com.example.chess.model.DTO.UserExcel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name = "users")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String role; // 'student' or 'teacher' or 'admin'

    public User(UserExcel userExcel) {
        this.username = userExcel.getUsername();
        this.password = userExcel.getPassword();
        int role = userExcel.getRole();
        switch (role) {
            case 1 -> this.role = "student";
            case 2 -> this.role = "teacher";
            // case 3 -> this.role = "admin";
            default -> throw new RuntimeException("未知的用户角色类型");
        }
    }
}
