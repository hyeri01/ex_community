package com.ex_community.repository;

import com.ex_community.model.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    List<Board> findByTitle(String title);
    List<Board> findByTitleOrContent(String title, String Content);


    Page<Board> findByTitleContainingOrContentContaining(String title, String Content, Pageable pageable);

}
