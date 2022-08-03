package com.rubypaper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
// Tomcat서버 이용 테스트는 properies 설정에 web-application-type이 servlet인지 항상 확인

import com.rubypaper.domain.BoardVO;

															 // MOCK:모킹된 서블릿 컨테이너 사용
															 // RANDOM_PORT: 랜덤한 포트로 내장 톰캣 구동, 서블릿 컨테이너 초기화, 정상적인 서블릿 테스트가능
															 // DEFINED_PORT: RANDOM_PORT동일하지만,application.properties 파일에 설정된 서버포트 사용
															 // NONE: 서블릿 기반 환경 자체를 구성 x
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) //내장톰캣 구동하고 정상적으로 서블릿컨테이너를 이용하겠다.
public class BoardControllerTest2_inTomketTest {
	
	// MockMvc 객체 대신 실제 컨트롤러를 실행해줄 TestRestTemplate 객체 생성
	@Autowired
	private TestRestTemplate restTemplate;
	

	@Test
	public void testHello() throws Exception{
		BoardVO board = restTemplate.getForObject("/getBoard", BoardVO.class);
		assertEquals("테스터", board.getWriter());
	}
}
