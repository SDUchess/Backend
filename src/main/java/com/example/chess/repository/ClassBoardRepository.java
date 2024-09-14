package com.example.chess.repository;

import com.example.chess.model.ChessBoard;
import com.example.chess.model.ClassBoard;
import com.example.chess.model.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

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

    //删除班级与残局的关联（通过班级id)
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM class_board cb WHERE cb.class_id = :id",
            nativeQuery = true)
    void deleteClassBoardByClassesId(@Param("id") Long id);

    //删除班级与残局的关联（通过残局id)
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM class_board cb WHERE cb.board_id = :id",
            nativeQuery = true)
    void deleteClassBoardByBoardId(@Param("id") Long id);

    //删除班级与残局的关联（通过班级id和残局id)
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM class_board cb WHERE cb.class_id = :classId AND cb.board_id = :boardId",
            nativeQuery = true)
    void deleteClassBoardByBoardIdAndClassId(@Param("classId") Long classId,@Param("boardId") Long boardId);

}
