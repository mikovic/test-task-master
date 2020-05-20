package com.mcb.creditfactory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ASSESSMENT")
public class Assessment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "assessed_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date assessedDate;
    @Column(name = "assessed_value")
    private BigDecimal value;
    @ManyToOne
    @JoinTable(
            name = "CAR_ASSESSMENT",
            joinColumns = @JoinColumn(name = "assessment_id"),
            inverseJoinColumns = @JoinColumn(name = "car_id")
    )
    private Car car;

    @ManyToOne
    @JoinTable(
            name = "CAR_ASSESSMENT",
            joinColumns = @JoinColumn(name = "assessment_id"),
            inverseJoinColumns = @JoinColumn(name = "airPlane_id")
    )
    private AirPlane plane;
}
