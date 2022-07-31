package com.rubypaper.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rubypaper.domain.BoardVO;

// 데이터 자체를 클라이언트로 전달하는 용도
// 데이터는 대부분 문자열,VO나 컬렉션 형태의 자바 객체( 이 경우는 자동으로 JSON으로 변환하여 처리)
@RestController
public class BoardController {
	public BoardController() {
		System.out.println("BoardController 생성자 호출");
	}
	
	@GetMapping("/hello")
	public String hello(String name) {
		return " Hello : " + name; 
		//Rest컨트롤러로 작성시 리턴되는 문자열이 브라우저에 그대로 출력 (View 화면 만들필요x)
	}
	
	@GetMapping("/getBoard")
	public BoardVO getBoard() {
		BoardVO board = new BoardVO();
		board.setSeq(1);
		board.setTitle("테스트제목..");
		board.setWriter("테스터");
		board.setContent("테스트 내용입니다.");
		board.setCreateDate(new Date());
		board.setCnt(0);
		return board;
	}
}
