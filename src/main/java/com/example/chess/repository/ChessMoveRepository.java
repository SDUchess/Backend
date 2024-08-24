package com.example.chess.repository;

import com.example.chess.model.ChessMove;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChessMoveRepository extends JpaRepository<ChessMove, Long> {

    @Query("SELECT m FROM ChessMove m WHERE m.chessboardId = :chessboardId ORDER BY m.moveOrder ASC")
    List<ChessMove> findByChessboardIdOrderByMoveOrderAsc(@Param("chessboardId") Long chessboardId);

    int countByChessboardId(Long chessboardId);

    void deleteByChessboardId(Long chessboardId);

}
