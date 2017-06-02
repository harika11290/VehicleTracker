package io.egen.harika.Repository;


import io.egen.harika.Entity.VehicleReadings;

import java.util.List;

public interface VehicleReadingsRepository {
    List<VehicleReadings> findAllVehicles();
    VehicleReadings findVehicleReading(String vin);
    VehicleReadings addVehicleReadings(VehicleReadings vehicleReadings);
    VehicleReadings updateVehicleReadings(VehicleReadings vehicleReadings);
    void delete(VehicleReadings vehicleReadings);
}
