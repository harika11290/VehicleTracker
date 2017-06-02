package io.egen.harika.Service;

import io.egen.harika.Controller.AlertController;
import io.egen.harika.Entity.VehicleReadings;
import io.egen.harika.Exceptions.NotFoundException;
import io.egen.harika.Repository.VehicleReadingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VehicleReaderServiceImpl implements VehicleReaderService{

    @Autowired
    private VehicleReadingsRepository vReadingRepository;
    private AlertController alertController;

    @Override
    @Transactional(readOnly = true)
    public List<VehicleReadings> findAllVehicles() {
        return vReadingRepository.findAllVehicles();
    }

    @Override
    @Transactional(readOnly = true)
    public VehicleReadings findVehicleReading(String vin) {
        VehicleReadings vehicleReadings= vReadingRepository.findVehicleReading(vin);
        if(vehicleReadings == null){
            throw new NotFoundException("Vehicle with VIN "+vin+" Not Found");
        }
        return vReadingRepository.findVehicleReading(vin);
    }

    @Override
    @Transactional
    public VehicleReadings addVehicleReadings(VehicleReadings vehicleReadings) {
        String priority = alertController.triggerAlert(vehicleReadings);
        System.out.println("ALERT ::"+priority);
        return vReadingRepository.addVehicleReadings(vehicleReadings);
    }

   /* @Override
     public VehicleReadings updateVehicleReadings(String vin, VehicleReadings vehicleReadings) {
        return null;
    }*/

    @Override
    @Transactional
    public void delete(String vin) {
      VehicleReadings vReadings = vReadingRepository.findVehicleReading(vin);
      if(vReadings== null){
          throw new NotFoundException("Vehicle with VIN "+vin+" Not Found");
      }
      vReadingRepository.delete(vReadings);
    }
}
