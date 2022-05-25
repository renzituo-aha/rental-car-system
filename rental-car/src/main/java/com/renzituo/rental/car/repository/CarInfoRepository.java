package com.renzituo.rental.car.repository;

import com.renzituo.rental.car.common.exception.RentalCarException;
import com.renzituo.rental.car.common.util.IdGen;
import com.renzituo.rental.car.domain.dto.CarInfo;
import com.renzituo.rental.car.domain.dto.ExpiredOrder;
import com.renzituo.rental.car.domain.dto.FrozeCar;
import com.renzituo.rental.car.domain.enums.ResultCodeEnum;
import com.renzituo.rental.car.domain.request.BookOrderRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

@Repository
@Slf4j
public class CarInfoRepository {

    // pay time, 30 second
    private static final long EXPIRED_TIME = 30 * 1000;

    private AtomicLong carId = new AtomicLong();

    private ConcurrentHashMap<Long, CarInfo> CAR_REPOSITORY = new ConcurrentHashMap<Long, CarInfo>();

    // key-userId  value-FrozeInfo
    private ConcurrentHashMap<String, FrozeCar> FROZEN_CAR = new ConcurrentHashMap<String, FrozeCar>();

    private ReentrantLock lock = new ReentrantLock();


    private ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(1);


    @Resource
    private ApplicationContext applicationContext;


    @PostConstruct
    private void initCarInfo() {
        // init Toyota Camry
        long camryId = IdGen.genId();
        CAR_REPOSITORY.put(camryId, CarInfo.builder().carId(camryId).carModel("Toyota Camry").stock(2).fee("200.00").build());

        // init BMW 650
        long bmwId = IdGen.genId();
        CAR_REPOSITORY.put(bmwId, CarInfo.builder().carId(bmwId).carModel("BMW 650").stock(2).fee("500.00").build());

        // task for thaw the not pay car
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            thawCar();
        }, 5, 5, TimeUnit.SECONDS);
    }

    /**
     * query all car list(page query)
     *
     * @return
     */
    public List<CarInfo> queryCarList() {
        List<CarInfo> res = new ArrayList<>();
        for (Map.Entry entry : CAR_REPOSITORY.entrySet()) {
            res.add((CarInfo) entry.getValue());
        }

        return res;
    }

    /**
     * query by id
     *
     * @param carId
     * @return
     */
    public CarInfo queryById(Long carId) {
        return CAR_REPOSITORY.get(carId);
    }

    /**
     * @param userId
     * @param orderId
     * @return
     */
    public boolean confirmFrozen(Long userId, Long orderId) {
        FrozeCar carInfo = FROZEN_CAR.remove(String.format("%s|%s", userId, orderId));
        if (carInfo == null) {
            throw new RentalCarException(ResultCodeEnum.EXPIRED_PAY);
        }

        return true;
    }

    /**
     * roll back order
     *
     * @param userId
     * @param orderId
     * @return
     */
    public boolean rollbackFrozen(Long userId, Long orderId) {
        lock.lock();
        try {
            log.info("the user:{}  has not pay the order,thaw Car");
            FrozeCar carInfo = FROZEN_CAR.remove(String.format("%s|%s",userId,orderId));
            if (carInfo == null) {
                return true;
            }

            CarInfo car = CAR_REPOSITORY.get(carInfo.getCarId());
            car.setStock(car.getStock() + 1);

            CAR_REPOSITORY.put(carInfo.getCarId(), car);
        } catch (Exception e) {
            log.error("roll back car error!", e);
        } finally {
            lock.unlock();
        }

        return true;
    }

    public boolean updateRepository(CarInfo carInfo) {
        lock.lock();
        try {
            CAR_REPOSITORY.put(carInfo.getCarId(), carInfo);
            return true;
        } catch (Exception e) {
            log.error("update car error!", e);
            return false;
        } finally {
            lock.unlock();
        }
    }

    /**
     * book order need froze the car
     *
     * @param request
     * @return
     */
    public CarInfo tryFrozen(BookOrderRequest request) {
        lock.lock();
        CarInfo carInfo = CAR_REPOSITORY.get(request.getCarId());
        try {
            // stock verify

            if (carInfo.getStock() < 0) {
                throw new RentalCarException(ResultCodeEnum.STOCK_NOT_ENOUGH);
            }

            // froze the car
            FROZEN_CAR.put(String.format("%s|%s", request.getUserId(), request.getOrderId()), FrozeCar.builder().carId(carInfo.getCarId()).orderId(request.getOrderId()).userId(request.getUserId()).timestamp(System.currentTimeMillis() + EXPIRED_TIME).build());

            // desc the stock
            carInfo.setStock(carInfo.getStock() - 1);

            // store
            CAR_REPOSITORY.put(carInfo.getCarId(), carInfo);


        } catch (Exception e) {
            if (e instanceof RentalCarException) {
                throw e;
            } else {
                log.error("bookCar error! userId:{} carId:{}", request.getUserId(), request.getCarId(), e);
                throw new RentalCarException(ResultCodeEnum.SYSTEM_ERROR);
            }
        } finally {
            lock.unlock();
        }

        return carInfo;
    }

    /**
     * thaw the not pay car
     */
    private void thawCar() {
        if (!FROZEN_CAR.isEmpty()) {
            for (Map.Entry map : FROZEN_CAR.entrySet()) {
                FrozeCar frozeCar = (FrozeCar) map.getValue();

                // long time no pay ,thaw the car
                if (frozeCar.getTimestamp() < System.currentTimeMillis()) {
                    lock.lock();
                    try {
                        log.info("the user:{}  has not pay the order,thaw Car");
                        FROZEN_CAR.remove(map.getKey());

                        CarInfo car = CAR_REPOSITORY.get(frozeCar.getCarId());
                        car.setStock(car.getStock() + 1);

                        CAR_REPOSITORY.put(frozeCar.getCarId(), car);

                        // publish expire event
                        applicationContext.publishEvent(new ExpiredOrder(this, frozeCar));
                    } catch (Exception e) {
                        log.error("thaw car error!", e);
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }
    }

}
