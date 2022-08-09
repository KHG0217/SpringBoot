package com.rubypaper.persistence;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rubypaper.domain.Board;

//													   엔티티클래스,식별자 타입
public interface BoardRepository extends CrudRepository<Board, Long> {
	List<Board> findByTitle(String searchKeyword);
	List<Board> findByContentContaining(String searchKeyword);
	List<Board> findByTitleContainingOrContentContaining(String title, String content);
	List<Board> findByTitleContainingOrderBySeqDesc(String searchKeyword);
	// 페이징처리
	Page<Board> findByTitleContaining(String searchKeyword, Pageable paging);
	
	// 위치 기반 파라미터 :?1 이라하면 첫 번째 파라미터를 의미한다.
//	@Query("SELECT b FROM Board b WHERE b.title like %?1% ORDER BY b.seq DESC")
//	List<Board> queryAnnotatinTest1(String searchKeyword);
	
	// 이름 기반 파라미터 'searchKeyword'파라미터가 매개변수로 받은 searchKeyword값이 바인딩더ㅣㄴ다.
//	@Query("SELECT b FROM Board b "
//			+ "WHERE b.title like %:searchKeyword% "
//			+ "ORDER BY b.seq DESC")
//	List<Board> queryAnnotatinTest1(@Param("searchKeyword") String searchKeyword);
	
	// 특정 변수만 조회하기 : 특정값을 조회할땐 검색 결과로 여러 변수값을 조회하는것이다.
	// 그러므로 리턴타입을 Board로 할 수 없고 Object[] 해야한다.
//	@Query("SELECT b.seq, b.title, b.writer, b.createDate "
//			+ " FROM Board b "
//			+ "WHERE b.title like %?1% "
//			+ "ORDER BY b.seq DESC")
//	List<Object[]> queryAnnotatinTest2(@Param("searchKeyword") String searchKeyword);
	
	// 네이티브 쿼리 사용
//	@Query(value="select seq,title,writer,create_date "
//			+ "from board where title like '%'||?1||'%' "
//			+ "order by seq desc", nativeQuery = true)
//	List<Object[]> queryAnnotatinTest3(String searchKeyword);
	
	// 페이징 처리도 Query 메소드 사용 가능
//	@Query("SELECT b FROM Board b ORDER BY b.seq DESC")
//	List<Board> queryAnnotatinTest4(Pageable paging);
}
