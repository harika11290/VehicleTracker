package io.egen.harika.Repository;


import io.egen.harika.Entity.AlertDetails;
import io.egen.harika.Entity.VehicleReadings;

import java.util.List;

public interface VehicleReadingsRepository {
    List<VehicleReadings> findAllVehicles();
    List<VehicleReadings> findVehicleReadingsbyVin(String vin);
    Boolean checkifVehicleReadingsExists(String vin);
    VehicleReadings addVehicleReadings(VehicleReadings vehicleReadings);
    VehicleReadings updateVehicleReadings(VehicleReadings vehicleReadings);
    void delete(List<VehicleReadings> vehicleReadings, List<AlertDetails> alerDetails);
}
