package com.renzituo.rental.car.domain.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PageModel implements Serializable {
    private Integer pageSize;
    private Integer pageIndex;
}
