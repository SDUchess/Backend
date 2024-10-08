package com.example.chess.service;

import com.example.chess.model.*;
import com.example.chess.model.DTO.PageResult;
import com.example.chess.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClassesService {

    @Autowired
    private ClassesRepository classesRepository;

    @Autowired
    private ClassesStudentRepository classesStudentRepository;

    @Autowired
    private ClassBoardRepository classBoardRepository;

    @Autowired
    private TeacherClassesRepository teacherClassesRepository;

    @Autowired
    private ChessBoardRepository chessBoardRepository;

    @Autowired
    private UserRepository userRepository;

    //新增班级(会顺便添加教师与班级的关联)
    public ResponseEntity<Classes> saveClass(TeacherClasses teacherClasses){
        Classes classes = teacherClasses.getClasses();
        User teacher = teacherClasses.getTeacher();
        if(classesRepository.findByName(classes.getName()).isPresent()){
            throw new RuntimeException("班级名称重复");
        }
        Classes newClasses = classesRepository.save(classes);
        teacherClassesRepository.save(new TeacherClasses(null,teacher,newClasses));
        return ResponseEntity.ok(newClasses);
    }


    //删除班级
    public ResponseEntity<String> deleteClass(Long id){
        if(id == null){
            throw new RuntimeException("id 传入值为 null");
        }
        if(classesRepository.findById(id).isEmpty()){
            throw new RuntimeException("未找到 id 对应的班级");
        }
        // 先删除班级与学生、残局和教师的关联
        classesStudentRepository.deleteByClassId(id);
        classBoardRepository.deleteClassBoardByClassesId(id);
        teacherClassesRepository.deleteByClassId(id);
        // 再删除班级
        classesRepository.deleteById(id);
        return ResponseEntity.ok("删除成功");
    }

    //删除班级与残局的关联
    public ResponseEntity<String> deleteClassBoard(Long classId,Long chessId){
        classBoardRepository.deleteClassBoardByBoardIdAndClassId(classId,chessId);
        return ResponseEntity.ok("删除成功");
    }

    //删除班级与学生的关联
    public ResponseEntity<String> deleteClassStudent(Long classId,Long studentId){
        classesStudentRepository.deleteByStudentIdAndClassId(studentId,classId);
        return ResponseEntity.ok("删除成功");
    }

    //根据id查询班级
    public ResponseEntity<Classes> findClassById(Long id){
        if(id == null){
            throw new RuntimeException("传入 id 为 null");
        }
        Optional<Classes> classesOptional = classesRepository.findById(id);
        if(classesOptional.isEmpty()){
            throw new RuntimeException("未找到 id 对应的班级");
        }
        return ResponseEntity.ok(classesOptional.get());
    }

    //获取班级列表（分页）
    public ResponseEntity<PageResult<Classes>> findAllClasses(int pageSize,int number){
        PageResult<Classes> result = new PageResult<>();
        int tot = classesRepository.findAllClassesNumbers();
        result.setRecordNumber(tot);
        if(tot < pageSize*(number-1)){
            throw new RuntimeException("超过总记录数:"+tot);
        }
        List<Classes> list = classesRepository.findAllClasses(pageSize,pageSize*(number-1));
        result.setList(list);
        return ResponseEntity.ok(result);
    }

    //添加残局至班级
    public ResponseEntity<String> saveClassBoards(List<Long> classesIds, Long chessBoardId){
        List<ClassBoard> list = new ArrayList<>();

        Optional<ChessBoard> chessBoard = chessBoardRepository.findById(chessBoardId);
        if(chessBoard.isEmpty()){
            throw new RuntimeException("未找到对应棋盘");
        }
        for(Long cla:classesIds){
            Optional<Classes> classes = classesRepository.findById(cla);
            if(classes.isEmpty()){
                throw new RuntimeException("id 为 "+ cla +" 的班级未找到");
            }
            if (classBoardRepository.exists(Example.of(new ClassBoard(null,chessBoard.get(),classes.get())))){
                throw new RuntimeException("已经添加过该残局");
            }
            list.add(new ClassBoard(null,chessBoard.get(),classes.get()));
        }
        classBoardRepository.saveAll(list);
        return ResponseEntity.ok("添加成功");
    }

    //添加学生至班级
    public ResponseEntity<String> saveClassStudent(Long classesId,Long studentId){
        Optional<Classes> classes = classesRepository.findById(classesId);
        Optional<User> student = userRepository.findById(studentId);
        if(classes.isEmpty()){
            throw new RuntimeException("未找到对应班级");
        }
        if(student.isEmpty()){
            throw new RuntimeException("未找到对应学生");
        }
        Classes nowClass = classesStudentRepository.findClassByStudentId(studentId);
        if(nowClass == null){
            classesStudentRepository.save(new ClassesStudent(null,classes.get(),student.get()));
            return ResponseEntity.ok("添加成功");
        }
        else {
            throw new RuntimeException("该学生已有班级");
        }
    }

    //根据班级查找学生
    public ResponseEntity<List<User>> findStudentsByClass(Long id){
        if(id == null){
            throw new RuntimeException("传入 id 为 null");
        }
        List<User> list = classesStudentRepository.findStudentByClassesId(id);
        if(list == null){
            throw new RuntimeException("未找到对应学生");
        }
        return ResponseEntity.ok(list);
    }

    //根据学生查找班级
    public ResponseEntity<Classes> findClassByStudent(Long id){
        if(id == null){
            throw new RuntimeException("传入 id 为 null");
        }
        Classes classes = classesStudentRepository.findClassByStudentId(id);
        if(classes == null){
            throw new RuntimeException("未找到对应班级");
        }
        return ResponseEntity.ok(classes);
    }

    //根据班级查找残局
    public ResponseEntity<List<ChessboardDTO>> findChessBoardsByClass(Long id, String role, Long studentId){
        if(id == null){
            throw new RuntimeException("传入 id 为 null");
        }
        List<ChessboardDTO> list;
        if ("student".equals(role)) {
            list = classBoardRepository.findChessBoardByClassesIdAndStudentId(id, studentId);
        } else {
            list = classBoardRepository.findChessBoardByClassesId(id);
        }
        if(list == null){
            throw new RuntimeException("未找到对应残局");
        }
        return ResponseEntity.ok(list);
    }

    //根据残局查找班级
    public ResponseEntity<List<Classes>> findClassByChessBoard(Long id){
        if(id == null){
            throw new RuntimeException("传入 id 为 null");
        }
        List<Classes> list = classBoardRepository.findClassesByChessBoardId(id);
        if(list == null){
            throw new RuntimeException("未找到对应班级");
        }
        return ResponseEntity.ok(list);
    }

    //根据教师查找班级
    public ResponseEntity<List<Classes>> findClassesByTeacher(Long id){
        if(id == null){
            throw new RuntimeException("传入 id 为 null");
        }
        List<Classes> list = teacherClassesRepository.findClassesByTeacherId(id);
        if(list == null){
            throw new RuntimeException("未找到对应班级");
        }
        return ResponseEntity.ok(list);
    }


    //根据班级查找教师
    public ResponseEntity<User> findTeacherByClass(Long id){
        if(id == null){
            throw new RuntimeException("传入 id 为 null");
        }
        User teacher = teacherClassesRepository.findTeacherByClass(id);
        if(teacher == null){
            throw new RuntimeException("未找到对应教师");
        }
        return ResponseEntity.ok(teacher);
    }

}
