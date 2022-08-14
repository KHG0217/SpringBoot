package com.rubypaper.service;

import org.springframework.data.domain.Page;

import com.rubypaper.domain.Board;
import com.rubypaper.domain.Search;

public interface BoardService {

	void insertBoard(Board board);

	void updateBoard(Board board);

	void deleteBoard(Board board);

	Board getBoard(Board board);

	Page<Board> getBoardList(Search search);

}