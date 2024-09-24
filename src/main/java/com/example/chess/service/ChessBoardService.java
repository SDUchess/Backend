package com.example.chess.service;

import com.example.chess.model.*;
import com.example.chess.model.DTO.StudentDTO;
import com.example.chess.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ChessBoardService {

    @Autowired
    private ChessBoardRepository chessBoardRepository;

    @Autowired
    private ChessMoveRepository chessMoveRepository;

    @Autowired
    private TeacherStudentRepository teacherStudentRepository;

    @Autowired
    private ClassBoardRepository classBoardRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StudentChessRepository studentChessRepository;

    public ChessBoard saveChessBoard(ChessBoard chessBoard) {
        return chessBoardRepository.save(chessBoard);
    }

    public List<ChessMove> saveChessMoves(List<ChessMove> chessMoves) {
        return chessMoveRepository.saveAll(chessMoves);
    }


    public ChessBoard getChessBoardById(Long id) {
        return chessBoardRepository.findById(id).orElse(null);
    }

    public List<ChessMove> getMovesByChessBoardId(Long id) {
        return chessMoveRepository.findByChessboardIdOrderByMoveOrderAsc(id);
    }

    //根据教师id查找残局
    public ResponseEntity<List<ChessBoard>> getChessBoardByTeacherId(Long teacherId){
        if(teacherId == null){
            throw new RuntimeException("传入 id 为空值");
        }
        return ResponseEntity.ok(chessBoardRepository.findByPublisherId(teacherId));
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteChessboard(Long id) {
        deleteChessMovesByChessboardId(id);
        // 删除残局和班级的关联
        classBoardRepository.deleteClassBoardByBoardId(id);
        // 删除残局和学生的关联(学生的做题记录)
        studentChessRepository.deleteByBoardId(id);
        chessBoardRepository.deleteById(id);
    }

    // 根据教师id删除其所有残局
    @Transactional(rollbackFor = Exception.class)
    public void deleteChessboardsByTeacherId(Long teacherId) {
        List<ChessBoard> chessboards = chessBoardRepository.findByPublisherId(teacherId);
        for (ChessBoard chessboard : chessboards) {
            deleteChessboard(chessboard.getId());
        }
    }

    public void deleteChessMovesByChessboardId(Long chessboardId) {
        List<ChessMove> moves = chessMoveRepository.findByChessboardIdOrderByMoveOrderAsc(chessboardId);
        chessMoveRepository.deleteAll(moves);
    }

    public List<ChessBoard> getChessboardsForStudent(Long studentId) {
        List<TeacherStudent> teacherStudentList = teacherStudentRepository.findByStudentId(studentId);
        List<Long> teacherIds = teacherStudentList.stream()
                .map(TeacherStudent::getTeacher)
                .map(User::getId)
                .collect(Collectors.toList());
        return chessBoardRepository.findByTeacherIds(teacherIds);
    }

    //获取管理员题库
    public ResponseEntity<List<ChessboardDTO>> getAllBasicChessBoards(String role, Long studentId) {
        List<ChessboardDTO> list;
        if ("student".equals(role)) {
            list = chessBoardRepository.findAllBasicByStudentId(studentId);
        } else {
            list = chessBoardRepository.findAllBasic();
        }
        return ResponseEntity.ok(list);
    }

    // 学生完成挑战
    public ResponseEntity<String> finishChessboard(StudentChess studentChess) {
        // 重复完成题目不会继续增加积分
        if (!studentChessRepository.exists(Example.of(studentChess))) {
            studentChessRepository.save(studentChess);
        }
        return ResponseEntity.ok("ok");
    }

    // 获取积分排行榜
    public List<StudentDTO> rankByScore() {
        return studentChessRepository.rankByScore();
    }
}
