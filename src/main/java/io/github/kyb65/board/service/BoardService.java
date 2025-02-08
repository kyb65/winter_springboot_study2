package io.github.kyb65.board.service;


import io.github.kyb65.board.dto.BoardDTO;
import io.github.kyb65.board.entity.BoardEntity;
import io.github.kyb65.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// dto -> entity (entity class)
// entity -> dto (dto class)
// 이런 변환 과정이 필요함.

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public void save(BoardDTO boardDTO) {
        BoardEntity boardEntity = BoardEntity.toSaveEntity(boardDTO);
        boardRepository.save(boardEntity);
    }


    public List<BoardDTO> findAll() {

        // entity 객체를 dto 객체로 옮겨담기.
        List<BoardEntity> boardEntityList = boardRepository.findAll();
        List<BoardDTO> boardDTOList = new ArrayList<>();
        for (BoardEntity boardEntity: boardEntityList) {
            boardDTOList.add(BoardDTO.toBoardDTO(boardEntity));
        }
        return boardDTOList;
    }
}
