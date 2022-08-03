package com.rubypaper.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rubypaper.domain.BoardVO;
import com.rubypaper.service.BoardService;

// 데이터 자체를 클라이언트로 전달하는 용도
// 데이터는 대부분 문자열,VO나 컬렉션 형태의 자바 객체( 이 경우는 자동으로 JSON으로 변환하여 처리)
@RestController
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/hello")
	public String hello(String name) {
		return boardService.hello(name);
		
	}
	
	@GetMapping("/getBoard")
	public BoardVO getBoard() {

		return boardService.getBoard();
	}
	
	@GetMapping("/getBoardList")
	public List<BoardVO> getBoardList(){

		
		return boardService.getBoardList();
	}
}
