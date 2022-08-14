package com.rubypaper.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.rubypaper.domain.Board;


public interface BoardRepository extends CrudRepository<Board, Long>, QuerydslPredicateExecutor<Board> {
	@Query("SELECT b FROM Board b") //글 목록 검색하는 메소드
	Page<Board> getBoardList(Pageable pageable); //Pageable 페이징처리를 위해 매개변수로 받음

}
