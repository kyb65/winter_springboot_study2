package io.github.kyb65.board.service;


import io.github.kyb65.board.dto.BoardDTO;
import io.github.kyb65.board.entity.BoardEntity;
import io.github.kyb65.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
