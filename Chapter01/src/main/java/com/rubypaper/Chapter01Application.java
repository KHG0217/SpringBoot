package com.rubypaper;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
// 스프링 부트로 만든 애플리케이션의 시작 클래스임을 알림
// 현재 메인메소드가 든 com.runbypaper 는 자동으로 컴포넌트 스캔이 되어 빈으로 등록된다.
// 다른이름의 패키지에는 빈으로 등록되지 않는다.

@SpringBootApplication
// 다른 패키지명을 추가하기 위해선 @ComponentScan 을 사용한다.
// 이때 @ComponentScan을 사용하면 원래 자동으로 등로되었던 "com.rubypaper" 도 추가해줘야한다.
@ComponentScan(basePackages = {"com.rubypaper","test.a"})
public class Chapter01Application {

	public static void main(String[] args) {
		// 웹 애플리케이션으로 실행
		//SpringApplication 객체의 run()메소드를 정적 메소드 호출방식으로 호출
		//SpringApplication.run(Chapter01Application.class, args);
		
		// 자바 애플리케이션으로 실행
		SpringApplication application = new SpringApplication(Chapter01Application.class);
		//WebApplicationType.SERVLET - 웹 애플리케이션으로 실행하기
		// * REACTIVE - 비동기처리와 논블로킹 입출력 지원하는 웹플럭스 적용시 사용
		application.setWebApplicationType(WebApplicationType.NONE);
		
		
		//배너 OFF
		application.setBannerMode(Banner.Mode.OFF);
		
		//사용자 배너 : src/main/resources/banner.txt
		
		application.run(args);
	}

}
