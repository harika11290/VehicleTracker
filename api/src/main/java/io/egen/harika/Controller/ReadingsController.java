package io.egen.harika.Controller;

import io.egen.harika.Entity.VehicleReadings;
import io.egen.harika.Service.VehicleReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/vehicleReadings")
public class ReadingsController {
    @Autowired
    private VehicleReaderService vehicleReaderService;
    private  AlertController alertController;
    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<VehicleReadings> findAllReadings(){
        return  vehicleReaderService.findAllVehicles();
     }
    @RequestMapping(method = RequestMethod.GET,value = "{VIN}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public VehicleReadings findVehicleReading(@PathVariable("VIN") String vin){
        return vehicleReaderService.findVehicleReading(vin);
    }
    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public VehicleReadings addVehicleReadings(@RequestBody VehicleReadings vehicleDetails){
        return vehicleReaderService.addVehicleReadings(vehicleDetails);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "{VIN}",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public VehicleReadings updateReadings(@PathVariable("VIN") String vin, @RequestBody VehicleReadings vehicleDetails){
        return vehicleReaderService.updateVehicleReadings(vin,vehicleDetails);
    }
@RequestMapping(method = RequestMethod.DELETE, value = "{VIN}")
    public void deleteReadings(@PathVariable("VIN") String vin){
        vehicleReaderService.delete(vin);
    }
}
