package com.renzituo.rental.car.repository;

import com.google.common.collect.Lists;
import com.renzituo.rental.car.common.exception.RentalCarException;
import com.renzituo.rental.car.common.util.IdGen;
import com.renzituo.rental.car.domain.dto.CarInfo;
import com.renzituo.rental.car.domain.dto.OrderInfo;
import com.renzituo.rental.car.domain.enums.OrderStatusEnum;
import com.renzituo.rental.car.domain.enums.ResultCodeEnum;
import com.renzituo.rental.car.domain.request.BookOrderRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
@Slf4j
public class OrderInfoRepository {
    private HashMap<Long, List<OrderInfo>> ORDER_INFO_REPOSITORY = new HashMap<>();

    public boolean createOrder(OrderInfo orderInfo) {
        if (orderInfo == null || orderInfo.getUserId() == null) {
            log.warn("the request param invalid");
            throw new RentalCarException(ResultCodeEnum.INVALID_PARAM);
        }

        if (ORDER_INFO_REPOSITORY.containsKey(orderInfo.getUserId())) {
            List<OrderInfo> orderInfos = ORDER_INFO_REPOSITORY.get(orderInfo.getUserId());
            orderInfos.add(orderInfo);
        } else {
            List<OrderInfo> orderInfos = Lists.newArrayList(orderInfo);
            ORDER_INFO_REPOSITORY.put(orderInfo.getUserId(), orderInfos);
        }
        return true;
    }

    public OrderInfo getById(Long userId, Long orderId) {
        List<OrderInfo> orderInfos = ORDER_INFO_REPOSITORY.get(userId);
        if (orderInfos == null) {
            log.warn("【updateStatus】the order not exist！userId:{} orderId:{}");
            throw new RentalCarException(ResultCodeEnum.NOT_EXISTS_ORDER);
        }

        OrderInfo orderInfo = orderInfos.stream().filter(item -> item.getOrderId().equals(orderId)).findFirst().orElse(null);

        return orderInfo;
    }

    public List<OrderInfo> getOrderList(Long userId) {
        return ORDER_INFO_REPOSITORY.get(userId);
    }

    public boolean updateStatus(Long userId, Long orderId, OrderStatusEnum orderStatusEnum) {

        OrderInfo orderInfo = getById(userId, orderId);
        if (orderInfo == null) {
            log.warn("【updateStatus】the order not exist！userId:{} orderId:{}");
            throw new RentalCarException(ResultCodeEnum.NOT_EXISTS_ORDER);
        }

        orderInfo.setOrderStatus(orderStatusEnum.getCode());
        orderInfo.setStatusDesc(orderStatusEnum.getDesc());
        return true;
    }
}
