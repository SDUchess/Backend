package com.example.chess.repository;

import com.example.chess.model.Classes;
import com.example.chess.model.TeacherClasses;
import com.example.chess.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeacherClassesRepository extends JpaRepository<TeacherClasses,Long> {

    //插入教师与班级对应关系
    //用的自带的

    //根据教师查找班级
    @Query(value = "SELECT c.* " +
            "FROM classes c LEFT JOIN teacher_classes tc ON tc.class_id = c.id " +
            "WHERE tc.teacher_id = :id",
            nativeQuery = true)
    List<Classes> findClassesByTeacherId(@Param("id") Long id);

    //根据班级查找教师
    @Query(value = "SELECT u.* " +
            "FROM users u LEFT JOIN teacher_classes tc ON tc.teacher_id = u.id " +
            "WHERE tc.teacher_id = :id",
            nativeQuery = true)
    User findTeacherByClass(@Param("id") Long id);

}
