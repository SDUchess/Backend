package com.example.chess.model.DTO;

import lombok.Data;

/**
 * 用来解析Excel的用户类
 */
@Data
public class UserExcel {
    private String username;
    private String password;
    private Integer role;
}
