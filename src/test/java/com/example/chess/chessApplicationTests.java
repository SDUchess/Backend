package com.example.chess;

import com.example.chess.model.Classes;
import com.example.chess.model.TeacherClasses;
import com.example.chess.model.TeacherStudent;
import com.example.chess.repository.ClassesRepository;
import com.example.chess.repository.TeacherClassesRepository;
import com.example.chess.repository.TeacherStudentRepository;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class chessApplicationTests {

    @Resource
    private TeacherClassesRepository teacherClassesRepository;
    @Resource
    private TeacherStudentRepository teacherStudentRepository;
    @Resource
    private ClassesRepository classesRepository;

    @Test
    void contextLoads() {
        List<Classes> classesByTeacherId = teacherClassesRepository.findClassesByTeacherId(2L);
        System.out.println("classesByTeacherId = " + classesByTeacherId);
    }

    @Test
    void test() {
        List<TeacherStudent> byStudentId = teacherStudentRepository.findByStudentId(4L);
        System.out.println(byStudentId);
    }

    @Test
    void test1() {
        List<Classes> allClasses = classesRepository.findAllClasses(99, 0);
        System.out.println(allClasses);
    }
}
