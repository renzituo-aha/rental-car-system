package com.renzituo.rental.car.common.util;

import com.renzituo.rental.car.common.exception.RentalCarException;
import com.renzituo.rental.car.domain.enums.ResultCodeEnum;
import com.renzituo.rental.car.domain.request.BookOrderRequest;
import com.renzituo.rental.car.domain.request.PayRequest;

public class BookServiceParamCheckerUtil {
    public static void bookOrderParamChecker(BookOrderRequest req) {
        if (req == null || req.getUserId() == null || req.getCarId() == null || req.getUseDays() <= 0) {
            throw new RentalCarException(ResultCodeEnum.INVALID_PARAM);
        }
    }

    public static void payOrderParamChecker(PayRequest req) {
        if (req == null || req.getUserId() == null || req.getOrderId() == null || req.getPrice() == null) {
            throw new RentalCarException(ResultCodeEnum.INVALID_PARAM);
        }
    }
}
