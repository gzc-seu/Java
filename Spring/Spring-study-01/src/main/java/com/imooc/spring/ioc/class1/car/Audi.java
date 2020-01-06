package com.imooc.spring.ioc.class1.car;

public class Audi implements Car {
    @Override
    public void start() {
        System.out.println("Audi.start");
    }

    @Override
    public void turnLeft() {
        System.out.println("Audi.turnLeft");
    }

    @Override
    public void turnRight() {
        System.out.println("Audi.turnright");
    }

    @Override
    public void stop() {
        System.out.println("Audi.stop");
    }
}
