package com.example.chess.repository;

import com.example.chess.model.ChessBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ChessBoardRepository extends JpaRepository<ChessBoard, Long> {

    @Query("SELECT cb FROM ChessBoard cb WHERE cb.publisher.id IN :teacherIds")
    List<ChessBoard> findByTeacherIds(@Param("teacherIds") List<Long> teacherIds);

    List<ChessBoard> findByPublisherId(Long publisherId);

    // 获取管理员题库
    @Query("FROM ChessBoard cb WHERE cb.publisher.role = 'admin' ")
    List<ChessBoard> findAllOfAdmin();

    // 获取教师题库
    @Query("FROM ChessBoard cb WHERE cb.publisher.role = 'teacher' ")
    List<ChessBoard> findAllOfTeacher();

    // 根据发布者id删除对应的所有题目
    @Transactional
    @Modifying
    @Query("delete from ChessBoard where publisher.id = :publisherId")
    void deleteByPublisherId(Long publisherId);
}

