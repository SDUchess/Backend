package com.example.chess.service;

import com.example.chess.model.ChessBoard;
import com.example.chess.model.ChessMove;
import com.example.chess.model.ChessboardDTO;
import com.example.chess.model.TeacherStudent;
import com.example.chess.repository.ChessBoardRepository;
import com.example.chess.repository.ChessMoveRepository;
import com.example.chess.repository.TeacherStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChessBoardService {

    @Autowired
    private ChessBoardRepository chessBoardRepository;

    @Autowired
    private ChessMoveRepository chessMoveRepository;

    @Autowired
    private TeacherStudentRepository teacherStudentRepository;

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
                .map(teacher -> teacher.getId())
                .collect(Collectors.toList());
        return chessBoardRepository.findByTeacherIds(teacherIds);
    }
}
