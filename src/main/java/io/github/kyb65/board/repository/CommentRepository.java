package io.github.kyb65.board.repository;

import io.github.kyb65.board.entity.BoardEntity;
import io.github.kyb65.board.entity.BoardFileEntity;
import io.github.kyb65.board.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    // select * from comment_table where board_id=?
    // order by id desc;

    List<CommentEntity> findAllByBoardEntityOrderByIdDesc(BoardEntity boardEntity);
}
