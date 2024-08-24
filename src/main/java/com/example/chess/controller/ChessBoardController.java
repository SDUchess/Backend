package com.example.chess.controller;

import com.example.chess.model.ChessBoard;
import com.example.chess.model.ChessMove;
import com.example.chess.model.ChessboardDTO;
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

    @GetMapping("/all")
    public List<ChessboardDTO> getAllChessboards() {
        return chessBoardService.getAllChessboardsWithMoveCount();
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
}
