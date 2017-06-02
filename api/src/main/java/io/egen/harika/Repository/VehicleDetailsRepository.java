package io.egen.harika.Repository;


import io.egen.harika.Entity.VehicleDetails;

import java.util.List;

public interface VehicleDetailsRepository {
    List<VehicleDetails> findAllVehicles();
    VehicleDetails findVehicle(String vin);
    VehicleDetails findVehicleByVIN(String vin);
    VehicleDetails addVehicleDetails(VehicleDetails vehicleDetails);
    VehicleDetails updateVehicleDetails(VehicleDetails vehicleDetails);
    void deleteDetails(VehicleDetails vehicleDetails);
}
