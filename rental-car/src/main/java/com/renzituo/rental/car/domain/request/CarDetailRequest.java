package com.renzituo.rental.car.domain.request;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class CarDetailRequest extends BaseRequest implements Serializable {
    private Long carId;
}
