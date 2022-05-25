package com.renzituo.rental.car.domain.request;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class BaseRequest implements Serializable {
    private Long userId;
    private Long pageSize;
    private Long pageIndex;
}
