package io.egen.harika.Controller;


import io.egen.harika.Entity.VehicleReadings;
import io.egen.harika.Service.VehicleReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://mocker.egen.io", maxAge = 3600)
@RestController
@RequestMapping(value = "vehicleReadings")
public class ReadingsController {
    @Autowired
    private VehicleReaderService vehicleReaderService;
    //private  AlertController alertController;
    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<VehicleReadings> findAllReadings(){
        return  vehicleReaderService.findAllVehicles();
     }
    @RequestMapping(method = RequestMethod.GET,value = "{vin}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<VehicleReadings> findVehicleReading(@PathVariable("vin") String vin){
        return vehicleReaderService.findVehicleReadingsbyVin(vin);
    }
    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public VehicleReadings addVehicleReadings(@RequestBody VehicleReadings vehicleReadings){
        return vehicleReaderService.addVehicleReadings(vehicleReadings);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{vin}",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public VehicleReadings updateReadings(@PathVariable("vin") String vin, @RequestBody VehicleReadings vehicleDetails){
        return vehicleReaderService.updateVehicleReadings(vin,vehicleDetails);
    }

@RequestMapping(method = RequestMethod.DELETE, value = "{vin}")
    public void deleteReadings(@PathVariable("vin") String vin){
        vehicleReaderService.delete(vin);
    }
}
