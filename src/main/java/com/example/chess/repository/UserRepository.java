package com.example.chess.repository;

import com.example.chess.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    // 根据角色查找用户
    List<User> findByRole(String role);

    // 根据用户名和角色查找用户
    List<User> findByUsernameContainingAndRole(String username, String role);
}
