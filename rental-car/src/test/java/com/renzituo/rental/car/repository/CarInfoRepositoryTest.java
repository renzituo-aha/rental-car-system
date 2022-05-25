package com.renzituo.rental.car.repository;

import com.renzituo.rental.car.domain.dto.CarInfo;
import com.renzituo.rental.car.domain.request.BookOrderRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarInfoRepositoryTest {

    private CarInfoRepository carInfoRepositoryUnderTest;

    @BeforeEach
    void setUp() {
        carInfoRepositoryUnderTest = new CarInfoRepository();
    }

    @Test
    void testQueryCarList() {
        // Setup
        final List<CarInfo> expectedResult = Arrays.asList(CarInfo.builder().build());

        // Run the test
        final List<CarInfo> result = carInfoRepositoryUnderTest.queryCarList();

    }

    @Test
    void testQueryById() {
        // Setup
        final CarInfo expectedResult = CarInfo.builder().build();

        // Run the test
        final CarInfo result = carInfoRepositoryUnderTest.queryById(0L);
    }

    @Test
    void testConfirmFrozen() {
        // Setup
        // Run the test
        //final boolean result = carInfoRepositoryUnderTest.confirmFrozen(0L, 0L);

        // Verify the results
        //assertThat(result).isTrue();
    }

    @Test
    void testRollbackFrozen() {
        // Setup
        // Run the test
        final boolean result = carInfoRepositoryUnderTest.rollbackFrozen(0L, 0L);

        // Verify the results
        assertThat(result).isTrue();
    }

    @Test
    void testUpdateRepository() {
        // Setup
        final CarInfo carInfo = CarInfo.builder().carId(10L).fee("100.00").stock(2).build();

        // Run the test
        final boolean result = carInfoRepositoryUnderTest.updateRepository(carInfo);

        // Verify the results
        assertThat(result).isTrue();
    }

    @Test
    void testTryFrozen() {
        // Setup
        final BookOrderRequest request = new BookOrderRequest();
        request.setUserId(0L);
        request.setCarId(0L);
        request.setUseDays(0);
        request.setRentalDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        request.setReturnDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());

        final CarInfo expectedResult = CarInfo.builder().build();

        // Run the test
       // final CarInfo result = carInfoRepositoryUnderTest.tryFrozen(request);

        // Verify the results
        //assertThat(result).isEqualTo(expectedResult);
    }
}
