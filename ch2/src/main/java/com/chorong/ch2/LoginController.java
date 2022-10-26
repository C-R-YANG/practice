package com.chorong.ch2;

import java.net.URLEncoder;

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
	
	@PostMapping("/login")
	public String login(String id, String pwd, String rememberId) throws Exception {
		// 1. id�� pwd Ȯ��
		if(!loginCheck(id, pwd)) {
			// 2-1. ��ġ���� ������ loginFrom���� �̵�
			String msg = URLEncoder.encode("id �Ǵ� pwd�� ��ġ���� �ʽ��ϴ�.", "utf-8");
		
			return "redirect:/login/login?mag="+msg;
		}
		// 2-2. ��ġ�ϸ� Ȩ���� �̵�
		return "redirect:/";
	}

	private boolean loginCheck(String id, String pwd) {
		return "asdf".equals(id) && "1234".equals(pwd);
		
	}
}
