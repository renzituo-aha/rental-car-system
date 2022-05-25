package com.renzituo.rental.car.domain.request;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
public class BookOrderRequest extends  BaseRequest implements Serializable {
    private Long carId;
    private Integer useDays;
    private Long orderId;
    private Date rentalDate =  new Date();
    private Date returnDate =  new Date();
}
