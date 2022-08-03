package com.rubypaper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import com.rubypaper.controller.BoardController;

@SpringBootTest(classes = BoardController.class,
// properties 속성으로 재정의한 author.name,author.age 는
// 재정의한 값이 적용되었고 마지막으로 새롭게 추가한 author.nation 프로퍼티 출력
			properties = {
					"author.name = Gurum",
					"author.age = 45",
					"author.nation=Korea"
					
			}
		)
public class PropertiesTest {
	// application.properties에 추가한 프로퍼티들을 사용하기 위해 @Autowired
	@Autowired
	Environment environment;
	
	@Test
	public void testMethod() {
		// application.properties에 추가한 프로퍼티들을 사용
		System.out.println("이름 : " + environment.getProperty("author.name"));
		System.out.println("나이 : " + environment.getProperty("author.age"));
		System.out.println("국가 : " + environment.getProperty("author.nation"));
	}
}
