package com.mcb.creditfactory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "AIRPLANE")
public class AirPlane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "brand")
    private String brand;
    @Column(name = "model")
    private String model;
    @Column(name = "manufacturer")
    private String manufacturer;
    @Column(name = "year_of_issue")
    private Short year;
    @Column(name = "fuelCapacity")
    private Short fuelCapacity;
    @Column(name = "seats")
    private int seats;
//    @OrderBy("assessed_date DESC")
    @OneToMany(mappedBy = "airPlane", cascade=CascadeType.ALL)
    @JoinTable(
            name = "AIRPLANE_ASSESSMENT",
            joinColumns = @JoinColumn(name = "airplane_id"),
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
