package com.renzituo.rental.car.service;

import com.renzituo.rental.car.domain.dto.UserInfo;

public interface UserInfoService {
    Long userId=1L;
    default UserInfo getUserInfo(){
        return UserInfo.builder().userId(userId).build();
    }
}
