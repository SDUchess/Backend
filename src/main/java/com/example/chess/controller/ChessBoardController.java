package com.example.chess.controller;

import com.example.chess.model.*;
import com.example.chess.model.DTO.StudentDTO;
import com.example.chess.service.ChessBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chessboard")
public class ChessBoardController {

    @Autowired
    private ChessBoardService chessBoardService;

    @PostMapping("/save")
    public ChessBoard saveChessBoard(@RequestBody ChessBoard chessBoard) {
        return chessBoardService.saveChessBoard(chessBoard);
    }

    @PostMapping("/moves/save")
    public List<ChessMove> saveChessMoves(@RequestBody List<ChessMove> chessMoves) {
        return chessBoardService.saveChessMoves(chessMoves);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChessBoard> getChessBoard(@PathVariable Long id) {
        ChessBoard chessBoard = chessBoardService.getChessBoardById(id);
        if (chessBoard != null) {
            return ResponseEntity.ok(chessBoard);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //根据教师id查找残局
    @GetMapping("/teacher/{id}")
    public ResponseEntity<List<ChessBoard>> getChessBoardByTeacherId(@PathVariable Long id){
        return chessBoardService.getChessBoardByTeacherId(id);
    }

    @GetMapping("/{id}/moves")
    public ResponseEntity<List<ChessMove>> getChessMoves(@PathVariable Long id) {
        List<ChessMove> moves = chessBoardService.getMovesByChessBoardId(id);
        return ResponseEntity.ok(moves);
    }

    @DeleteMapping("/{id}")
    public void deleteChessboard(@PathVariable Long id) {
        chessBoardService.deleteChessboard(id);
    }

    @GetMapping("/student/{studentId}")
    public List<ChessBoard> getChessboardsForStudent(@PathVariable Long studentId) {
        return chessBoardService.getChessboardsForStudent(studentId);
    }

    // 获取管理员题库
    @GetMapping("/basic/all")
    public ResponseEntity<List<ChessboardDTO>> getAllChessBasicBoards(@RequestParam String role, @RequestParam(required = false) Long studentId) {
        return chessBoardService.getAllBasicChessBoards(role, studentId);
    }

    // 学生完成题目
    @PostMapping("/finish")
    public ResponseEntity<String> finishChessboard(@RequestBody StudentChess studentChess) {
        return chessBoardService.finishChessboard(studentChess);
    }

    // 获取积分排行榜
    @GetMapping("/rank")
    public List<StudentDTO> rankByScore() {
        return chessBoardService.rankByScore();
    }
}
