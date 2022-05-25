package com.renzituo.rental.car.service;

import com.renzituo.rental.car.domain.request.BaseRequest;
import com.renzituo.rental.car.domain.request.OrderRequest;
import com.renzituo.rental.car.domain.request.ReturnCarRequest;
import com.renzituo.rental.car.domain.response.BaseResponse;

public interface PersonService {
    /**
     * query order list
     * @param request
     * @return
     */
    BaseResponse orderList(BaseRequest request);

    /**
     * query order detail
     * @param request
     * @return
     */
    BaseResponse orderDetail(OrderRequest request);

    /**
     * return the car
     * @param request
     * @return
     */
    BaseResponse returnCar(ReturnCarRequest request);
}
