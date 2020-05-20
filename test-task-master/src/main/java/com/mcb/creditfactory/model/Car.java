package com.mcb.creditfactory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CAR")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "brand")
    private String brand;
    @Column(name = "model")
    private String model;
    @Column(name = "manufacturer")
    private Double power;
    @Column(name = "year_of_issue")
    private Short year;
    // @OrderBy("assessed_date DESC")
    @OneToMany(mappedBy = "car", cascade=CascadeType.ALL)
    @JoinTable(
            name = "CAR_ASSESSMENT",
            joinColumns = @JoinColumn(name = "car_id"),
            inverseJoinColumns = @JoinColumn(name = "assessment_id")
    )
    private List<Assessment> assessments;

    public List<Assessment> getAssessments() {
        if (this.assessments == null){
            this.assessments = new ArrayList<>();
        }
        return assessments;
    }
    public void addAssessment(Assessment assessment){
        this.assessments.add(0, assessment);
    }
}
