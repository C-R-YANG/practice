package com.chorong.ch2;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
	@GetMapping("/login")
	public String loginForm() {
		return "loginForm";
	}
	@GetMapping("/logout ")
	public String logout(HttpSession session) {
		// 1. 세션 종료
		session.invalidate();
		// 2. 홈 이동
		return "redirect:/";
	}
	
	@PostMapping("/login")
	public String login(String id, String pwd, boolean rememberId, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 1. id와 pwd 확인
		if(!loginCheck(id, pwd)) {
			// 2-1. 일치하지 않으면 loginFrom으로 이동
			String msg = URLEncoder.encode("id 또는 pwd가 일치하지 않습니다.", "utf-8");
		
			return "redirect:/login/login?mag="+msg;
		}
		// 2-2. 일치하면
		// 세션 객체를 얻어오기
		HttpSession session = request.getSession();
		// 세션 객체에 id 저장
		session.setAttribute("id", id);
		
		if(rememberId) {
			// 쿠키 생성
			Cookie cookie = new Cookie("id", id);
			//      2. 응답에 저장
			response.addCookie(cookie);
		} else {
			// 쿠키 삭제
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(0);
			//      2. 응답에 저장
			response.addCookie(cookie);
		}
		
		return "redirect:/";
	}

	private boolean loginCheck(String id, String pwd) {
		return "asdf".equals(id) && "1234".equals(pwd);
		
	}
}
