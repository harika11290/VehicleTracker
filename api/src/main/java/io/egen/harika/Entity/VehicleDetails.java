package io.egen.harika.Entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@NamedQueries({
        @NamedQuery(name = "VehicleDetails.findAll",
                query = "SELECT vDetails FROM VehicleDetails vDetails"),
        @NamedQuery(name = "VehicleDetails.findByVIN",
                query = "SELECT vDetails FROM VehicleDetails vDetails WHERE vDetails.vIN=:vIN")
})
public class VehicleDetails {
    @Id
    @Column(columnDefinition = "varchar(36)", unique = true)
    private String vin;

    private String brand;
    private String model;
    private int year;
    private int redlineRpm;
    private int maxFuelVolume;
    private Date lastServiceDate;

    public String getvin() {
        return vin;
    }

    public void setvin(String vin) {
        this.vin = vin;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRedlineRpm() {
        return redlineRpm;
    }

    public void setRedlineRpm(int redlineRpm) {
        this.redlineRpm = redlineRpm;
    }

    public int getMaxFuelVolume() {
        return maxFuelVolume;
    }

    public void setMaxFuelVolume(int maxFuelVolume) {
        this.maxFuelVolume = maxFuelVolume;
    }

    public Date getLastServiceDate() {
        return lastServiceDate;
    }

    public void setLastServiceDate(Date lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }

    @Override
    public String toString() {
        return "VehicleDetails{" +
                "vin='" + vin + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                ", redlineRpm='" + redlineRpm + '\'' +
                ", maxFuelVolume='" + maxFuelVolume + '\'' +
                ", lastServiceDate=" + lastServiceDate +
                '}';
    }
}
