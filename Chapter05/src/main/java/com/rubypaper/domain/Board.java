package com.rubypaper.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = "member") //두 객체간에 상호호출 고리를 끊는 작업
@Entity
public class Board {
	@Id @GeneratedValue
	private Long seq;
	private String title;
	//private String writer;
	private String content;
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date createDate;
	private Long cnt;
	
	//다대일 연관 매핑설정
	
	/*
	 * @ManyToOne 어노테이션 속성
	 * optional - 연관된 엔티티가 반드시 있어야 하는지 여부 설정 (기본:true)(외부조인)
	 * 			- false면 항상 있어야 한다는 의미(내부조인)
	 * 
	 * fetch - 글로벌 페치 전략 설정 
	 * 		   EAGER는 연관 엔티티를 동시에 조회
	 * 		   LAZY는 연관 엔터티를 실제 사용할때 조회
	 * 
	 * cascade - 영속성 전이 기능 설정, 연관 엔티티를 같이 저장하거나 삭제할때 사용
	 * 	
	 * */
	@ManyToOne // 다대일(N:1) 관계를 설정하기위한 어노테이션
	@JoinColumn(name="MEMBER_ID", nullable = false) //외래키(FK) 매핑을 위한 어노테이션
	private Member member;
	
	// 회원이 소유한 게시글 컬렉션에 게시글(자신)도 자동으로 저장할 수있게 setMember 메소드 추가
	public void setMember(Member member) {
		this.member = member;
		member.getBoardList().add(this);
	}

}
