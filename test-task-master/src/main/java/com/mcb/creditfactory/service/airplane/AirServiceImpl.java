package com.mcb.creditfactory.service.airplane;

import com.mcb.creditfactory.dto.AirPlaneDto;
import com.mcb.creditfactory.external.ExternalApproveService;
import com.mcb.creditfactory.model.AirPlane;
import com.mcb.creditfactory.repository.AirPlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AirServiceImpl implements AirPlaneService  {
    @Autowired
    private ExternalApproveService approveService;

    @Autowired
    AirPlaneRepository airPlaneRepository;

    @Override
    public boolean approve(AirPlaneDto dto) {
        return approveService.approve(new AirPlaneAdapter(dto))== 0;
    }

    @Override
    public AirPlane save(AirPlane airPlane) {
        return airPlaneRepository.save(airPlane);
    }

    @Override
    public Optional<AirPlane> load(Long id) {
        return airPlaneRepository.findById(id);
    }

    @Override
    public AirPlane fromDto(AirPlaneDto dto) {
        return new AirPlane(
                dto.getId(),
                dto.getBrand(),
                dto.getModel(),
                dto.getManufacturer(),
                dto.getYear(),
                dto.getFuelCapacity(),
                dto.getSeats(),
                dto.getAssessments()
        );
    }


    @Override
    public AirPlaneDto toDTO(AirPlane plane) {
        return new AirPlaneDto(
                plane.getId(),
                plane.getBrand(),
                plane.getModel(),
                plane.getManufacturer(),
                plane.getYear(),
                plane.getYear(),
                plane.getSeats(),
                plane.getAssessments()
        );
    }

    @Override
    public Long getId(AirPlane plane) {
        return plane.getId();
    }
}
