package com.renzituo.rental.car.domain.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@Builder
@ToString
public class UserInfo implements Serializable {
    private Long userId;
}
