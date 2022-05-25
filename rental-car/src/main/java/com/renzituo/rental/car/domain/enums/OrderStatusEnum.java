package com.renzituo.rental.car.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OrderStatusEnum {
    INIT(0,"NOT_PAY"),
    HAS_PAY(1,"USING"),
    RETURNED(2,"COMPLETE"),
    CANCEL(3,"CANCEL"),

    EXPIRED(4,"PAY_TIME_OUT"),

    DELETE(4,"DELETE");
    private Integer code;
    private String desc;

    public static OrderStatusEnum getByCode(Integer code)
    {
        for(OrderStatusEnum statusEnum:OrderStatusEnum.values())
        {
            if(statusEnum.getCode().equals(code))
            {
                return statusEnum;
            }
        }

        return null;
    }
}
