package com.imooc.spring.ioc.class1.human;

import com.imooc.spring.ioc.class1.car.Car;

public class zhangsan extends HumanWithCar{
    public zhangsan(Car car) {
        super(car);
    }

    @Override
    public void goHome() {
        car.start();
        car.turnLeft();
        car.turnRight();
        car.stop();
    }
}
