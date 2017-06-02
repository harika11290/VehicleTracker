package io.egen.harika.Service;

import io.egen.harika.Entity.VehicleReadings;

import java.util.List;

public interface VehicleReaderService {
    List<VehicleReadings> findAllVehicles();
    VehicleReadings findVehicleReading(String vin);
    VehicleReadings addVehicleReadings(VehicleReadings vehicleReadings);
    //VehicleReadings updateVehicleReadings(String vin, VehicleReadings vehicleReadings);
    void delete(String vin);


}
