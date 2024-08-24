package com.example.chess.repository;

import com.example.chess.model.TeacherStudent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TeacherStudentRepository extends JpaRepository<TeacherStudent, Long> {
    // 根据教师 ID 查找所有相关的 TeacherStudent 记录
    List<TeacherStudent> findByTeacherId(Long teacherId);
    Optional<TeacherStudent> findByTeacherIdAndStudentId(Long teacherId, Long studentId);

    List<TeacherStudent> findByStudentId(Long studentId);
}

