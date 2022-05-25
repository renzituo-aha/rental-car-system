package com.renzituo.rental.car.common.exception;

import com.renzituo.rental.car.domain.enums.ResultCodeEnum;


public class RentalCarException  extends  RuntimeException{
    private int code;
    private String desc;

    public RentalCarException(ResultCodeEnum resultCodeEnum)
    {
        super(resultCodeEnum.getDesc());
        this.code = resultCodeEnum.getCode();
        this.desc = resultCodeEnum.getDesc();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
