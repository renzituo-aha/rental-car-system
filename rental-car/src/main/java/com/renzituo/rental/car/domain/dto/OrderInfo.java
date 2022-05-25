package com.renzituo.rental.car.domain.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@Builder
public class OrderInfo implements Serializable {
    private Long userId;
    private Long orderId;
    private Long carId;
    private String carModel;
    private String totalFee;
    private Date bookTime;
    private Date payTime;
    private Integer useDays;
    private Date rentalDate;
    private Date returnDate;
    private Integer orderStatus;
    private String statusDesc;
}
