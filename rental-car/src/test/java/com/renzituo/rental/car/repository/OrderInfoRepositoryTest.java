package com.renzituo.rental.car.repository;

import com.renzituo.rental.car.domain.dto.OrderInfo;
import com.renzituo.rental.car.domain.enums.OrderStatusEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OrderInfoRepositoryTest {

    private OrderInfoRepository orderInfoRepositoryUnderTest;

    @BeforeEach
    void setUp() {
        orderInfoRepositoryUnderTest = new OrderInfoRepository();
    }

    @Test
    void testCreateOrder() {
        // Setup
        final OrderInfo orderInfo = OrderInfo.builder().orderId(10l).useDays(3).statusDesc("12").orderStatus(1).totalFee("300.00").userId(1L).carId(2L).carModel("Camry").build();

        // Run the test
        final boolean result = orderInfoRepositoryUnderTest.createOrder(orderInfo);

        // Verify the results
        assertThat(result).isTrue();
    }

    @Test
    void testGetById() {
        // Setup
        final OrderInfo orderInfo = OrderInfo.builder().orderId(10l).useDays(3).statusDesc("12").orderStatus(1).totalFee("300.00").userId(1L).carId(2L).carModel("Camry").build();


        // Run the test
        // final OrderInfo result = orderInfoRepositoryUnderTest.getById(1L, 10L);

        // Verify the results
        //assertThat(result).isEqualTo(orderInfo);
    }

    @Test
    void testGetOrderList() {
        // Setup
        final List<OrderInfo> expectedResult = Arrays.asList(OrderInfo.builder().build());

        // Run the test
        final List<OrderInfo> result = orderInfoRepositoryUnderTest.getOrderList(0L);

        // Verify the results
//        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testUpdateStatus() {
        // Setup
        // Run the test
       // final boolean result = orderInfoRepositoryUnderTest.updateStatus(0L, 0L, OrderStatusEnum.INIT);

        // Verify the results
       //  assertThat(result).isTrue();
    }
}
