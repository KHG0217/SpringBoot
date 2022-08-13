package com.rubypaper.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rubypaper.domain.Member;
import com.rubypaper.persistence.MemberRepository;
/*
 * 인증 관리 필터가 사용자가 입력한 정보를 토대로 기능을 처리하기 위해서는
 * 사용자 정보가 저장된 UserDatails 객체가 필요
 * UserDetailsService - UserDetails 객체에 실제 데이터베이스에서 검색한
 * 					    사용자 정보를 저장하는 객체
 * 
 * 이 객체를 기본적으로 제공한다. UserDetails 기본값은 아이디가 user이고 비밀번호는
 * 암호화 되어 콘솔체 출력되는 긴 문자열이다
 * 
 * 이 클래스는 UserDetailsService 커스터마이징 한 클래스
 */
@Service
public class BoardUserDetailsService implements UserDetailsService {
	
	@Autowired
	private MemberRepository memberRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		//MemberRepository로 회원 정보를 조회하여
		// UserDetails 타입의 객체로 리턴한다.
		
		/*
		 * java8에서는 Optional<T> 클래스를 사용해 
		 * NPE를 방지할 수 있도록 도와준다. 
		 * Optional<T>는 null이 올 수 있는 값을 감싸는 Wrapper 클래스로, 
		 * 참조하더라도 NPE가 발생하지 않도록 도와준다

		 */
		Optional<Member> optional = memberRepo.findById(username);
		if(!optional.isPresent()) {
			throw new UsernameNotFoundException(username+ "사용자 없음");
		} else {
			Member member =optional.get();
			return new SecurityUser(member);
		}
		
	}

}
