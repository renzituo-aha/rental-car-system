package com.renzituo.rental.car.service.impl;

import com.renzituo.rental.car.common.exception.RentalCarException;
import com.renzituo.rental.car.common.util.BookServiceParamCheckerUtil;
import com.renzituo.rental.car.common.util.FeeCalculateUtil;
import com.renzituo.rental.car.common.util.IdGen;
import com.renzituo.rental.car.domain.dto.CarInfo;
import com.renzituo.rental.car.domain.dto.OrderInfo;
import com.renzituo.rental.car.domain.enums.OrderStatusEnum;
import com.renzituo.rental.car.domain.enums.ResultCodeEnum;
import com.renzituo.rental.car.domain.request.BookOrderRequest;
import com.renzituo.rental.car.domain.request.CarDetailRequest;
import com.renzituo.rental.car.domain.request.CarListRequest;
import com.renzituo.rental.car.domain.request.PayRequest;
import com.renzituo.rental.car.domain.response.BaseResponse;
import com.renzituo.rental.car.domain.response.CarListResponse;
import com.renzituo.rental.car.repository.CarInfoRepository;
import com.renzituo.rental.car.repository.OrderInfoRepository;
import com.renzituo.rental.car.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class BookServiceImpl implements BookService {
    @Resource
    private CarInfoRepository carInfoRepository;

    @Resource
    private OrderInfoRepository orderInfoRepository;

    @Override
    public BaseResponse queryCarList(CarListRequest carListRequest) {
        List<CarInfo> carInfos = carInfoRepository.queryCarList();
        CarListResponse car = new CarListResponse();

        if (CollectionUtils.isEmpty(carInfos)) {
            return BaseResponse.normalSuccess(car);
        }

        car.setTotalCount(carInfos.size());
        car.setCarList(carInfos);
        return BaseResponse.normalSuccess(car);
    }

    @Override
    public BaseResponse queryCarDetailById(CarDetailRequest carDetailRequest) {
        CarInfo carInfo = carInfoRepository.queryById(carDetailRequest.getCarId());

        return BaseResponse.normalSuccess(carInfo);
    }

    @Override
    public  BaseResponse bookOrder(BookOrderRequest bookOrderRequest) {
        // param checker
        BookServiceParamCheckerUtil.bookOrderParamChecker(bookOrderRequest);

        // stock verify
        CarInfo carInfo = carInfoRepository.queryById(bookOrderRequest.getCarId());
        if (carInfo == null || carInfo.getStock() <= 0) {
            throw new RentalCarException(ResultCodeEnum.STOCK_NOT_ENOUGH);
        }

        // create order
        OrderInfo orderInfo = OrderInfo.builder()
                .orderId(IdGen.genId())
                .carId(carInfo.getCarId())
                .carModel(carInfo.getCarModel())
                .userId(bookOrderRequest.getUserId())
                .orderStatus(OrderStatusEnum.INIT.getCode())
                .statusDesc(OrderStatusEnum.INIT.getDesc())
                .useDays(1)
                .bookTime(new Date())
                .rentalDate(new Date())
                .totalFee(FeeCalculateUtil.calculateFee(carInfo.getFee(), bookOrderRequest.getUseDays()))
                .returnDate(bookOrderRequest.getReturnDate()).build();

        try {
            bookOrderRequest.setOrderId(orderInfo.getOrderId());

            // froze car
            carInfoRepository.tryFrozen(bookOrderRequest);

            orderInfoRepository.createOrder(orderInfo);
        } catch (Exception e) {
            log.error("book order error!", e);
            return BaseResponse.genByException(new RentalCarException(ResultCodeEnum.SYSTEM_ERROR));
        }

        return BaseResponse.normalSuccess(orderInfo);
    }

    @Override
    public BaseResponse payOrder(PayRequest payRequest) {
        // param checker
        BookServiceParamCheckerUtil.payOrderParamChecker(payRequest);

        // checker the fee
        OrderInfo order = orderInfoRepository.getById(payRequest.getUserId(), payRequest.getOrderId());
        if (order == null || !order.getTotalFee().equals(payRequest.getPrice())) {
            throw new RentalCarException(ResultCodeEnum.NOT_EXISTS_ORDER);
        }

        if(!order.getOrderStatus().equals(OrderStatusEnum.INIT.getCode()))
        {
            throw new RentalCarException(ResultCodeEnum.INVALID_ORDER_STATUS);
        }


        // confirm the froze car
        carInfoRepository.confirmFrozen(order.getUserId(), order.getOrderId());

        // update order status 2 PAY
        orderInfoRepository.updateStatus(order.getUserId(), order.getOrderId(), OrderStatusEnum.HAS_PAY);

        return BaseResponse.normalSuccess(null);
    }

    @Override
    public BaseResponse cancelOrder(PayRequest payRequest) {
        // param checker
        BookServiceParamCheckerUtil.payOrderParamChecker(payRequest);


        // checker the fee
        OrderInfo order = orderInfoRepository.getById(payRequest.getUserId(), payRequest.getOrderId());
        if (order == null) {
            throw new RentalCarException(ResultCodeEnum.NOT_EXISTS_ORDER);
        }

        // confirm the froze car
        carInfoRepository.rollbackFrozen(order.getUserId(), order.getOrderId());

        // update order status 2 PAY
        orderInfoRepository.updateStatus(order.getUserId(), order.getOrderId(), OrderStatusEnum.CANCEL);

        return BaseResponse.normalSuccess(null);
    }
}
