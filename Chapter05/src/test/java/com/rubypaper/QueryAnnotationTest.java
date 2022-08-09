package com.rubypaper;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.rubypaper.domain.Board;
import com.rubypaper.persistence.BoardRepository;

@SpringBootTest
public class QueryAnnotationTest {
	@Autowired
	private BoardRepository boardRepo;

//	@Test
//	public void testQueryAnnotationTest1() {
//		List<Board> boardList = boardRepo.queryAnnotatinTest1("테스트 제목 10");
//		
//		System.out.println("검색결과");
//		for(Board board : boardList) {
//			System.out.println("--->" + board.toString());
//		}
//	}
	
//	@Test
//	public void testQueryAnnotationTest2() {
//		List<Object[]> boardList = boardRepo.queryAnnotatinTest2("테스트 제목 10");
//		
//		System.out.println("검색결과");
//		for(Object[] row : boardList) {
//			System.out.println("--->" + Arrays.toString(row));
//			// --->[310, 테스트 제목 109, KHG, 2022-08-09 19:36:14.675]
//			// Board 엔티티를 통째로 조회한것이 아닌 Board 엔티티의 각 변수값만 조회함
//		}
//	}
	
//	@Test
//	public void testQueryAnnotationTest3() {
//		List<Object[]> boardList = boardRepo.queryAnnotatinTest3("테스트 제목 10");
//		
//		System.out.println("검색결과");
//		for(Object[] row : boardList) {
//			System.out.println("--->" + Arrays.toString(row));
//			// --->[310, 테스트 제목 109, KHG, 2022-08-09 19:36:14.675]
//			// Board 엔티티를 통째로 조회한것이 아닌 Board 엔티티의 각 변수값만 조회함
//		}
//	}
	
//	@Test
//	public void testQueryAnnotationTest4() {
//		// Sort.Direction.DESC,"seq" 로 seq에 대해 내림차순 정렬
//		Pageable paging = PageRequest.of(0,3,Sort.Direction.DESC,"seq");
//		List<Board> boardList = boardRepo.queryAnnotatinTest4(paging);
//		
//		System.out.println("검색결과");
//		for(Board board : boardList) {
//			System.out.println("--->" + board.toString());
//
//		}
//	}
}
