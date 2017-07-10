package io.egen.harika.Service;

import io.egen.harika.Entity.AlertDetails;
import io.egen.harika.Entity.Tires;
import io.egen.harika.Entity.VehicleDetails;
import io.egen.harika.Entity.VehicleReadings;
import io.egen.harika.Exceptions.NotFoundException;
import io.egen.harika.Repository.AlertRepository;
import io.egen.harika.Repository.VehicleDetailsRepository;
import io.egen.harika.Repository.VehicleReadingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Calendar;
import java.util.List;

@Service
public class VehicleReaderServiceImpl implements VehicleReaderService{

    @Autowired
    private VehicleReadingsRepository vReadingRepository;
    @Autowired
    private VehicleDetailsRepository vehicleDetailsRepository;
    @Autowired
    private AlertRepository alertRepository;
    
    @Transactional(readOnly = true)
    public List<VehicleReadings> findAllVehicles() {
        return vReadingRepository.findAllVehicles();
    }
    
    @Transactional(readOnly = true)
    public List<VehicleReadings> findVehicleReadingsbyVin(String vin) {
        List<VehicleReadings> vehicleReadings= vReadingRepository.findVehicleReadingsbyVin(vin);
        if(vehicleReadings == null){
            throw new NotFoundException("Vehicle with VIN "+vin+" Not Found");
        }
        return vReadingRepository.findVehicleReadingsbyVin(vin);
    }

    
    @Transactional
    public VehicleReadings addVehicleReadings(VehicleReadings vehicleReadings) {
    	VehicleDetails vdetails = vehicleDetailsRepository.findVehicle(vehicleReadings.getVin());
    	if(vdetails!=null){
    		getVehicleAlertDetails(vehicleReadings, vdetails);
     	}
        return vReadingRepository.addVehicleReadings(vehicleReadings);
    }

    @Transactional
     public VehicleReadings updateVehicleReadings(String vin, VehicleReadings vehicleReadings) {
    	List<VehicleReadings> vReadings = findVehicleReadingsbyVin(vin);
        return vReadingRepository.updateVehicleReadings(vehicleReadings);
    }

    
    @Transactional
    public void delete(String vin) {
      Boolean exists = vReadingRepository.checkifVehicleReadingsExists(vin);
      List<VehicleReadings> vReadings = null;
      List<AlertDetails> vAlerts = null;
      if(!exists){
          throw new NotFoundException("Vehicle with VIN "+vin+" Not Found");
      }else{
    	  vReadings = findVehicleReadingsbyVin(vin);
    	  vAlerts = alertRepository.findAlertsbyVin(vin);
      }
      vReadingRepository.delete(vReadings,vAlerts);
    }
    
    private void getVehicleAlertDetails(VehicleReadings vehicleReadings, VehicleDetails vDetails){
    	Boolean isTirePressLessThan32 = false;
		Boolean isTirePressgreaterthan36 = false;
		Tires tires = vehicleReadings.getTires();
		if((tires.getFrontLeft() < 32 )|| (tires.getFrontRight()< 32) || (tires.getRearLeft() < 32) || (tires.getRearRight()<32)){
            isTirePressLessThan32 = true;
        }
        if((tires.getFrontLeft() > 36 )|| (tires.getFrontRight()> 36 ) || (tires.getRearLeft() > 36 ) || (tires.getRearRight()> 36 )){
            isTirePressgreaterthan36 = true;
        }
        if(vehicleReadings.getEngineRpm() >= vDetails.getRedlineRpm()){
             AlertDetails alertDetails = new AlertDetails();
             alertDetails.setAlertCreationDate(Calendar.getInstance().getTime());
             alertDetails.setAlertType("High Engine RPM");
             alertDetails.setPriority("HIGH");
             alertDetails.setMessage("Please Check your Engine RPM its HIGH");
             alertDetails.setVin(vehicleReadings.getVin());
             alertRepository.createAlerts(alertDetails);
        }
        if(vehicleReadings.getFuelVolume() <= (0.1 * vDetails.getMaxFuelVolume())){
        	AlertDetails alertDetails = new AlertDetails();
            alertDetails.setAlertCreationDate(Calendar.getInstance().getTime());
            alertDetails.setAlertType("Fuel Volume is Low");
            alertDetails.setPriority("MEDIUM");
            alertDetails.setMessage("Please check your fuel volume. Time to refill.");
            alertDetails.setVin(vehicleReadings.getVin());
            alertRepository.createAlerts(alertDetails);
        } 
        if(isTirePressgreaterthan36 || isTirePressLessThan32){
        	AlertDetails alertDetails = new AlertDetails();
            alertDetails.setAlertCreationDate(Calendar.getInstance().getTime());
            alertDetails.setAlertType("Check Tire Pressure");
            alertDetails.setPriority("LOW");
            alertDetails.setMessage("Please check your tires pressure");
            alertDetails.setVin(vehicleReadings.getVin());
            alertRepository.createAlerts(alertDetails);
        }
        if(vehicleReadings.isEngineCoolentLow()) {
        	AlertDetails alertDetails = new AlertDetails();
            alertDetails.setAlertCreationDate(Calendar.getInstance().getTime());
            alertDetails.setAlertType("Engine Coolent is Low");
            alertDetails.setMessage("Your engine coolent is low");
            alertDetails.setPriority("LOW");
            alertDetails.setVin(vehicleReadings.getVin());
            alertRepository.createAlerts(alertDetails);
        }
        if(vehicleReadings.isEngineLightsOn()) {
        	AlertDetails alertDetails = new AlertDetails();
            alertDetails.setAlertCreationDate(Calendar.getInstance().getTime());
            alertDetails.setAlertType("Engine Lights are ON");
            alertDetails.setMessage("Your engine lights are ON");
            alertDetails.setPriority("LOW");
            alertDetails.setVin(vehicleReadings.getVin());
            alertRepository.createAlerts(alertDetails);
        }
        
	
      }
    
    private void sendMail(){
    	
    }
}
