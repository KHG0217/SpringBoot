package com.rubypaper.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = "boardList") //두 객체간에 상호호출 고리를 끊는 작업
@Entity
public class Member {
	@Id
	@Column(name="MEMBER_ID") 
	private String id;
	private String password;
	private String name;
	private String role;
	
	// 일대다 Board 엔티티를 여러개 저장할 수있도록 List타입
	// @OneToMany 일대다 매핑할때 사용
	// fetch 속성 = 회원정보를 조회할때 연관관계가 있는 게시판 정보도 같이 조회할것인지 결정
	//				EAGER: 같이조회함
	// mappedBy 속성 = 양방향관계에서 연관관계 주인이 아님을 알려주는 어노테이션
	// 연관관계 주인 = 왜래키 관리자
	// cascade = CascadeType.ALL : PK를 가지고있는 Memver가 부모 엔티티이며
	//							 : 게시판은 FK를 가지고있는 자식 엔티티로
	//							 : cascade속성으로 영속성 전이를 하고
	//							 : CascadeType.ALL 을 적용하여
	//							 : 객체가 영속화,수정,삭제될때 자식엔티티인 게시판도 같이 바뀜
	@OneToMany(mappedBy = "member",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Board> boardList = new ArrayList<Board>();
	

}
