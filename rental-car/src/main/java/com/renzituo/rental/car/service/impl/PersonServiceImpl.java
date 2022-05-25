package com.renzituo.rental.car.service.impl;

import com.renzituo.rental.car.domain.dto.CarInfo;
import com.renzituo.rental.car.domain.dto.OrderInfo;
import com.renzituo.rental.car.domain.enums.OrderStatusEnum;
import com.renzituo.rental.car.domain.request.BaseRequest;
import com.renzituo.rental.car.domain.request.OrderRequest;
import com.renzituo.rental.car.domain.request.ReturnCarRequest;
import com.renzituo.rental.car.domain.response.BaseResponse;
import com.renzituo.rental.car.domain.response.OrderListResponse;
import com.renzituo.rental.car.repository.CarInfoRepository;
import com.renzituo.rental.car.repository.OrderInfoRepository;
import com.renzituo.rental.car.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class PersonServiceImpl implements PersonService {

    @Resource
    private OrderInfoRepository orderInfoRepository;

    @Resource
    private CarInfoRepository carInfoRepository;

    @Override
    public BaseResponse orderList(BaseRequest request) {
        List<OrderInfo> orderInfos = orderInfoRepository.getOrderList(request.getUserId());
        OrderListResponse orderListResponse = new OrderListResponse();
        if (!CollectionUtils.isEmpty(orderInfos)) {
            orderListResponse.setTotalCount(orderInfos.size());
        } else {
            orderListResponse.setTotalCount(0);
        }

        orderListResponse.setOrderList(orderInfos);

        return BaseResponse.normalSuccess(orderListResponse);
    }

    @Override
    public BaseResponse orderDetail(OrderRequest request) {
        OrderInfo orderInfo = orderInfoRepository.getById(request.getUserId(), request.getOrderId());

        return BaseResponse.normalSuccess(orderInfo);
    }

    @Override
    public BaseResponse returnCar(ReturnCarRequest request) {
        // get order info by order id
        OrderInfo orderInfo = orderInfoRepository.getById(request.getUserId(), request.getOrderId());

        // get car info
        CarInfo carInfo = carInfoRepository.queryById(orderInfo.getCarId());

        // add stock -- not atomic,todo
        carInfo.setStock(carInfo.getStock() + 1);
        carInfoRepository.updateRepository(carInfo);

        // update status
        orderInfoRepository.updateStatus(request.getUserId(),request.getOrderId(), OrderStatusEnum.RETURNED);

        return BaseResponse.normalSuccess(null);
    }
}
