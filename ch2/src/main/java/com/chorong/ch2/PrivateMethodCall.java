package com.chorong.ch2;

import java.lang.reflect.Method;

public class PrivateMethodCall {
	public static void main(String[] args) throws Exception{
//		Hello hello = new Hello();
//		hello.main(); //private�̶� �ܺ� ȣ�� �Ұ�
		
		// Reflection API�� ��� - Ŭ���� ������ ��� �ٷ� �� �ִ� ������ ��� ����
		// java.lang.reflect ��Ű���� ����
		
		//Hello Ŭ������ Class��ü(Ŭ������ ������ ��� �ִ� ��ü)�� ���´�
			// Ŭ���� ����(.class)�� �޸𸮿� �ö� ��, ������ ���� ���� Class ��ü�� �ϳ��� �����ȴ�.
		Class helloClass = Class.forName("com.chorong.ch2.Hello");
		Hello hello = (Hello)helloClass.newInstance(); // Class��ü�� ���� ������ ��ü�� ����
		Method main = helloClass.getDeclaredMethod("main"); // Class�� ������ �ִ� ���� �޼��带 �ܺο��� ȣ���� �� �ְ� ����
		main.setAccessible(true); // private�� main()�� ȣ�� �����ϰ� �Ѵ�.
		
		main.invoke(hello); // hello.main()
	}
}
