package com.renzituo.rental.car.domain.dto;

import lombok.Data;
import org.springframework.context.ApplicationEvent;
public class ExpiredOrder extends ApplicationEvent {
    public FrozeCar getFrozeCar() {
        return frozeCar;
    }

    public void setFrozeCar(FrozeCar frozeCar) {
        this.frozeCar = frozeCar;
    }

    private FrozeCar  frozeCar;

    public ExpiredOrder(Object source,FrozeCar  frozeCar) {
        super(source);
        this.frozeCar = frozeCar;
    }
}
