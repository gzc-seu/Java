package com.imooc.spring.ioc.class1.human;

import com.imooc.spring.ioc.class1.car.Car;

public class lisi extends HumanWithCar {
    public lisi(Car car) {
        super(car);
    }

    @Override
    public void goHome() {
        car.start();
        car.turnRight();
        car.stop();
    }
}
