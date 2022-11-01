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
	@GetMapping("/register/add") // 신규회원 가입 화면
	public String register() {
		return "registerForm"; // WEB-INF/views/registerForm.jsp
	}
	
//	@RequestMapping(value="/register/save", method=RequestMethod.POST)
	@PostMapping("/register/save") // 4.3부터
	public String save(@Valid User user, BindingResult result, Model m) throws Exception {
		System.out.println("result=" + result);
		System.out.println("user=" + user);
//		// 수동 검증
//		UserValidator userValidator = new UserValidator();
//		userValidator.validate(user, result); //BindingResult는 Error의 자손
		
		if(result.hasErrors()) {
			return "registerFrom";
		}
		
//		// 1. 유효성 검사	
//		if(!isVaild(user)) {
//			String msg = URLEncoder.encode("id를 잘못입력하셨습니다.", "utf-8");
//			
//			m.addAttribute("msg", msg);
//			return "redirect:/register/add";
////			return "redirect:/register/add?msg="+msg; // URL 재작성(rewriting)
//		}
		
		// 2. DB에 신규회원 정보를 저장
		return "registerInfo";
	}

	private boolean isVaild(User user) {
		return true;
	}
}
