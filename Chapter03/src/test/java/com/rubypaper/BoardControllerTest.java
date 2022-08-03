package com.rubypaper;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

// @WebMvcTest 는 @Controller, @RestController가 설정된 클래스들을 찾아
// 메모리에 생성한다.
// 반면 @Service나 @Repository가 붙은 객체들은 테스트 대상이 아닌 것으로 
// 처리되기 때문에 생성 x

//@WebMvcTest 

// webEnvironment속성 = @SpringBootTest 에서 웹 어플리케이션 테스트를 지원
// 속성을 생략하면 디폴트 값 WebEnvironment.MOCK

// @AutoConfigureMockMvc 는 
// @Service나 @Repository가 붙은 객체들은 테스트 대상

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc //@SpringBootTest 모킹한 객체에 의존성 주입
public class BoardControllerTest {
	//서블릿 컨테이너를 모킹한것
	@Autowired
	private MockMvc mockMvc;
	
	
	/*
	  	testHello() 구조파악
	  	
	  	* perform() 메소드는 RequestBuilder 객체를 인자로 받음
	  	* RequestBuilder 객체는 MockMvcRequestBuilder의 정적 메소드를 이용해서 생성한다.
	  	* MockMvcRequestBuilder의 정적 메소드는 - GET, POST, PUT, DELETE 요청 방식과 매핑되는
	  									   - get(), post(), put(), delete() 메소드를 제공 
	  	 									 이 메소드들은 모두 MockMvcRequestBuilder 리턴함
	  	* MockMvcRequestBuilder 객체는 브라우저가 HTTP 요청 프로토콜에 요청 관련 정보(파라미터,쿠키 등등) 을 설정하듯 정보들을 설정할 수 있다.
	  	* ex) param() 메소드 - '키=값'의 파라미터를 여러개 전달할 수 있다.
	  	
	  	* perform() 메소드를 이용하여 요청을 전송 -> 결과 ResultActions 객체를 리턴
	  	* ResultActions는 응답 결과를 검증할 수 있는 andExpect() 메소드를 제공
	  	
	  	* andExpect() 가 요구하는 ResultMatcher는 MockMvcRequestMatcher에 정의된 정적 메소드를 통해 생성 가능
	  	
	  	* MockMvcRequestMatcher는 컨트롤러가 어떤 결과를 전송했는지 객체의 메소드를 이용하여 검증 가능
	  	* 
	  	* MockMvcRequestMatcher - status() 메소드는 StatusResultMatcher 객체를 리턴
	  							  StatusResultMatcher 객체는 응답 상태코드 검증 가능
	  							  isOk() : 응답상태코드 정상에 해당하는 200인지 확인
	   					          isNotFound() : 응답상태코드가 404(Not Found)인지 확인
	  	 						  isMethodNotAllowed() : 응답상태코드가 405(메소드 불일치)인지 확인
	  							  isInternalServerError() : 응탑상태코드가 500(예외)인지 확인
	  	 						  is(int status): 몇 번 응답상태 코드가 설정되었는지 확인한다 ex)is(200)
	  	 						  
	   * 그외 검증 메소드
	   * view() - 컨트롤러가 리턴하는 뷰를 검증할때 사용 ex) andExpect(view().name("hello")) = 코드는 컨트롤러가 리턴한 뷰 이름이 "hello"인지 검증
	   * redirectedUrl() - 요청 처리 결과라 리다일렉트 응답인지 검증할때 사용
	   * attributeExists(String name) - name에 해당하는 데이터가 Model에 포함되어 있는지 검증
	   * attribute(String name, Object value) - name에 해당하는 데이터가 value 객체인지 검증 
	    
	   
	    
	   
	   * andDo() - 실제로 생성된 요청과 응답 메시지를 모두 확인하고 싶을때 (perform() 메소드가 리턴하는 ResultAction객체의 메소드)
	 					
	 * */
	@Test
	public void testHello() throws Exception{
		// hello라는 url이 get 방식으로 {name=[둘리]} 를 파라미터로 가지고 감
		mockMvc.perform(get("/hello").param("name","둘리")) 
		 .andExpect(status().isOk()) // 위 요청에 따라 결과가 status는 200이며
		 .andExpect(content().string("Hello : 둘리"))
		.andDo(print());
	}
}
