package io.egen.harika.Entity;



public class AlertDetails {
    private String vin;
    private String priority;
    private VehicleReadings vehicleReadings;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public VehicleReadings getVehicleReadings() {
        return vehicleReadings;
    }

    public void setVehicleReadings(VehicleReadings vehicleReadings) {
        this.vehicleReadings = vehicleReadings;
    }


    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
