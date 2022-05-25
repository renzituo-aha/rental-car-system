package com.renzituo.rental.car.controller;


import com.renzituo.rental.car.common.exception.RentalCarException;
import com.renzituo.rental.car.domain.enums.ResultCodeEnum;
import com.renzituo.rental.car.domain.request.BaseRequest;
import com.renzituo.rental.car.domain.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.Callable;
import java.util.function.Function;

@Component
@Slf4j
public class BaseController {
    public  BaseResponse exceptionWrapper(String method,BaseRequest request, Function<BaseRequest,BaseResponse> function)
    {
        try{
           return function.apply(request);
        }
        catch (RentalCarException rentalCarException)
        {
            log.error(method + " failed! userId",request.getUserId(),rentalCarException);
            return BaseResponse.genByException(rentalCarException);
        }
        catch (Exception e)
        {
            log.error(method + " failed! userId",request.getUserId(),e);
            return BaseResponse.genByException(new RentalCarException(ResultCodeEnum.SYSTEM_ERROR));
        }
    }
}
