package com.example.chess.repository;

import com.example.chess.model.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ClassesRepository extends JpaRepository<Classes,Long> {

    //新增班级
    //用的自带的

    //获取班级列表（分页）
    @Query(value = "SELECT c.* " +
            "FROM classes AS c " +
            "LIMIT :pageSize OFFSET :offset ",
            nativeQuery = true)
    List<Classes> findAllClasses(@Param("pageSize") int pageSize,@Param("offset") int offset);

    //获取班级列表条数
    @Query(value = "SELECT COUNT(*) " +
            "FROM classes AS c ",
            nativeQuery = true)
    Integer findAllClassesNumbers();

    //根据名称查找班级
    @Query(value = "SELECT c.* FROM classes c WHERE c.name = :name",nativeQuery = true)
    Optional<Classes> findByName(@Param("name") String name);

}
