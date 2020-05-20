package com.mcb.creditfactory.repository;

import com.mcb.creditfactory.model.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CarRepository extends CrudRepository<Car, Long> {
    @Query("SELECT DISTINCT car FROM Car car" +
            " left join fetch car.assessments assessment ON car.id =:id ORDER BY assessment.assessedDate DESC" )
    public Optional<Car> findById(Long id);
}
