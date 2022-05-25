package com.renzituo.rental.car.domain.request;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class OrderRequest  extends  BaseRequest implements Serializable {
    private Long orderId;
}
