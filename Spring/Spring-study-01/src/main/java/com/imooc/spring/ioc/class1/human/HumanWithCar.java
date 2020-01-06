package com.imooc.spring.ioc.class1.human;

import com.imooc.spring.ioc.class1.car.Car;

public abstract class HumanWithCar implements Human {
    protected Car car;

    public HumanWithCar(Car car) {
        this.car = car;
    }

    @Override
    public abstract void goHome();
}
