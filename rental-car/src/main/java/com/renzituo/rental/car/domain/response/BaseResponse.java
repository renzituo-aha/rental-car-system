package com.renzituo.rental.car.domain.response;

import com.renzituo.rental.car.common.exception.RentalCarException;
import com.renzituo.rental.car.domain.enums.ResultCodeEnum;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class BaseResponse<T> implements Serializable {
    private int code;
    private String msg;
    private T data;

    public static BaseResponse genByException(RentalCarException r)
    {
        BaseResponse res = new BaseResponse();
        res.setCode(r.getCode());
        res.setMsg(r.getDesc());

        return res;
    }

    public static <T>BaseResponse normalSuccess(T t)
    {
        BaseResponse res = new BaseResponse();
        res.setCode(ResultCodeEnum.SUCCESS.getCode());
        res.setMsg(ResultCodeEnum.SUCCESS.getDesc());
        res.setData(t);
        return res;
    }
}
