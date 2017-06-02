package io.egen.harika.Service;

import io.egen.harika.Entity.VehicleDetails;
import io.egen.harika.Exceptions.BadRequestException;
import io.egen.harika.Exceptions.NotFoundException;
import io.egen.harika.Repository.VehicleDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VehicleDetailsServiceImpl implements VehicleDetailsService {

    @Autowired
    private VehicleDetailsRepository vDetailsRepository;
    @Override
    @Transactional(readOnly = true)
    public List<VehicleDetails> findAllVehicles() {

        return vDetailsRepository.findAllVehicles();
    }

    @Override
    @Transactional(readOnly = true)
    public VehicleDetails findVehicle(String vin) {
        VehicleDetails vh= vDetailsRepository.findVehicle(vin);
        if (vh == null) {
            throw new NotFoundException("Vehicle with VIN "+vin+" Not Found");
        }
        return vh;
    }

    @Override
    @Transactional
    public VehicleDetails addVehicleDetails(VehicleDetails vehicleDetails) {
        VehicleDetails vd = vDetailsRepository.findVehicleByVIN(vehicleDetails.getvin());
        if(vd != null){
            throw new BadRequestException("Vehicle with VIN "+vehicleDetails.getvin()+" already exists");
        }
        return vDetailsRepository.addVehicleDetails(vehicleDetails);
    }

    @Override
    @Transactional
    public VehicleDetails updateVehicleDetails(String vin, VehicleDetails vehicleDetails) {

        VehicleDetails vd = vDetailsRepository.findVehicle(vin);
        if(vd == null){
            throw new NotFoundException("Vehicle with VIN "+vin+" Not Found");
        }
        return vDetailsRepository.updateVehicleDetails(vehicleDetails);
    }

    @Override
    @Transactional
    public void deleteDetails(String vin) {
        VehicleDetails vd = vDetailsRepository.findVehicle(vin);
        if(vd == null){
            throw new NotFoundException("Vehicle with VIN "+vin+" Not Found");
        }
        vDetailsRepository.deleteDetails(vd);
    }
}
