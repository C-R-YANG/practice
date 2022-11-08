package com.fastcampus.ch3;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

class Car {}
class Engine {}
class Door {}


public class SpringDiTest {
    public static void main(String[] args) {
        ApplicationContext ac = new GenericXmlApplicationContext("config.xml");
        Car car = (Car) ac.getBean("car");
        Engine engine = (Engine) ac.getBean("engine");


    }
}
