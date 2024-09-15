package com.example.chess.controller;

import com.example.chess.model.*;
import com.example.chess.model.DTO.ClassesBoardDTO;
import com.example.chess.model.DTO.PageResult;
import com.example.chess.service.ClassesService;
import com.example.chess.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/class")
public class ClassesController {
    @Autowired
    private ClassesService classesService;

    //新增班级
    @PostMapping("/add")
    public ResponseEntity<Classes> saveClass(@RequestBody TeacherClasses teacherClasses){
        return classesService.saveClass(teacherClasses);
    }

    //添加残局至班级
    @PostMapping("/add/ChessBoardToClass")
    public ResponseEntity<String> saveClassBoards(@RequestBody ClassesBoardDTO classesBoard){
        return classesService.saveClassBoards(classesBoard.getClasses(),classesBoard.getChessBoard());
    }

    //添加学生至班级
    @PostMapping("/add/StudentToClass")
    public ResponseEntity<String> saveClassStudent(@RequestBody ClassesStudent classesStudent){
        return classesService.saveClassStudent(classesStudent);
    }

    //删除班级
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteClass(@PathVariable(name = "id") Long id){
        return classesService.deleteClass(id);
    }

    //删除班级与残局的关联
    @DeleteMapping("/delete/classWithBoard")
    public ResponseEntity<String> deleteClassBoard(@RequestParam Long classId,@RequestParam Long chessId){
        return classesService.deleteClassBoard(classId,chessId);
    }

    //删除班级与学生的关联
    @DeleteMapping("/delete/classWithStudent")
    public ResponseEntity<String> deleteClassStudent(@RequestParam Long classId,@RequestParam Long studentId){
        return classesService.deleteClassStudent(classId,studentId);
    }

    //根据id查询班级
    @GetMapping("/get/{id}")
    public ResponseEntity<Classes> findClassById(@PathVariable(name = "id") Long id){
        return classesService.findClassById(id);
    }

    //获取班级列表（分页）
    @GetMapping("/get/all")
    public ResponseEntity<PageResult<Classes>> findAllClasses(@RequestParam int pageSize,@RequestParam int number){
        return classesService.findAllClasses(pageSize,number);
    }

    //根据班级查找学生
    @GetMapping("/get/studentByClassId")
    public ResponseEntity<List<User>> findStudentsByClass(@RequestParam Long id){
        return classesService.findStudentsByClass(id);
    }

    //根据学生查找班级
    @GetMapping("/get/classByStudentId")
    public ResponseEntity<Classes> findClassByStudent(@RequestParam Long id){
        return classesService.findClassByStudent(id);
    }

    //根据班级查找残局
    @GetMapping("/get/chessboardByClassId")
    public ResponseEntity<List<ChessBoard>> findChessBoardsByClass(@RequestParam Long id){
        return classesService.findChessBoardsByClass(id);
    }

    //根据残局查找班级
    @GetMapping("/get/classByChessboardId")
    public ResponseEntity<List<Classes>> findClassByChessBoard(@RequestParam Long id){
        return classesService.findClassByChessBoard(id);
    }

    //根据教师查找班级
    @GetMapping("/get/classByTeacherId")
    public ResponseEntity<List<Classes>> findClassesByTeacher(@RequestParam Long id){
        return classesService.findClassesByTeacher(id);
    }

    //根据班级查找教师
    @GetMapping("/get/teacherByClassId")
    public ResponseEntity<User> findTeacherByClass(@RequestParam Long id){
        return classesService.findTeacherByClass(id);
    }

}
