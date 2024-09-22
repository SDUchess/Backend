package com.example.chess.repository;

import com.example.chess.model.DTO.StudentDTO;
import com.example.chess.model.StudentChess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface StudentChessRepository extends JpaRepository<StudentChess, Long> {

    // 根据学生id查找(找学生的做题记录)
    @Query(value = "select sc from StudentChess sc where sc.student.id = :studentId")
    List<StudentChess> findByStudentId(@Param("studentId") Long studentId);

    // 根据积分排序, 没有做题记录的分数为0
    /*@Query(value = "select student.*, coalesce(total, 0) totalScore " +
            "from (select * from users where role = 'student') student " +
            "         left join (select student_id, sum(c.score) total " +
            "                    from student_chess sc " +
            "                             join chessboards c on sc.chess_id = c.id " +
            "                    group by student_id) temp on student.id = student_id " +
            "order by total desc",
            nativeQuery = true)
    List<Object[]> rankByScoreNative();*/

    // JPQL
    @Query(value = "select new com.example.chess.model.DTO.StudentDTO(student, cast(coalesce(sum(c.score), 0) as long)) " +
            "from User student " +
            "         left join StudentChess sc on student.id = sc.student.id " +
            "         left join sc.chessBoard c " +
            "where student.role = 'student' " +
            "group by student.id " +
            "order by sum(c.score) desc")
    List<StudentDTO> rankByScore();

    @Transactional
    @Modifying
    @Query("delete from StudentChess where chessBoard.id = :boardId")
    void deleteByBoardId(Long boardId);

    @Transactional
    @Modifying
    @Query("delete from StudentChess where student.id = :studentId")
    void deleteByStudentId(Long studentId);
}
