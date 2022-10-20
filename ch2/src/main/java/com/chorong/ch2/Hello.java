package com.chorong.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 1. ���� ȣ�� ������ ���α׷����� ��� (Ŭ���� ����)
@Controller
public class Hello {
	int iv = 10; // �ν��Ͻ� ����
	static int cv = 20; // static ����
	
	// 2. URL�� �޼��� ���� (���� �޼��� ����)
	@RequestMapping("/hello")
	// static �޼��尡 �ƴѵ� ��� ȣ��� �� ������ ? - ��Ĺ ���ο��� ��ü�� �������ֱ� ����
	// ���� ������ ��� ���� �ܺ� ȣ���� ������ - ���ο����� private
	private void main() { // �ν��Ͻ� �޼��� - iv, cv �� �� ��� ����
		System.out.println("Hello - private");
		System.out.println(cv); // OK
//		System.out.println(iv); // OK
	}
	
	public static void main2() { // static �޼��� - cv�� ��� ���� (�ν��Ͻ� ��� ��� �Ұ�)
		System.out.println(cv); // OK
//		System.out.println(iv); // ����
	}
}
