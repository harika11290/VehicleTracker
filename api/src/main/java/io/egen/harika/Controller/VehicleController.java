package io.egen.harika.Controller;

import io.egen.harika.Entity.VehicleDetails;
import io.egen.harika.Service.VehicleDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/vehicleDetails")
public class VehicleController {

    @Autowired
    private VehicleDetailsService vehicleDetailsService;
    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<VehicleDetails> findAllVehicles(){
        return vehicleDetailsService.findAllVehicles();
    }
    @RequestMapping(method = RequestMethod.GET,value = "{VIN}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public VehicleDetails findVehicle(@PathVariable("VIN") String vin){
        return vehicleDetailsService.findVehicle(vin);
    }
    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public VehicleDetails addVehicleDetails(@RequestBody VehicleDetails vehicleDetails){
        return vehicleDetailsService.addVehicleDetails(vehicleDetails);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "{VIN}",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public VehicleDetails updateDetails(@PathVariable("VIN") String vin, @RequestBody VehicleDetails vehicleDetails){
        return vehicleDetailsService.updateVehicleDetails(vin,vehicleDetails);
    }
@RequestMapping(method = RequestMethod.DELETE, value = "{VIN}")
    public void deleteDetails(@PathVariable("VIN") String vin){
        vehicleDetailsService.deleteDetails(vin);
    }
}
