package com.rubypaper.exception;

import java.sql.SQLException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // 모든예외를 여기 컨트롤러에서 처리
public class GlobalExceptionHandler {
	
	@ExceptionHandler(BoardException.class)
	public String handleCustomException(BoardException exception, Model model) {
		model.addAttribute("exception",exception);
		return"/errors/boardError";
	}
	
	@ExceptionHandler(Exception.class)
	public String handleException(Exception exception, Model model) {
		model.addAttribute("exception",exception);
		return"/errors/globalError";
	}
	
	@ExceptionHandler(SQLException.class)
	public String SQLException(SQLException exception, Model model) {
		model.addAttribute("exception",exception);
		return"/errors/SQLError";
	}
}
