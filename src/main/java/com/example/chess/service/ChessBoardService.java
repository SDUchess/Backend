package com.example.chess.service;

import com.example.chess.model.*;
import com.example.chess.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<ChessboardDTO> getAllChessboardsWithMoveCount() {
        List<ChessBoard> chessboards = chessBoardRepository.findAll();
        return chessboards.stream().map(chessboard -> {
            int moveCount = chessMoveRepository.countByChessboardId(chessboard.getId());
            return new ChessboardDTO(chessboard, moveCount);
        }).collect(Collectors.toList());
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteChessboard(Long id) {
        deleteChessMovesByChessboardId(id);
        classBoardRepository.deleteClassBoardByBoardId(id);
        chessBoardRepository.deleteById(id);
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
    public ResponseEntity<List<ChessBoard>> getAllChessBoardsOfAdmin(Long adminId){
        Optional<User> optionalUser = userRepository.findById(adminId);
        if(optionalUser.isEmpty()){
            throw new RuntimeException("未找到该管理员");
        }
        if (!Objects.equals(optionalUser.get().getRole(), "admin")){
            throw new RuntimeException("该 id 不是管理员的id");
        }
        List<ChessBoard> list = chessBoardRepository.findAllOfAdmin(adminId);
        return ResponseEntity.ok(list);
    }
}
