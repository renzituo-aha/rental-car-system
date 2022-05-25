package com.renzituo.rental.car.service;

import com.renzituo.rental.car.domain.request.BookOrderRequest;
import com.renzituo.rental.car.domain.request.CarDetailRequest;
import com.renzituo.rental.car.domain.request.CarListRequest;
import com.renzituo.rental.car.domain.request.PayRequest;
import com.renzituo.rental.car.domain.response.BaseResponse;

public interface BookService {
    /**
     *  page query
     * @param carListRequest
     * @return
     */
    BaseResponse queryCarList(CarListRequest carListRequest);

    /**
     * query detail
     * @param carDetailRequest
     * @return
     */
    BaseResponse queryCarDetailById(CarDetailRequest carDetailRequest);

    /**
     * book order
     * @param bookOrderRequest
     * @return
     */
    BaseResponse bookOrder(BookOrderRequest bookOrderRequest);

    /**
     * pay order
     * @param payRequest
     * @return
     */
    BaseResponse payOrder(PayRequest payRequest);

    /**
     *  cancel order
     * @param payRequest
     * @return
     */
    BaseResponse cancelOrder(PayRequest payRequest);
}
