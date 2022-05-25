package com.renzituo.rental.car.service.event;

import com.renzituo.rental.car.domain.dto.ExpiredOrder;
import com.renzituo.rental.car.domain.enums.OrderStatusEnum;
import com.renzituo.rental.car.repository.OrderInfoRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class OrderExpiredEventListener implements ApplicationListener<ExpiredOrder> {
    @Resource
    private OrderInfoRepository orderInfoRepository;

    @Override
    public void onApplicationEvent(ExpiredOrder event) {
        orderInfoRepository.updateStatus(event.getFrozeCar().getUserId(),event.getFrozeCar().getOrderId(), OrderStatusEnum.EXPIRED);
    }
}
