package com.mcb.creditfactory.service.airplane;

import com.mcb.creditfactory.dto.AirPlaneDto;
import com.mcb.creditfactory.external.CollateralObject;
import com.mcb.creditfactory.external.CollateralType;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
@AllArgsConstructor
public class AirPlaneAdapter implements CollateralObject {

    private AirPlaneDto plane;
    @Override
    public BigDecimal getValue() {
        return plane.getAssessments().get(0).getValue();
    }

    @Override
    public Short getYear() {
        return plane.getYear();
    }

    @Override
    public LocalDate getDate() {
        return plane.getAssessments().get(0).getAssessedDate().toLocalDate();
    }

    @Override
    public CollateralType getType() {
        return CollateralType.AIRPLANE;
    }
}
