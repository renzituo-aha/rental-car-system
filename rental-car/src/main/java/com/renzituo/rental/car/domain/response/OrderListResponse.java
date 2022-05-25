package com.renzituo.rental.car.domain.response;

import com.renzituo.rental.car.domain.dto.OrderInfo;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@ToString
public class OrderListResponse implements Serializable {
    private Integer totalCount;
    private List<OrderInfo> orderList;
}
