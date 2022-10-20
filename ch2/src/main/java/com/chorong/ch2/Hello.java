package com.chorong.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 1. 원격 호출 가능한 프로그램으로 등록 (클래스 위에)
@Controller
public class Hello {
	int iv = 10; // 인스턴스 변수
	static int cv = 20; // static 변수
	
	// 2. URL과 메서드 연결 (메인 메서드 위에)
	@RequestMapping("/hello")
	// static 메서드가 아닌데 어떻게 호출될 수 있을까 ? - 톰캣 내부에서 객체를 생성해주기 때문
	// 접근 제한자 상관 없이 외부 호출이 가능함 - 내부에서는 private
	private void main() { // 인스턴스 메서드 - iv, cv 둘 다 사용 가능
		System.out.println("Hello - private");
		System.out.println(cv); // OK
//		System.out.println(iv); // OK
	}
	
	public static void main2() { // static 메서드 - cv만 사용 가능 (인스턴스 멤버 사용 불가)
		System.out.println(cv); // OK
//		System.out.println(iv); // 에러
	}
}
