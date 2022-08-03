package com.rubypaper;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.rubypaper.service.BoardService;

															 // MOCK:모킹된 서블릿 컨테이너 사용
															 // RANDOM_PORT: 랜덤한 포트로 내장 톰캣 구동, 서블릿 컨테이너 초기화, 정상적인 서블릿 테스트가능
															 // DEFINED_PORT: RANDOM_PORT동일하지만,application.properties 파일에 설정된 서버포트 사용
															 // NONE: 서블릿 기반 환경 자체를 구성 x
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class BoardControllerTest3 {
	
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean // 툭정타입 객체를 모킹할 수 있기때문에 BoardServiceImpl을 생성하지 않고도 테스트 할 수 있다.
	private BoardService boardService;
	

	@Test
	public void testHello() throws Exception{
		when(boardService.hello("둘리")).thenReturn("Hello : 둘리");
		
		mockMvc.perform(get("/hello").param("name", "둘리"))
		.andExpect(status().isOk())
		.andExpect(content().string("Hello:둘리"))
		.andDo(print());
	}
}
