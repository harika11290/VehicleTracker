package io.egen.harika.Service;

import io.egen.harika.Entity.VehicleDetails;

import java.util.List;

public interface VehicleDetailsService {
    List<VehicleDetails> findAllVehicles();
    VehicleDetails findVehicle(String vin);
    List<VehicleDetails> addVehicleDetails(List<VehicleDetails> vehicleDetails);
    List<VehicleDetails> updateVehicleDetails(List<VehicleDetails> vehicleDetails);
    void deleteDetails(String vin);
}
