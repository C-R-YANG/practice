package com.chorong.ch2;

import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller 
public class RegisterController {
//	@RequestMapping("/register/add")
	@GetMapping("/register/add") // �ű�ȸ�� ���� ȭ��
	public String register() {
		return "registerForm"; // WEB-INF/views/registerForm.jsp
	}
	
//	@RequestMapping(value="/register/save", method=RequestMethod.POST)
	@PostMapping("/register/save") // 4.3����
	public String save(User user, Model m) throws Exception {
		// 1. ��ȿ�� �˻�
		
		if(!isVaild(user)) {
			String msg = URLEncoder.encode("id�� �߸��Է��ϼ̽��ϴ�.", "utf-8");
			
			m.addAttribute("msg", msg);
			return "redirect:/register/add";
//			return "redirect:/register/add?msg="+msg; // URL ���ۼ�(rewriting)
		}
		// 2. DB�� �ű�ȸ�� ������ ����
		return "registerInfo";
	}

	private boolean isVaild(User user) {
		return true;
	}
}
