package com.example.chess.service;

import com.example.chess.model.ChessMove;
import com.example.chess.repository.ChessMoveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChessMoveService {
    @Autowired
    private ChessMoveRepository chessMoveRepository;

    public ChessMove saveChessMove(ChessMove chessMove) {
        return chessMoveRepository.save(chessMove);
    }

    public List<ChessMove> getMovesByChessboardId(Long chessboardId) {
        return chessMoveRepository.findByChessboardIdOrderByMoveOrderAsc(chessboardId);
    }
}
