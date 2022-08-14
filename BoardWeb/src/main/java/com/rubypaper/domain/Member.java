package com.rubypaper.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(exclude = "boardList") //순환참조 문제 boardList 제외
@Entity
public class Member {
@Id
@Column(name="MEMBER_ID")
private String id;

private String password;

private String name;

@Enumerated(EnumType.STRING) //권한정보
private Role role;

private boolean enabled;

//1:다 매핑 mappedBy:주인이 아님을 명시, Member 가 조회될 때 Board 목록도 같이 조회 fetch = FetchType.EAGER :즉시로딩
@OneToMany(mappedBy = "member", fetch = FetchType.EAGER) 
private List<Board> boardList = new ArrayList<Board>();
}
