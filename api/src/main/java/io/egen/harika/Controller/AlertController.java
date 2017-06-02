package io.egen.harika.Controller;


import io.egen.harika.Entity.AlertDetails;
import io.egen.harika.Entity.Tires;
import io.egen.harika.Entity.VehicleDetails;
import io.egen.harika.Entity.VehicleReadings;
import io.egen.harika.Repository.VehicleDetailsRepository;
import io.egen.harika.Repository.VehicleReadingsRepository;
import javafx.scene.layout.Priority;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

public class AlertController {

   private VehicleDetailsRepository vehicleDetailsRepository;
   private Tires tires;
    String priority = null;
    boolean isTirePressLessThan32= false;
    boolean isTirePressgreaterthan36= false;
    public String triggerAlert(VehicleReadings vehicleReadings){
        String vin = vehicleReadings.getvIN();
        VehicleDetails vehicleDetails = vehicleDetailsRepository.findVehicleByVIN(vin);
        if((tires.getFrontLeft() < 32 )|| (tires.getFrontRight()< 32) || (tires.getRearLeft() < 32) || (tires.getRearRight()<32)){
            isTirePressLessThan32 = true;
        }
        if((tires.getFrontLeft() > 36 )|| (tires.getFrontRight()> 36 ) || (tires.getRearLeft() > 36 ) || (tires.getRearRight()> 36 )){
            isTirePressgreaterthan36 = true;
        }
        if(vehicleReadings.getEngineRpm() >= vehicleDetails.getRedlineRpm()){
             priority = "HIGH";
        }else if(vehicleReadings.getFuelVolume() <= vehicleDetails.getMaxFuelVolume()){
            priority = "MEDIUM";
        } else if(isTirePressgreaterthan36 || isTirePressLessThan32){
            priority = "LOW";
        }else if(vehicleReadings.isEngineCoolentLow()|| vehicleReadings.isEngineLightsOn()) {
            priority = "LOW";
        }
        return priority;
    }


}
