package com.example.chess.model;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "classes_student")
public class ClassesStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Classes classes;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private User student;

}
