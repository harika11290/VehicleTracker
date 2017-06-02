package io.egen.harika.Service;

import io.egen.harika.Entity.VehicleDetails;

import java.util.List;

public interface VehicleDetailsService {
    List<VehicleDetails> findAllVehicles();
    VehicleDetails findVehicle(String vin);
    VehicleDetails addVehicleDetails(VehicleDetails vehicleDetails);
    VehicleDetails updateVehicleDetails(String vin, VehicleDetails vehicleDetails);
    void deleteDetails(String vin);
}
