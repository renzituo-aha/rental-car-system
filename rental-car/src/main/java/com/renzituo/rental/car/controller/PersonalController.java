package com.renzituo.rental.car.controller;

import com.renzituo.rental.car.domain.dto.CarInfo;
import com.renzituo.rental.car.domain.request.BaseRequest;
import com.renzituo.rental.car.domain.request.OrderRequest;
import com.renzituo.rental.car.domain.request.PayRequest;
import com.renzituo.rental.car.domain.request.ReturnCarRequest;
import com.renzituo.rental.car.domain.response.BaseResponse;
import com.renzituo.rental.car.domain.response.OrderListResponse;
import com.renzituo.rental.car.service.PersonService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("/personal")
@RestController
public class PersonalController extends BaseController{

    @Resource
    private PersonService personService;

    @RequestMapping(value = "/orderList", method = RequestMethod.POST)
    public BaseResponse<OrderListResponse> queryOrderList(@RequestBody BaseRequest baseRequest) {
        return exceptionWrapper("queryOrderList", baseRequest, (req) -> {
            return personService.orderList(req);
        });
    }

    @RequestMapping(value = "/orderDetail", method = RequestMethod.POST)
    public BaseResponse<OrderListResponse> queryOrderDetail(@RequestBody OrderRequest orderRequest) {
        return exceptionWrapper("queryOrderDetail", orderRequest, (req) -> {
            return personService.orderDetail((OrderRequest) req);
        });
    }

    @RequestMapping(value = "/returnCar", method = RequestMethod.POST)
    public BaseResponse<OrderListResponse> returnCar(@RequestBody ReturnCarRequest request) {
        return exceptionWrapper("returnCar", request, (req) -> {
            return personService.returnCar((ReturnCarRequest) req);
        });
    }
}
