package com.rubypaper;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.rubypaper.domain.Board;
import com.rubypaper.persistence.BoardRepository;

@SpringBootTest
public class QueryMethodTest {
	@Autowired
	private BoardRepository boardRepo;
	
//	@BeforeEach // Juit 4 : Before -> Juit5 :BeforeEach
//	public void dataPrepare() {
//		for(int i =1 ; i<=200; i++) {
//			Board board = new Board();
//			board.setTitle("테스트 제목 " + i);
//			board.setContent("테스트 내용 " + i);
//			board.setWriter("KHG");
//			board.setCreateDate(new Date());
//			board.setCnt(0L);
//			boardRepo.save(board);
//		}
//	}
//	
//	@Test
//	public void testFindByTitle() {
//		List<Board> boardList = boardRepo.findByTitle("테스트 제목 10");
//		
//		System.out.println("검색 결과");
//		for(Board board: boardList) {
//			System.out.println("----> " + board.toString());
//		}
//	}
	
//	// Content에 17이 들어간  Content 찾기
//	@Test
//	public void testByContentContaining() {
//		List<Board> boardList = boardRepo.findByContentContaining("17");
//		
//		System.out.println("검색결과");
//		for(Board board: boardList) {
//			System.out.println("---->" + board.toString());
//		}
//	}
	
//	@Test
//	public void testFindBytitleOrContentContaining() {
//		List<Board> boardList = boardRepo.findByTitleContainingOrContentContaining("1", "17");
//		
//		System.out.println("검색 결과");
//		for(Board board: boardList) {
//			System.out.println("---->" + board.toString());
//		}
//	}
	
//	@Test
//	public void testFindByTitleOrderBySeqDesc() {
//		List<Board> boardList = boardRepo.findByTitleContainingOrderBySeqDesc("17");
//		
//		System.out.println("검색 결과");
//		for(Board board : boardList) {
//			System.out.println("---->" + boardList.toString());
//		}
//	}
	
	@Test
	public void testFindByTitleContaining() {
		// 1번부터(인자가0부터시작),5개씩 검색
		Pageable paging = PageRequest.of(0, 5, Sort.Direction.DESC,"seq"); 
		Page<Board> pageInfo = boardRepo.findByTitleContaining("제목", paging);
		// 한페이지 크기
		System.out.println("PAGE SIZE : " + pageInfo.getSize());
		// 전체 페이지의 수
		System.out.println("TOTAL PAGES : " + pageInfo.getTotalPages());
		// 결과 데이터 수
		System.out.println("TOTAL COUNT : "  + pageInfo.getTotalElements());
		// 다음 페이지 객체
		System.out.println("NEXT : " + pageInfo.nextPageable());
		
		List<Board> boardList = pageInfo.getContent();
		System.out.println("검색 결과");
		for(Board board : boardList) {
			System.out.println("---->" + board.toString());
		}
	}
}
