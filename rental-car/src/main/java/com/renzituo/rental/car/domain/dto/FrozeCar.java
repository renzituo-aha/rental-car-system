package com.renzituo.rental.car.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FrozeCar {
    private Long carId;
    private Long userId;
    private Long orderId;
    private Long timestamp;
}
