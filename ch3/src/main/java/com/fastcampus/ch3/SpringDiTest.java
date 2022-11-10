//package com.fastcampus.ch3;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.GenericXmlApplicationContext;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//import java.util.Arrays;
//
//class Engine {}
//@Component class SuperEngine extends Engine {}
//@Component class TurboEngine extends Engine {}
//@Component class Door {}
//@Component class Car {
//    @Value("red") String color;
//    @Value("100") int oil;
////    @Autowired @Qualifier("superEngine") // byType
//    @Resource(name = "superEngine") // byName
//    Engine engine; // byType : 타입으로 먼저 검색, 여러개면 이름으로 검색
//
//    @Autowired Door[] doors;
//
//    // property 태그 사용하려면 setter가 꼭 있어야함
//    public void setColor(String color) {
//        this.color = color;
//    }
//
//    public void setOil(int oil) {
//        this.oil = oil;
//    }
//
//    public void setEngine(Engine engine) {
//        this.engine = engine;
//    }
//
//    public void setDoors(Door[] doors) {
//        this.doors = doors;
//    }
//    @Override
//    public String toString() {
//        return "Car{" +
//                "color='" + color + '\'' +
//                ", oil=" + oil +
//                ", engine=" + engine +
//                ", doors=" + Arrays.toString(doors) +
//                '}';
//    }
//}
//
//
//public class SpringDiTest {
//    public static void main(String[] args) {
//        ApplicationContext ac = new GenericXmlApplicationContext("config.xml");
//        // Car car = (Car) ac.getBean("car"); // byName. 아래와 같은 문장
//        Car car = ac.getBean("car", Car.class); // byName
////        Car car2 = (Car) ac.getBean(Car.class); // byType
////
////        Engine engine = (Engine) ac.getBean("engine"); // byName
//////        Engine engine = (Engine) ac.getBean("superEngine"); // byType : 같은 타입이 3개라서 에러 발생
////        Door door = (Door) ac.getBean("door");
////
////        // config.xml 파일에 property 태그로 입력
//////        car.setColor("red");
//////        car.setOil(100);
//////        car.setEngine(engine);
//////        car.setDoors(new Door[] {ac.getBean("door", Door.class), (Door)ac.getBean("door")});
//        System.out.println("car = " + car);
//
//
//    }
//}
