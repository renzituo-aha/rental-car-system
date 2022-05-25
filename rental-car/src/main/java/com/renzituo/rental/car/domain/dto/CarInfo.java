package com.renzituo.rental.car.domain.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@Builder
public class CarInfo implements Serializable {
    private Long carId;
    private String carModel;
    private Integer stock;
    private String fee;
    private String others;
}
