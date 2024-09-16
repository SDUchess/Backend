package com.example.chess.model.DTO;

import com.example.chess.model.ChessBoard;
import com.example.chess.model.Classes;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClassesBoardDTO {
    List<Long> classesIds;
    Long chessBoardId;
}
