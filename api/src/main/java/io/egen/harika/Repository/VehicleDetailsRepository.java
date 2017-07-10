package io.egen.harika.Repository;


import io.egen.harika.Entity.VehicleDetails;

import java.util.List;

public interface VehicleDetailsRepository {
    List<VehicleDetails> findAllVehicles();
    VehicleDetails findVehicle(String vin);
    VehicleDetails checkIfVehicleExists(String vin);
    List<VehicleDetails> addVehicleDetails(List<VehicleDetails> vehicleDetails);
    List<VehicleDetails> updateVehicleDetails(List<VehicleDetails> vehicleDetails);
    void deleteDetails(VehicleDetails vehicleDetails);
}
