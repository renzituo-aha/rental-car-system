package com.renzituo.rental.car.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResultCodeEnum {

    SUCCESS(0,"success"),
    INVALID_PARAM(1001,"invalid params"),
    STOCK_NOT_ENOUGH(1002,"car stock not enough"),
    EXPIRED_PAY(1003,"the order has expired"),

    NOT_EXISTS_ORDER(1003,"the order not exists"),

    INVALID_ORDER_STATUS(1004,"invalid order status"),



    SYSTEM_ERROR(9999,"system error");

    private int code;
    private String desc;
}
