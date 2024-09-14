package com.example.chess.repository;

import com.example.chess.model.Classes;
import com.example.chess.model.ClassesStudent;
import com.example.chess.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ClassesStudentRepository extends JpaRepository<ClassesStudent,Long> {

    //插入班级与学生对应关系
    //用的自带的

    //根据班级查找学生
    @Query(value = "SELECT u.* " +
            "FROM users u LEFT JOIN classes_student cs ON u.id = cs.student_id " +
            "WHERE cs.class_id = :classId",
            nativeQuery = true)
    List<User> findStudentByClassesId(@Param("classId") Long classId);

    //根据学生查找班级
    @Query(value = "SELECT c.* " +
            "FROM classes as c LEFT JOIN classes_student cs  ON cs.class_id = c.id " +
            "WHERE cs.student_id = :StudentId",
            nativeQuery = true)
    Classes findClassByStudentId(@Param("StudentId") Long StudentId);

    // 删除班级与学生的关联(通过班级id)
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM classes_student WHERE class_id = :classId",
            nativeQuery = true)
    void deleteByClassId(@Param("classId") Long classId);

    //删除班级与学生的关联（通过学生id)
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM classes_student WHERE student_id = :studentId",
            nativeQuery = true)
    void deleteByStudentId(@Param("studentId") Long studentId);

    //删除班级与学生的关联（通过学生id和班级id)
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM classes_student WHERE student_id = :studentId AND class_id = :classId",
            nativeQuery = true)
    void deleteByStudentIdAndClassId(@Param("studentId") Long studentId,@Param("classId") Long classId);


}
