package com.rubypaper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.rubypaper.domain.Member;
import com.rubypaper.service.MemberService;

@SessionAttributes("member") // 세션에 상태 정보를 저장할 때 사용하는 어노테이션
//						Model 객체는 member라는 이름으로 저장된 데이터를 자동으로 세션에 저장한다
@Controller
public class LoginController {
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/login")
	public void loginView() {
		
	}
	
	@PostMapping("/login")
	public String login(Member member, Model model) {
		Member findMember = memberService.getMember(member);
		
		if(findMember != null && findMember.getPassword().equals(member.getPassword())) {
			model.addAttribute("member",findMember);
			return "forward:getBoardList";
		}else {
			return "redirect:login";
		}
		
	}
	
	@GetMapping("/logout")
	public String logout(SessionStatus status) {
		status.setComplete(); // 세션을 장제로 종료하는 메소드
		return "redirect:";
	}
}
