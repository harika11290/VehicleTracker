package io.egen.harika.Controller;

import io.egen.harika.Entity.VehicleDetails;
import io.egen.harika.Service.VehicleDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mysql.cj.xdevapi.JsonArray;

import java.util.List;

@CrossOrigin(origins = "http://mocker.egen.io", maxAge = 3600)
@RestController
@RequestMapping(value = "vehicleDetails")
public class VehicleController {

    @Autowired
    private VehicleDetailsService vehicleDetailsService;
    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<VehicleDetails> findAllVehicles(){
        return vehicleDetailsService.findAllVehicles();
    }
    @RequestMapping(method = RequestMethod.GET,value = "{vin}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public VehicleDetails findVehicle(@PathVariable("vin") String vin){
        return vehicleDetailsService.findVehicle(vin);
    }
    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<VehicleDetails> addVehicleDetails(@RequestBody List<VehicleDetails> vehicleDetails){
        return vehicleDetailsService.addVehicleDetails(vehicleDetails);
    }
    @RequestMapping(method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<VehicleDetails> updateDetails(@RequestBody List<VehicleDetails> vehicleDetails){
    	 return vehicleDetailsService.updateVehicleDetails(vehicleDetails);
   
    }
@RequestMapping(method = RequestMethod.DELETE, value = "{vin}")
    public void deleteDetails(@PathVariable("vin") String vin){
        vehicleDetailsService.deleteDetails(vin);
    }
}
