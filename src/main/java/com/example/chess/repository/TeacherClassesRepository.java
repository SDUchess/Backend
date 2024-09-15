package com.example.chess.repository;

import com.example.chess.model.Classes;
import com.example.chess.model.TeacherClasses;
import com.example.chess.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TeacherClassesRepository extends JpaRepository<TeacherClasses,Long> {

    //插入教师与班级对应关系
    //用的自带的

    //根据教师查找班级
    @Query(value = "select tc.classes from TeacherClasses tc where tc.teacher.id = :id")
    List<Classes> findClassesByTeacherId(Long id);

    //根据班级查找教师
    @Query(value = "SELECT u.* " +
            "FROM users u LEFT JOIN teacher_classes tc ON tc.teacher_id = u.id " +
            "WHERE tc.teacher_id = :id",
            nativeQuery = true)
    User findTeacherByClass(@Param("id") Long id);

    //删除老师与班级的关联(通过班级id)
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM teacher_classes WHERE class_id = :classId",
            nativeQuery = true)
    void deleteByClassId(@Param("classId") Long id);

    //删除老师与班级的关联(通过老师id)
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM teacher_classes WHERE teacher_id = :teacherId",
            nativeQuery = true)
    void deleteByTeacherId(@Param("teacherId") Long id);

    //删除老师与班级的关联(通过老师id和班级id)
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM teacher_classes WHERE teacher_id = :teacherId AND class_id = :classId",
            nativeQuery = true)
    void deleteByTeacherIdAndClassId(@Param("teacherId") Long teacherId,@Param("classId") Long classId);



}
