package com.rubypaper.domain;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;



/**
 * Entity implementation class for Entity: Board
 *
 */

@Entity // 설정된 클래스를 엔티티라 하며, 기본적으로 클래스 이름과 동일한 테이블과 매핑된다.
@Table(name = "BOARD") //엔티티 이름과 매핑될 테이블이 다른경우 name속성을 이용해서 매핑한다. 동일하다면 생략가능
/*//테이블전략
//이렇게 만들어진 테이블을 생성기를 참조하기 위해서 BOARD_SEQ_GENERATOR 로 설정
@TableGenerator(name ="BOARD_SEQ_GENERATOR", 
				table ="ALL_SEQUENCES", // ALL_SEQUENCES 키생성 테이블 만듬
				pkColumnValue = "BOARD_SEQ", //BOARD_SEQ 이름으로 증가되는 값 저장
				initialValue = 0, // BOARD_SEQ 처음시작번호 0
				allocationSize = 1)// 1씩 증가

*/

/*
//시퀸스 전략
@SequenceGenerator(name = "BOARD_SEQ_GENERATOR",
					sequenceName = "BOARD_SEQUENCE",
					initialValue = 1,
					allocationSize = 1)
*/

public class Board2 {

	@Id //테이블의 기본키 매핑, 필수 어노테이션 (여기선 seq칼럼과 매핑되도록 설정)
	// 자동 전략
	@GeneratedValue // id가 선언된 필드의 기본 키르 값을 자동으로 할당(h2는 시퀸스로처리)
	
	/*
	// 테이블 전략
	// GenerationType.TABLE - 하이버네이트가 테이블을 사용하여 PK값 생성(생성만을 위한 별도 테이블 필요)
	@GeneratedValue(strategy = GenerationType.TABLE,
				generator = "BOARD_SEQ_GENERATOR" // BOARD_SEQ_GENERATOR 테이블 참조
			)
	*/
	
	/*
	// 시퀸스 전략
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
			generator = "BOARD_SEQ_GENERATOR"
			)
	*/
	private Long seq;
	private String title;
	private String writer;
	private String content;
	private Date createDate;
	private Long cnt;
	public Long getSeq() {
		return seq;
	}
	public void setSeq(Long seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Long getCnt() {
		return cnt;
	}
	public void setCnt(Long cnt) {
		this.cnt = cnt;
	}
   @Override
   public String toString() {
	return "Board [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content + ", createDate="
			+ createDate + ", cnt=" + cnt + "]";
}
   
}
