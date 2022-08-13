package com.rubypaper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rubypaper.domain.Board;
import com.rubypaper.domain.Member;
import com.rubypaper.persistence.BoardRepository;
import com.rubypaper.persistence.MemberRepository;

@SpringBootTest
public class DataInitializeTest {

		@Autowired
		private MemberRepository memberRepo;
		
		@Autowired
		private BoardRepository boardRepo;
		
		@Test
		public void testDataInsert() {
			Member member1 = new Member();
			member1.setId("member1");
			member1.setName("김혁규");
			member1.setPassword("123");
			member1.setRole("ROLE_USER");
			memberRepo.save(member1);
			
			Member member2 = new Member();
			member2.setId("member2");
			member2.setName("김아무개");
			member2.setPassword("321");
			member2.setRole("ROLE_ADMIN");
			memberRepo.save(member2);
			
			for(int i =1; i <=3; i++) {
				Board board = new Board();
				board.setWriter("김혁규");
				board.setTitle("김혁규가 등록한 게시글 "+i);
				board.setContent("김혁규가 등록한 게시글 내용" + i);
				boardRepo.save(board);
			}
			
			for(int i =1; i <=3; i++) {
				Board board = new Board();
				board.setWriter("김아무개");
				board.setTitle("김아무개가 등록한 게시글 "+i);
				board.setContent("김아무개가 등록한 게시글 내용" + i);
				boardRepo.save(board);
			}
		}
}
