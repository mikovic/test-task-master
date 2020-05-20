package com.mcb.creditfactory.repository;

import com.mcb.creditfactory.model.AirPlane;
import com.mcb.creditfactory.model.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AirPlaneRepository extends CrudRepository<AirPlane, Long> {
    @Query("SELECT DISTINCT airPlane FROM AirPlane airPlane" +
            " left join fetch airPlane.assessments assessment ON airPlane.id =:id ORDER BY assessment.assessedDate DESC" )
    public Optional<AirPlane> findById(Long id);

}
