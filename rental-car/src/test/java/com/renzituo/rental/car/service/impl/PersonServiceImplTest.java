package com.renzituo.rental.car.service.impl;

import com.renzituo.rental.car.domain.dto.CarInfo;
import com.renzituo.rental.car.domain.dto.OrderInfo;
import com.renzituo.rental.car.domain.request.BaseRequest;
import com.renzituo.rental.car.domain.request.OrderRequest;
import com.renzituo.rental.car.domain.request.ReturnCarRequest;
import com.renzituo.rental.car.domain.response.BaseResponse;
import com.renzituo.rental.car.repository.CarInfoRepository;
import com.renzituo.rental.car.repository.OrderInfoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersonServiceImplTest {

    @Mock
    private OrderInfoRepository mockOrderInfoRepository;
    @Mock
    private CarInfoRepository mockCarInfoRepository;

    @InjectMocks
    private PersonServiceImpl personServiceImplUnderTest;

    @Test
    void testOrderList() {
        // Setup
        final BaseRequest request = new BaseRequest();
        request.setUserId(0L);
        request.setPageSize(0L);
        request.setPageIndex(0L);

        // Configure OrderInfoRepository.getOrderList(...).
        final List<OrderInfo> orderInfos = Arrays.asList(OrderInfo.builder().build());
        when(mockOrderInfoRepository.getOrderList(0L)).thenReturn(orderInfos);

        // Run the test
        final BaseResponse result = personServiceImplUnderTest.orderList(request);

        // Verify the results
    }

    @Test
    void testOrderList_OrderInfoRepositoryReturnsNoItems() {
        // Setup
        final BaseRequest request = new BaseRequest();
        request.setUserId(0L);
        request.setPageSize(0L);
        request.setPageIndex(0L);

        when(mockOrderInfoRepository.getOrderList(0L)).thenReturn(Collections.emptyList());

        // Run the test
        final BaseResponse result = personServiceImplUnderTest.orderList(request);

        // Verify the results
    }

    @Test
    void testOrderDetail() {
        // Setup
        final OrderRequest request = new OrderRequest();
        request.setUserId(0L);
        request.setOrderId(0L);

        when(mockOrderInfoRepository.getById(0L, 0L)).thenReturn(OrderInfo.builder().build());

        // Run the test
        final BaseResponse result = personServiceImplUnderTest.orderDetail(request);

        // Verify the results
    }

    @Test
    void testReturnCar() {
        // Setup
        final ReturnCarRequest request = new ReturnCarRequest();
        request.setUserId(0L);
        request.setOrderId(0L);

        when(mockOrderInfoRepository.getById(0L, 0L)).thenReturn(OrderInfo.builder().carId(0L).build());
        when(mockCarInfoRepository.queryById(0L)).thenReturn(CarInfo.builder().stock(1).build());
        // when(mockCarInfoRepository.updateRepository(CarInfo.builder().build())).thenReturn(false);

        // Run the test
        final BaseResponse result = personServiceImplUnderTest.returnCar(request);

        // Verify the results
        // verify(mockCarInfoRepository).updateRepository(CarInfo.builder().build());
    }
}
