package com.chorong.ch2;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// 년월일을 입력하면 요일을 알려주는 프로그램 
@Controller
public class YoilTellerMVC5 { // http://localhost:8080/ch2/getYoilMVC?year=2021&month=10&day=1
	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex) {
		ex.printStackTrace();
		return "yoilError";
	}
	// public static void main(String[] args) {
		@RequestMapping("/getYoilMVC5")
//		public String main(@ModelAttribute("myDate") Mydate date, Model model) throws IOException{
		public String main(@ModelAttribute Mydate date, Model model) throws IOException{

			// 1. 유효성 검사
			if(!isVaild(date))
				return "yoilError";
		
			// 2. 요일 계산
//			char yoil = getYoil(date);
		
			// 3. 계산한 결과를 모델에 저장
//			model.addAttribute("myDate", date);
//			model.addAttribute("yoil", yoil);
			
		return "yoil"; // //WEB-INF/views/yoil.jsp
		
	}

		private boolean isVaild(Mydate date) {
			return isVaild(date.getYear(), date.getMonth(), date.getDay());
		}
		
		private @ModelAttribute("yoil") char getYoil(Mydate date) {
			return getYoil(date.getYear(), date.getMonth(), date.getDay());
		}

		private char getYoil(int year, int month, int day) {
			Calendar cal = Calendar.getInstance();
			cal.set(year, month - 1, day);
			
			int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 1:일요일, 2:월요일 ...
			return "일월화수목금토".charAt(dayOfWeek);
		}

		private boolean isVaild(int year, int month, int day) {
			return true;
		}
}
