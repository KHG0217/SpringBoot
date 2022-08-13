package com.rubypaper.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity // 이클래스로부터 생성된 객체가 시큐리티 설정 파일임을 의미
//WebSecurityConfigurerAdapter 클래스를 상속한 시큐리티 설정 클래스가 빈으로 등록만 되어도
// 애플리케이션에서는 로그인을 강제하지 않는다.
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	//private DataSource dataSource;
	private BoardUserDetailsService boardUserDetailsService;
	
	//비밀번호 암호화
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	// configure() 메소드는 HttpSecurity 객체를 매개변수로 받는다.
	@Override
	protected void configure(HttpSecurity security) throws Exception{
		/*
		 * HttpSecurity 제공하는 메소드
		 * authorizeRequests = 사용자인증과 권한을 설정
		 * 			- anMatchers("URL패턴") - 매칭되는 url 패턴들에 대한 접근 허용
		 * 
		 * formLogin() - 로그인페이지 설정
		 * 			- loginPage("/login") - 로그인에 필요한 url로 접근하면 /login으로 이동
		 * 
		 * logout() - 로그아웃 페이지 설정
		 * 			- logoutUrl("/logout") - 로그아웃을 처리 페이징 설정
		 * 
		 * csrf() - csrf는 크로스 사이트 위조 요청에대한 설정
		 * 		  - disable() - RESTfull을 사용하기 위해서는 crrf 기능 비활성화
		 * 
		 * */
		security.authorizeRequests().antMatchers("/").permitAll();
		security.authorizeRequests().antMatchers("/member/**").authenticated();
		security.authorizeRequests().antMatchers("/manager/**").hasRole("MANAGER");
		security.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");
		
		security.csrf().disable();
		//security.formLogin(); // 기본시큐리티 로그인페이지 보여주기
		
		
		security.formLogin().loginPage("/login").defaultSuccessUrl("/loginSuccess",true);	
		// loginPage 로그인에 사용할 화면 지정 (/login 요청 리다이렉트)
		// defaultSuccessUrl 로그인 성공시 이동할 URL
		
		security.exceptionHandling().accessDeniedPage("/accessDenied"); 
		//권한이 없어서 페이지를 볼수 없을때 이동할 경로
		
		security.logout().invalidateHttpSession(true).deleteCookies().logoutSuccessUrl("/login");
		// 로그아웃 기능
		
		security.userDetailsService(boardUserDetailsService);

	}
	
//	@Autowired //AuthenticationManagerBuilder 객체를 의존성 주입받음
//	public void authenticate(AuthenticationManagerBuilder auth) throws Exception{
//		// inMemoryAuthentication: 메모리에 사용자 정보를 생성하는 메소드.
////		auth.inMemoryAuthentication().
////		withUser("manager").
////		password("{noop}manager123").
////		roles("MANAGER");
////		
////		auth.inMemoryAuthentication().
////		withUser("admin").
////		password("{noop}admin123").
////		roles("ADMIN");
//		
//		// 사용자가 입력한 아이디로 사용자 정보 조회
//		// "username","password" 변수에 각각 저장
//		// 칼럼명이 동일해야 자동으로 매핑됨
//		// {nope} : 암호화를 적용하지 않기위해
//		String query1 ="select id username, concat('{noop}', password)passwoard, true enabled from member where id=?";
//		
//		// 권한 조회
//		String query2 ="select id, role from member where id=?";
//		
//		auth.jdbcAuthentication()
//		.dataSource(dataSource)
//		.usersByUsernameQuery(query1) //인증
//		.authoritiesByUsernameQuery(query2); //권한
//	}
}
