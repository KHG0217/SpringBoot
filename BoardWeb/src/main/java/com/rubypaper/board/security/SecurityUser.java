package com.rubypaper.board.security;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import com.rubypaper.domain.Member;

public class SecurityUser extends User {
	private static final long serialVersionUID = 1L;
	private Member member;
	
	// 회원객체를 멤버 변수인 member에 추가로 할당하는 이유는 HTML에 뿌리기 위함
	public SecurityUser(Member member) {
		super(member.getId(), member.getPassword(),
		AuthorityUtils.createAuthorityList(member.getRole().toString()));
		this.member = member;
	}
	
	public Member getMember() {
		return member;
	}
}
