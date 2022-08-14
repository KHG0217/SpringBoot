package com.rubypaper.domain;

import java.util.Date;

import javax.persistence.Column;
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




@Setter
@Getter
@ToString(exclude = "member") //순환참조문제 해결
@Entity
public class Board {
	@Id
	@GeneratedValue
	private Long seq;
	
	private String title;
	private String content;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false)
	private Date createDate = new Date();
	
	@Column(updatable = false)
	private Long cnt = 0L;
	//@ManyToOne: 다대:1 관계 매핑,@JoinColumn(name="MEMBER_ID": 칼럼을 통해 외래키 관리,
	//nullable = false:내부조인 (성능향상)
	@ManyToOne
	@JoinColumn(name="MEMBER_ID", nullable = false, updatable = false)
	private Member member;
	
	public void SetMember(Member member) {
		this.member = member;
		member.getBoardList().add(this);
	}
	
	
}
