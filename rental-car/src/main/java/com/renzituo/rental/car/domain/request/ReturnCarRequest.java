package com.renzituo.rental.car.domain.request;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class ReturnCarRequest extends BaseRequest implements Serializable {
    private Long orderId;
}
