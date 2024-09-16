package com.example.chess.repository;

import com.example.chess.model.StudentChess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


public interface StudentChessRepository extends JpaRepository<StudentChess,Long> {

    //根据学生id查找(找学生的做题记录)
    @Query(value = "select sc from StudentChess sc where sc.student.id = :studentId")
    List<StudentChess> findByStudentId(@Param("studentId") Long studentId);
}
