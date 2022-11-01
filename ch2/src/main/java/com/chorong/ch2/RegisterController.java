package com.chorong.ch2;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

@Controller 
public class RegisterController {
	@InitBinder
	public void toDate(WebDataBinder binder) {
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
		binder.registerCustomEditor(String[].class, new StringArrayPropertyEditor("#"));
		binder.setValidator(new UserValidator());
	}
//	@RequestMapping("/register/add")
	@GetMapping("/register/add") // �ű�ȸ�� ���� ȭ��
	public String register() {
		return "registerForm"; // WEB-INF/views/registerForm.jsp
	}
	
//	@RequestMapping(value="/register/save", method=RequestMethod.POST)
	@PostMapping("/register/save") // 4.3����
	public String save(@Valid User user, BindingResult result, Model m) throws Exception {
		System.out.println("result=" + result);
		System.out.println("user=" + user);
//		// ���� ����
//		UserValidator userValidator = new UserValidator();
//		userValidator.validate(user, result); //BindingResult�� Error�� �ڼ�
		
		if(result.hasErrors()) {
			return "registerFrom";
		}
		
//		// 1. ��ȿ�� �˻�	
//		if(!isVaild(user)) {
//			String msg = URLEncoder.encode("id�� �߸��Է��ϼ̽��ϴ�.", "utf-8");
//			
//			m.addAttribute("msg", msg);
//			return "redirect:/register/add";
////			return "redirect:/register/add?msg="+msg; // URL ���ۼ�(rewriting)
//		}
		
		// 2. DB�� �ű�ȸ�� ������ ����
		return "registerInfo";
	}

	private boolean isVaild(User user) {
		return true;
	}
}
