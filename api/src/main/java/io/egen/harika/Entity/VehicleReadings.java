package io.egen.harika.Entity;


import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@NamedQueries({
        @NamedQuery(name = "VehicleReadings.findAll",
                query = "SELECT vReadings FROM VehicleReadings vReadings"),
        @NamedQuery(name = "VehicleReadings.findByVIN",
                query = "SELECT vReadings FROM VehicleReadings vReadings WHERE vReadings.vin=:Vin")
})
public class VehicleReadings {
    @Id
    private String vReadingId;
    private String vin;
    private Double latitude;
    private Double longitude;
    private Date timestamp;
    private float fuelVolume;
    private float speed;
    private float engineHp;
    private boolean engineLightsOn;
    private boolean engineCoolentLow;
    private boolean cruiseControlOn;
    private float engineRpm;
    @OneToOne(cascade={CascadeType.ALL})
    private Tires tires;
    public VehicleReadings() {
        this.vReadingId = UUID.randomUUID()
                .toString();
    }

    public String getvReadingId() {
        return vReadingId;
    }

    public void setvReadingId(String vReadingId) {
        this.vReadingId = vReadingId;
    }

    public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

 
    public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public float getFuelVolume() {
		return fuelVolume;
	}

	public void setFuelVolume(float fuelVolume) {
		this.fuelVolume = fuelVolume;
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

    public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getEngineHp() {
		return engineHp;
	}

	public void setEngineHp(float engineHp) {
		this.engineHp = engineHp;
	}

	public float getEngineRpm() {
		return engineRpm;
	}

	public void setEngineRpm(float engineRpm) {
		this.engineRpm = engineRpm;
	}

	public Tires getTires() {
        return tires;
    }

    public void setTires(Tires tires) {
        this.tires = tires;
    }


    @Override
    public String toString() {
        return "VehicleReadings{" +
                "vReadingId='" + vReadingId + '\'' +
                ", vin='" + vin + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", timestamp=" + timestamp +
                ", fuelVolume=" + fuelVolume +
                ", speed=" + speed +
                ", engineHp=" + engineHp +
                ", engineLightsOn=" + engineLightsOn +
                ", engineCoolentLow=" + engineCoolentLow +
                ", cruiseControlOn=" + cruiseControlOn +
                ", engineRpm=" + engineRpm +
                ", tires=" + tires +
                '}';
    }
}
