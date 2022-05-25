package com.renzituo.rental.car.domain.request;

import com.renzituo.rental.car.domain.dto.PageModel;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
@Data
@Slf4j
public class CarListRequest extends BaseRequest implements Serializable {
    private String carModel;
}
