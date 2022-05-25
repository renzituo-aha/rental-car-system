package com.renzituo.rental.car.common.util;

import java.util.concurrent.atomic.AtomicLong;

public class IdGen {
    private static final AtomicLong ID_REPOSITORY = new AtomicLong();

    public static long genId()
    {
        return ID_REPOSITORY.incrementAndGet();
    }
}
