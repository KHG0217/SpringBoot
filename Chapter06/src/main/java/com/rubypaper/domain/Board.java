package com.rubypaper.domain;





import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "BOARD")
public class Board {
	@Id@GeneratedValue
	private Long seq;
	
	private String title;
	
	@Column(updatable = false) //하이버네이트가 update sql을 제너레이션 할때 제외
	private String writer;
	
	private String content;
	
	// insertable 하이버네이트가 insert sql 할때 제외
	@Column(insertable = false, updatable = false, columnDefinition = "date default now()")
	private Date createDate;
	
	@Column(insertable = false, updatable = false, columnDefinition = "number default 0")
	private Long cnt;
}
