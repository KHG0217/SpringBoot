package com.rubypaper;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.rubypaper.domain.Board2;

public class JPAClient {
	public static void main(String[] args) {
		/*
		// 데이터 추가
		
		// EntityManager 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		EntityManager em = emf.createEntityManager();
		// Transaction 생성
		
		// 트랜잭션(Transaction 이하 트랜잭션)이란, 
		// 데이터베이스의 상태를 변화시키기 해서 수행하는 작업의 단위를 뜻한다.
		
		EntityTransaction tx = em.getTransaction();
		try {
			// Transaction 시작
			tx.begin();
			
			Board2 board =new Board2();
			board.setTitle("JPA 제목");
			board.setWriter("관리자");
			board.setContent("JAP등록성공!");
			board.setCreateDate(new Date());
			board.setCnt(0L);
			
			//글 등록
			em.persist(board);
			
			// Transaction commit
			tx.commit();
		}catch (Exception e) {
			e.printStackTrace();
			
			// Transaction rollback
			tx.rollback();
		}finally {
			em.close();
			emf.close();
		}
		*/
		// 데이터 조회
		
		
		// EntityManager 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		EntityManager em = emf.createEntityManager();

		try {
			// 글 상세조회
			
			Board2 searchBoard = em.find(Board2.class, 1L);
			System.out.println("---->" + searchBoard.toString());
			

		}catch (Exception e) {
			e.printStackTrace();

		}finally {
			em.close();
			emf.close();
		}
	}
}

