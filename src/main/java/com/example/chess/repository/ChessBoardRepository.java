package com.example.chess.repository;

import com.example.chess.model.ChessBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChessBoardRepository extends JpaRepository<ChessBoard, Long> {
    @Query("SELECT cb FROM ChessBoard cb WHERE cb.teacherId IN :teacherIds")
    List<ChessBoard> findByTeacherIds(@Param("teacherIds") List<Long> teacherIds);

    List<ChessBoard> findByTeacherId(Long teacherId);
    List<ChessBoard> findByTeacherIdIn(List<Long> teacherIds);
}

