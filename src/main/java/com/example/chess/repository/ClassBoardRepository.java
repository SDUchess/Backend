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
    @Query(value = "select cb.chessBoard from ClassBoard cb where cb.classes.id = :classId")
    List<ChessBoard> findChessBoardByClassesId(Long classId);

    //根据残局查找班级
    @Query(value = "select cb.classes from ClassBoard cb where cb.chessBoard.id = :boardId")
    List<Classes> findClassesByChessBoardId(Long boardId);

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
