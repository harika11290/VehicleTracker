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
    
    @Transactional(readOnly = true)
    public List<VehicleDetails> findAllVehicles() {

        return vDetailsRepository.findAllVehicles();
    }

    
    @Transactional(readOnly = true)
    public VehicleDetails findVehicle(String vin) {
        VehicleDetails vh= vDetailsRepository.findVehicle(vin);
        if (vh == null) {
            throw new NotFoundException("Vehicle with VIN "+vin+" Not Found");
        }
        return vh;
    }

    
    @Transactional
    public List<VehicleDetails> addVehicleDetails(List<VehicleDetails> vehicleDetails) {
    	
    	VehicleDetails vDetails = new VehicleDetails();
    	for(int i=0; i< vehicleDetails.size();i++){
    		vDetails=vehicleDetails.get(i);
    		
        VehicleDetails vd = vDetailsRepository.checkIfVehicleExists(vDetails.getVin());
        if(vd != null){
        	vehicleDetails.remove(i);
            throw new BadRequestException("Vehicle with VIN "+vDetails.getVin()+" already exists");
        }
    	}
        return vDetailsRepository.addVehicleDetails(vehicleDetails);
    }

    
    @Transactional
    public List<VehicleDetails> updateVehicleDetails(List<VehicleDetails> vehicleDetails) {

        return vDetailsRepository.updateVehicleDetails(vehicleDetails);
    }

    
    @Transactional
    public void deleteDetails(String vin) {
        VehicleDetails vd = vDetailsRepository.findVehicle(vin);
        if(vd == null){
            throw new NotFoundException("Vehicle with VIN "+vin+" Not Found");
        }
        vDetailsRepository.deleteDetails(vd);
    }
}
