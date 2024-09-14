package com.example.chess.repository;

import com.example.chess.model.ChessBoard;
import com.example.chess.model.ClassBoard;
import com.example.chess.model.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClassBoardRepository extends JpaRepository<ClassBoard,Long> {

    //根据班级查找残局
    @Query(value = "SELECT b.* " +
            "FROM chessboards AS b LEFT JOIN class_board AS cb ON b.id = cb.board_id " +
            "WHERE cb.class_id = :ClassId",
            nativeQuery = true)
    List<ChessBoard> findChessBoardByClassesId(@Param("ClassId") Long ClassId);

    //根据残局查找班级
    @Query(value = "SELECT c.* " +
            "FROM classes AS c LEFT JOIN class_board AS cb ON c.id = cb.class_id " +
            "WHERE cb.board_id = :id",
            nativeQuery = true)
    List<Classes> findClassesByChessBoardId(@Param("id") Long id);


}
