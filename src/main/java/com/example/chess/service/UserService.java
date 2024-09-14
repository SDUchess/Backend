package com.example.chess.service;

import com.example.chess.model.TeacherStudent;
import com.example.chess.model.User;
import com.example.chess.repository.ClassesStudentRepository;
import com.example.chess.repository.TeacherStudentRepository;
import com.example.chess.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TeacherStudentRepository teacherStudentRepository;

    @Autowired
    private ClassesStudentRepository classesStudentRepository;

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
}
