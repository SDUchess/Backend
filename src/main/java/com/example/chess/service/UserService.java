package com.example.chess.service;

import com.example.chess.model.StudentChess;
import com.example.chess.model.TeacherStudent;
import com.example.chess.model.User;
import com.example.chess.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TeacherStudentRepository teacherStudentRepository;

    @Autowired
    private ClassesStudentRepository classesStudentRepository;

    @Autowired
    private StudentChessRepository studentChessRepository;
    @Autowired
    private TeacherClassesRepository teacherClassesRepository;
    @Autowired
    private ChessBoardRepository chessBoardRepository;
    @Autowired
    private ClassesService classesService;
    @Autowired
    private ChessBoardService chessBoardService;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }


    public List<User> findAllStudents() {
        return userRepository.findByRole("student");
    }

    public List<User> findStudentsByUsername(String username) {
        return userRepository.findByUsernameContainingAndRole(username, "student");
    }

    public void addStudentToTeacher(Long teacherId, Long studentId) {
        teacherStudentRepository.findByTeacherIdAndStudentId(teacherId, studentId).ifPresent(ts -> {
            throw new RuntimeException("该学生已经在教师的管理列表中");
        });
        User teacher = userRepository.findById(teacherId).orElseThrow();
        User student = userRepository.findById(studentId).orElseThrow();
        TeacherStudent ts = new TeacherStudent();
        ts.setTeacher(teacher);
        ts.setStudent(student);
        teacherStudentRepository.save(ts);
    }

    // 查找某个教师管理的所有学生
    public List<User> findStudentsByTeacherId(Long teacherId) {
        // 获取所有与该教师相关联的 TeacherStudent 对象
        List<TeacherStudent> teacherStudents = teacherStudentRepository.findByTeacherId(teacherId);

        // 从中提取学生并返回
        return teacherStudents.stream()
                .map(TeacherStudent::getStudent)
                .collect(Collectors.toList());
    }

    // 删除教师管理的学生
    public void removeStudentFromTeacher(Long teacherId, Long studentId) {
        TeacherStudent teacherStudent = teacherStudentRepository.findByTeacherIdAndStudentId(teacherId, studentId)
                .orElseThrow(() -> new RuntimeException("未找到该学生与教师的关联"));
        classesStudentRepository.deleteByStudentId(studentId);
        teacherStudentRepository.delete(teacherStudent);
    }

    //计算一个学生的得分
    public ResponseEntity<Long> calculateScore(Long studentId){
        Optional<User> student = userRepository.findById(studentId);
        if(student.isEmpty()){
            throw new RuntimeException("未找到对应学生");
        }
        List<StudentChess> list = studentChessRepository.findByStudentId(studentId);
        Long sum = 0L;
        for(StudentChess sc : list){
            sum += sc.getChessBoard().getScore();
        }
        return ResponseEntity.ok(sum);
    }

    //管理员增加用户
    public ResponseEntity<User> addUser(User user){
        if(user == null){
            throw new RuntimeException("传入 user 为 null");
        }
        if(getUserByUsername(user.getUsername()) != null){
            throw new RuntimeException("用户名重复");
        }
        if(!(Objects.equals(user.getRole(), "student") || Objects.equals(user.getRole(), "teacher") || Objects.equals(user.getRole(), "admin"))){
            throw new RuntimeException("role 字段应为 'student' 或 'teacher' 或 'admin' ");
        }
        user = userRepository.save(user);
        return ResponseEntity.ok(user);
    }


    //管理员根据id删除用户
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<String> deleteUserById(Long id){
        if(id == null){
            throw new RuntimeException("传入 id 为空值");
        }
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isEmpty()){
            throw new RuntimeException("未找到对应 user");
        }
        // 如果是学生, 删除学生与班级的关联以及学生的做题记录
        if(Objects.equals(optionalUser.get().getRole(), "student")){
            classesStudentRepository.deleteByStudentId(id);
            studentChessRepository.deleteByStudentId(id);
        }
        // 如果是教师, 删除教师管理的班级以及教师发布的残局
        if(Objects.equals(optionalUser.get().getRole(), "teacher")){
            teacherClassesRepository.findClassesByTeacherId(id).forEach(classes -> classesService.deleteClass(classes.getId()));
            chessBoardService.deleteChessboardsByTeacherId(id);
        }
        userRepository.deleteById(id);
        return ResponseEntity.ok("删除成功");
    }

    //管理员获取所有用户
    public ResponseEntity<List<User>> findAllUser(){
        List<User> list = userRepository.findAll();
        for(User user:list){
            user.setPassword(null);
        }
        return ResponseEntity.ok(list);
    }

    // 管理员获取特定类型的用户
    public ResponseEntity<List<User>> getUserByRole(String role) {
        if(!(Objects.equals(role, "student") || Objects.equals(role, "teacher") || Objects.equals(role, "admin"))){
            throw new RuntimeException("role 字段应为 'student' 或 'teacher' 或 'admin' ");
        }
        List<User> list = userRepository.findByRole(role);
        for(User user:list){
            user.setPassword(null);
        }
        return ResponseEntity.ok(list);
    }

    //管理员根据id修改用户
    public ResponseEntity<User> updateUser(User newUser){
        if(newUser == null){
            throw new RuntimeException("传入 user 为 null");
        }
        if(!(Objects.equals(newUser.getRole(), "student") || Objects.equals(newUser.getRole(), "teacher") || Objects.equals(newUser.getRole(), "admin"))){
            throw new RuntimeException("role 字段应为 'student' 或 'teacher' 或 'admin' ");
        }

        if(newUser.getId() == null){
            throw new RuntimeException("传入 user 的 id 为空值");
        }
        Optional<User> optionalUser = userRepository.findById(newUser.getId());
        if(optionalUser.isEmpty()){
            throw new RuntimeException("未找到对应 user");
        }
        if(!Objects.equals(optionalUser.get().getUsername(), newUser.getUsername()) && getUserByUsername(newUser.getUsername()) != null){
            throw new RuntimeException("用户名重复");
        }
        User u = optionalUser.get();
        if (newUser.getUsername() != null) {
            u.setUsername(newUser.getUsername());
        }
        if (newUser.getPassword() != null) {
            u.setPassword(newUser.getPassword());
        }
        newUser = userRepository.save(u);
        return ResponseEntity.ok(newUser);
    }


}
