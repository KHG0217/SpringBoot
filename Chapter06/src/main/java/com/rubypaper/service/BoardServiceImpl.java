package com.rubypaper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubypaper.domain.Board;
import com.rubypaper.persistence.BoardRepository;

// <Alt> + <Shift> +<T> 누르고 Extract Interface... 누르면 serivce 인터페이스 완성
@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardRepository boardRepo;
	
	@Override
	public List<Board> getBoardList(Board board){
		return (List<Board>) boardRepo.findAll();
	}
	
	@Override
	public void insertBoard (Board board) {
		boardRepo.save(board);
	}
	
	@Override
	public Board getBoard(Board board) {
		return boardRepo.findById(board.getSeq()).get();
	}
	
	@Override
	public void updateBoard (Board board) {
		Board findBoard = boardRepo.findById(board.getSeq()).get();
		
		findBoard.setTitle(board.getTitle());
		findBoard.setContent(board.getContent());
		boardRepo.save(findBoard);
	}
	
	@Override
	public void deleteBoard (Board board) {
		boardRepo.deleteById(board.getSeq());
	}
}
