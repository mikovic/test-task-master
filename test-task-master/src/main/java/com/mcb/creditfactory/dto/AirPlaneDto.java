package com.mcb.creditfactory.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.mcb.creditfactory.model.Assessment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeName("airplane")
public class AirPlaneDto implements Collateral {
    private Long id;
    private String brand;
    private String model;
    private String manufacturer;
    private Short year;
    private Short fuelCapacity;
    private int seats;
    private List<Assessment> assessments;

    public List<Assessment> getAssessments() {
        if (this.assessments == null){
            this.assessments = new ArrayList<>();
        }
        return assessments;
    }

}
