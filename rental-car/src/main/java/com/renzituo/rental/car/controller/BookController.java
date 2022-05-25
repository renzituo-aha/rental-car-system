package com.renzituo.rental.car.controller;

import com.renzituo.rental.car.domain.dto.CarInfo;
import com.renzituo.rental.car.domain.dto.OrderInfo;
import com.renzituo.rental.car.domain.request.BookOrderRequest;
import com.renzituo.rental.car.domain.request.CarDetailRequest;
import com.renzituo.rental.car.domain.request.CarListRequest;
import com.renzituo.rental.car.domain.request.PayRequest;
import com.renzituo.rental.car.domain.response.BaseResponse;
import com.renzituo.rental.car.domain.response.CarListResponse;
import com.renzituo.rental.car.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/book")
public class BookController extends BaseController {
    @Resource
    private BookService bookService;

    @RequestMapping(value = "/carList", method = RequestMethod.POST)
    public BaseResponse<CarListResponse> queryCarList(@RequestBody CarListRequest carListRequest) {
        return exceptionWrapper("queryCarList", carListRequest, (req) -> {
            return bookService.queryCarList((CarListRequest) req);
        });
    }

    @RequestMapping(value = "/carDetail", method = RequestMethod.POST)
    public BaseResponse<CarInfo> queryCarDetail(@RequestBody CarDetailRequest carDetailRequest) {
        return exceptionWrapper("queryCarDetail", carDetailRequest, (req) -> {
            return bookService.queryCarDetailById((CarDetailRequest) req);
        });
    }

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public BaseResponse<OrderInfo> bookOrder(@RequestBody BookOrderRequest bookOrderRequest) {
        return exceptionWrapper("bookOrder", bookOrderRequest, (req) -> {
            return bookService.bookOrder((BookOrderRequest) req);
        });
    }

    @RequestMapping(value = "/pay", method = RequestMethod.POST)
    public BaseResponse<CarInfo> pay(@RequestBody PayRequest payRequest) {
        return exceptionWrapper("pay", payRequest, (req) -> {
            return bookService.payOrder((PayRequest) req);
        });
    }

}
