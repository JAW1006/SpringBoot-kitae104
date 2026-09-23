package com.mysite.sbb.common.annotation.main;


import com.mysite.sbb.common.annotation.code.CarMaker;
import com.mysite.sbb.common.annotation.code.OrderManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationMain {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("car-config.xml");
        OrderManager orderManager = context.getBean("orderManager", OrderManager.class);
        System.out.println("manager : " + orderManager);
        orderManager.order();
    }
}
