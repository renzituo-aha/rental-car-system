package com.renzituo.rental.car.common.util;

import java.math.BigDecimal;

public class FeeCalculateUtil {
    public static String calculateFee(String fee, int count) {
        return new BigDecimal(fee).multiply(new BigDecimal(count)).toString();
    }
}
