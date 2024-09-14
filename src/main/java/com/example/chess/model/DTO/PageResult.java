package com.example.chess.model.DTO;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
@Data
public class PageResult<T> {
    Integer recordNumber;
    List<T> list;
}
