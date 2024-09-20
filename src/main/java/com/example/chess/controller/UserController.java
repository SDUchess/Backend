package com.example.chess.controller;

import com.example.chess.model.User;
import com.example.chess.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    // 注册用户
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        // 检查用户名是否已存在
        User existingUser = userService.getUserByUsername(user.getUsername());
        if (existingUser != null) {
            throw new RuntimeException("用户名已存在");
        }
        return userService.saveUser(user);
    }

    // 登录用户
    @PostMapping("/login")
    public User login(@RequestBody User user) {
        User foundUser = userService.getUserByUsername(user.getUsername());
        if (foundUser != null && foundUser.getPassword().equals(user.getPassword())) {
            return foundUser;
        }
        throw new RuntimeException("用户名或密码错误");
    }

    // 获取学生列表，支持通过用户名搜索
    @GetMapping("/students")
    public List<User> getStudents(@RequestParam(required = false) String username) {
        if (username != null && !username.isEmpty()) {
            return userService.findStudentsByUsername(username);
        } else {
            return userService.findAllStudents();
        }
    }

    @PostMapping("/addStudentToTeacher")
    public ResponseEntity<?> addStudentToTeacher(@RequestParam Long teacherId, @RequestParam Long studentId) {
        userService.addStudentToTeacher(teacherId, studentId);
        return ResponseEntity.ok().body("学生已成功加入管理列表");
    }

    // 根据教师 ID 获取其管理的所有学生
    @GetMapping("/teacher/{teacherId}/students")
    public List<User> getStudentsByTeacherId(@PathVariable Long teacherId) {
        return userService.findStudentsByTeacherId(teacherId);
    }

    // 根据教师 ID 和学生 ID 删除学生
    @DeleteMapping("/teacher/{teacherId}/student/{studentId}")
    public ResponseEntity<?> removeStudentFromTeacher(@PathVariable Long teacherId, @PathVariable Long studentId) {
        userService.removeStudentFromTeacher(teacherId, studentId);
        return ResponseEntity.ok().body("学生已成功从管理列表中删除");
    }

    //计算一个学生的得分
    @GetMapping("/student/getScoreById")
    public ResponseEntity<Long> calculateScore(@RequestParam Long studentId){
        return userService.calculateScore(studentId);
    }

    //管理员增加用户
    @PostMapping("/admin/addUser")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    //管理员根据id删除用户
    @DeleteMapping("/admin/deleteById")
    public ResponseEntity<String> deleteUserById(@RequestParam Long id){
        return userService.deleteUserById(id);
    }

    //管理员获取所有用户
    @GetMapping("/admin/getAll")
    public ResponseEntity<List<User>> findAllUser(){
        return userService.findAllUser();
    }

    //管理员根据id修改用户
    @PostMapping("/admin/updateUser")
    public ResponseEntity<User> updateUser(@RequestBody User newUser){
        return userService.updateUser(newUser);
    }

}
