package io.egen.harika.Entity;


import javax.persistence.*;
import java.util.Date;
@Entity
@NamedQueries({
        @NamedQuery(name = "VehicleDetails.findAll",
                query = "SELECT vReadings FROM VehicleReadings vReadings"),
        @NamedQuery(name = "VehicleDetails.findByVIN",
                query = "SELECT vReadings FROM VehicleReadings vReadings WHERE vReadings.vIN=:vIN")
})
public class VehicleReadings {
    @Id
    @Column(columnDefinition = "varchar(36)")
    private String vIN;
    private String latitute;
    private String longitude;
    private Date timeStamp;
    private int fuelVolume;
    private int speed;
    private int engineHp;
    private boolean engineLightsOn;
    private boolean engineCoolentLow;
    private boolean cruiseControlOn;
    private int engineRpm;
    private Tires tires;

    public String getvIN() {
        return vIN;
    }

    public void setvIN(String vIN) {
        this.vIN = vIN;
    }

    public String getLatitute() {
        return latitute;
    }

    public void setLatitute(String latitute) {
        this.latitute = latitute;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getFuelVolume() {
        return fuelVolume;
    }

    public void setFuelVolume(int fuelVolume) {
        this.fuelVolume = fuelVolume;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getEngineHp() {
        return engineHp;
    }

    public void setEngineHp(int engineHp) {
        this.engineHp = engineHp;
    }

    public boolean isEngineLightsOn() {
        return engineLightsOn;
    }

    public void setEngineLightsOn(boolean engineLightsOn) {
        this.engineLightsOn = engineLightsOn;
    }

    public boolean isEngineCoolentLow() {
        return engineCoolentLow;
    }

    public void setEngineCoolentLow(boolean engineCoolentLow) {
        this.engineCoolentLow = engineCoolentLow;
    }

    public boolean isCruiseControlOn() {
        return cruiseControlOn;
    }

    public void setCruiseControlOn(boolean cruiseControlOn) {
        this.cruiseControlOn = cruiseControlOn;
    }

    public int getEngineRpm() {
        return engineRpm;
    }

    public void setEngineRpm(int engineRpm) {
        this.engineRpm = engineRpm;
    }

    public Tires getTires() {
        return tires;
    }

    public void setTires(Tires tires) {
        this.tires = tires;
    }
}
