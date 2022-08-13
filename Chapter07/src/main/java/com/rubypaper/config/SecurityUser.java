package com.rubypaper.config;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import com.rubypaper.domain.Member;

// User 클래스가  member 객체값을 리턴하도록 SecurityUserㅀ 상속받아 작성
public class SecurityUser extends User{
	
	private static final long serialVersionUID = 1L;
	
	public SecurityUser(Member member) {
		super(member.getId(), member.getPassword(),
				AuthorityUtils.createAuthorityList(member.getRole().toString()));

	}

}
