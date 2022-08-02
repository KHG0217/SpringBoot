package com.rubypaper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import com.rubypaper.jdbc.util.JDBCConnectionManager;

// ApplicationRunner 를 구현했기 때문에
// JDBCConnectionManagerRunner 객체가 생성되자마자 컨테이너에 의해서
// run() 메소드가 자동으로 실행된다.
// 그후에는 자동설정이 동작하여 JDBCConnectionManager 객체가 메모리에 로딩된다.
@Service
public class JDBCConnectionManagerRunner implements ApplicationRunner {
	
	@Autowired
	private JDBCConnectionManager connectionManger;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("커넥션 매니저: " + connectionManger.toString());
		
	}

}
