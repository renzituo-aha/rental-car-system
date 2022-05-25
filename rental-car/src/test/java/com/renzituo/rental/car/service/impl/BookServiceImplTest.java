package com.renzituo.rental.car.service.impl;

import com.renzituo.rental.car.domain.dto.CarInfo;
import com.renzituo.rental.car.domain.dto.OrderInfo;
import com.renzituo.rental.car.domain.enums.OrderStatusEnum;
import com.renzituo.rental.car.domain.request.BookOrderRequest;
import com.renzituo.rental.car.domain.request.CarDetailRequest;
import com.renzituo.rental.car.domain.request.CarListRequest;
import com.renzituo.rental.car.domain.request.PayRequest;
import com.renzituo.rental.car.domain.response.BaseResponse;
import com.renzituo.rental.car.repository.CarInfoRepository;
import com.renzituo.rental.car.repository.OrderInfoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookServiceImplTest {

    @Mock
    private CarInfoRepository mockCarInfoRepository;
    @Mock
    private OrderInfoRepository mockOrderInfoRepository;

    @InjectMocks
    private BookServiceImpl bookServiceImplUnderTest;

    @Test
    void testQueryCarList() {
        // Setup
        final CarListRequest carListRequest = new CarListRequest();
        carListRequest.setUserId(0L);
        carListRequest.setCarModel("carModel");

        when(mockCarInfoRepository.queryCarList()).thenReturn(Arrays.asList(CarInfo.builder().build()));

        // Run the test
        final BaseResponse result = bookServiceImplUnderTest.queryCarList(carListRequest);

        // Verify the results
    }

    @Test
    void testQueryCarList_CarInfoRepositoryReturnsNoItems() {
        // Setup
        final CarListRequest carListRequest = new CarListRequest();
        carListRequest.setUserId(0L);
        carListRequest.setCarModel("carModel");

        when(mockCarInfoRepository.queryCarList()).thenReturn(Collections.emptyList());

        // Run the test
        final BaseResponse result = bookServiceImplUnderTest.queryCarList(carListRequest);

        // Verify the results
    }

    @Test
    void testQueryCarDetailById() {
        // Setup
        final CarDetailRequest carDetailRequest = new CarDetailRequest();
        carDetailRequest.setUserId(0L);
        carDetailRequest.setCarId(0L);

        when(mockCarInfoRepository.queryById(0L)).thenReturn(CarInfo.builder().build());

        // Run the test
        final BaseResponse result = bookServiceImplUnderTest.queryCarDetailById(carDetailRequest);

        // Verify the results
    }

    @Test
    void testBookOrder() {
        // Setup
        final BookOrderRequest bookOrderRequest = new BookOrderRequest();
        bookOrderRequest.setUserId(1L);
        bookOrderRequest.setCarId(2L);
        bookOrderRequest.setUseDays(3);
        bookOrderRequest.setRentalDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        bookOrderRequest.setReturnDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());

        when(mockCarInfoRepository.queryById(2L)).thenReturn(CarInfo.builder().stock(2).fee("100.0").build());
        when(mockCarInfoRepository.tryFrozen(bookOrderRequest)).thenReturn(CarInfo.builder().build());
        when(mockOrderInfoRepository.createOrder(OrderInfo.builder().build())).thenReturn(false);

        // Run the test
        final BaseResponse result = bookServiceImplUnderTest.bookOrder(bookOrderRequest);

        // Verify the results
        verify(mockCarInfoRepository).tryFrozen(bookOrderRequest);
    }

    @Test
    void testPayOrder() {
        // Setup
        final PayRequest payRequest = new PayRequest();
        payRequest.setUserId(1L);
        payRequest.setOrderId(2L);
        payRequest.setPrice("100.00");

        when(mockOrderInfoRepository.getById(1L, 2L)).thenReturn(OrderInfo.builder().totalFee("100.00").carId(1L).userId(1L).orderId(2L).build());
        when(mockCarInfoRepository.confirmFrozen(1L, 1L)).thenReturn(false);
        when(mockOrderInfoRepository.updateStatus(1L, 2L, OrderStatusEnum.HAS_PAY)).thenReturn(false);

        // Run the test
        final BaseResponse result = bookServiceImplUnderTest.payOrder(payRequest);

        // Verify the results
        verify(mockCarInfoRepository).confirmFrozen(1L, 1L);
        verify(mockOrderInfoRepository).updateStatus(1L, 2L, OrderStatusEnum.HAS_PAY);
    }

    @Test
    void testCancelOrder() {
        // Setup
        final PayRequest payRequest = new PayRequest();
        payRequest.setUserId(1L);
        payRequest.setOrderId(2L);
        payRequest.setPrice("100.00");

        when(mockOrderInfoRepository.getById(1L, 2L)).thenReturn(OrderInfo.builder().userId(1L).carId(1L).orderId(2L).build());

        when(mockCarInfoRepository.rollbackFrozen(1L, 1L)).thenReturn(false);
        when(mockOrderInfoRepository.updateStatus(1L, 2L, OrderStatusEnum.CANCEL)).thenReturn(false);

        // Run the test
        final BaseResponse result = bookServiceImplUnderTest.cancelOrder(payRequest);

        // Verify the results
        verify(mockCarInfoRepository).rollbackFrozen(1L, 1L);
        verify(mockOrderInfoRepository).updateStatus(1L, 2L, OrderStatusEnum.CANCEL);
    }
}
