package com.renzituo.rental.car.controller;

import com.renzituo.rental.car.domain.dto.CarInfo;
import com.renzituo.rental.car.domain.request.BaseRequest;
import com.renzituo.rental.car.domain.request.CarListRequest;
import com.renzituo.rental.car.domain.response.BaseResponse;
import com.renzituo.rental.car.domain.response.CarListResponse;
import com.renzituo.rental.car.domain.response.OrderListResponse;
import com.renzituo.rental.car.service.BookService;
import com.renzituo.rental.car.service.PersonService;
import com.renzituo.rental.car.service.UserInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {
    @Resource
    private BookService bookService;

    @Resource
    private PersonService personService;

    @RequestMapping("/")
    public String index(Model model) {

        Map<String, Object> dashboardMap = getDashBoardMap();
        model.addAllAttributes(dashboardMap);

        return "index";
    }

    /**
     * get main page dashboard data
     *
     * @return
     */
    private Map<String, Object> getDashBoardMap() {
        Map<String, Object> dashboardMap = new HashMap<>();

        // get car list
        CarListRequest carListRequest = new CarListRequest();
        carListRequest.setUserId(UserInfoService.userId);
        carListRequest.setPageIndex(0L);
        carListRequest.setPageIndex(100L);

        BaseResponse carListRes = bookService.queryCarList(carListRequest);
        CarListResponse carList = (CarListResponse) carListRes.getData();
        dashboardMap.put("carList", carList.getCarList());
        dashboardMap.put("carListCount", carList.getTotalCount());

        // get order info
        BaseRequest orderListReq = new BaseRequest();
        orderListReq.setUserId(UserInfoService.userId);
        orderListReq.setPageIndex(0L);
        orderListReq.setPageIndex(100L);

        BaseResponse orderListRes = personService.orderList(orderListReq);
        OrderListResponse orderListResponse = (OrderListResponse) orderListRes.getData();
        dashboardMap.put("orderList", orderListResponse.getOrderList());
        dashboardMap.put("orderListCount", orderListResponse.getTotalCount());

        return dashboardMap;
    }
}
