package io.egen.harika.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.harika.Entity.AlertDetails;
import io.egen.harika.Entity.Tires;
import io.egen.harika.Entity.VehicleDetails;
import io.egen.harika.Entity.VehicleReadings;
import io.egen.harika.Repository.VehicleDetailsRepositoryImpl;
import io.egen.harika.Service.VehicleAlertsService;

@CrossOrigin(origins = "http://mocker.egen.io", maxAge = 3600)
@RestController
@RequestMapping(value = "alertDetails")
public class AlertController {
	
	@Autowired
	private VehicleAlertsService vehicleAlertsService;
	
	@RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<AlertDetails> findAllAlerts(){
        return  vehicleAlertsService.findAllAlerts();
     }
    @RequestMapping(method = RequestMethod.GET,value = "{vin}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<AlertDetails> findAlertsbyVin(@PathVariable("vin") String vin){
        return vehicleAlertsService.findAlertsbyVin(vin);
    }

}
