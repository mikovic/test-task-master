package com.mcb.creditfactory.service;

import com.mcb.creditfactory.dto.AirPlaneDto;
import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.dto.Collateral;
import com.mcb.creditfactory.service.airplane.AirPlaneService;
import com.mcb.creditfactory.service.car.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

// TODO: reimplement this
@Service
public class CollateralService {
    @Autowired
    private CarService carService;
    @Autowired
    AirPlaneService airPlaneService;

    @SuppressWarnings("ConstantConditions")
    public Long saveCollateral(Collateral object) {
        if (!(object instanceof CarDto) && !(object instanceof AirPlaneDto)) {
            throw new IllegalArgumentException();
        }
        Long id =0L;
        if (object instanceof CarDto) {
            CarDto car = (CarDto) object;
            boolean approved = carService.approve(car);
            if (!approved) {
                return null;
            }

             id = Optional.of(car)
                    .map(carService::fromDto)
                    .map(carService::save)
                    .map(carService::getId)
                    .orElse(null);
        }
        if (object instanceof AirPlaneDto) {
            AirPlaneDto plane = (AirPlaneDto) object;
            boolean approved = airPlaneService.approve(plane);
            if (!approved) {
                return null;
            }
            id = Optional.of(plane)
                    .map(airPlaneService::fromDto)
                    .map(airPlaneService::save)
                    .map(airPlaneService::getId)
                    .orElse(null);
        }
        return id;

    }

    public Collateral getInfo(Collateral object) {
        if (!(object instanceof CarDto) && !(object instanceof CarDto)) {
            throw new IllegalArgumentException();
        }
        Collateral collateral = null;
        if (object instanceof CarDto) {
            collateral = Optional.of((CarDto) object)
                    .map(carService::fromDto)
                    .map(carService::getId)
                    .flatMap(carService::load)
                    .map(carService::toDTO)
                    .orElse(null);
        }
        if (object instanceof AirPlaneDto) {
            collateral = Optional.of((AirPlaneDto) object)
                    .map(airPlaneService::fromDto)
                    .map(airPlaneService::getId)
                    .flatMap(airPlaneService::load)
                    .map(airPlaneService::toDTO)
                    .orElse(null);
        }
        return collateral;
    }
}
