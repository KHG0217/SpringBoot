package com.rubypaper.domain;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 * Entity implementation class for Entity: Board
 *
 */
@Entity // 설정된 클래스를 엔티티라 하며, 기본적으로 클래스 이름과 동일한 테이블과 매핑된다.
@Table(name = "BOARD") //엔티티 이름과 매핑될 테이블이 다른경우 name속성을 이용해서 매핑한다. 동일하다면 생략가능
public class Board2 {

	@Id //테이블의 기본키 매핑, 필수 어노테이션 (여기선 seq칼럼과 매핑되도록 설정)
	@GeneratedValue // id가 선언된 필드의 기본 키르 값을 자동으로 할당(h2는 시퀸스로처리)
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
