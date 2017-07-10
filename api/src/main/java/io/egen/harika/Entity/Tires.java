package io.egen.harika.Entity;



import javax.persistence.*;
import java.util.UUID;

@Entity
@NamedQueries({
        @NamedQuery(name = "Tires.findAll",
                query = "SELECT tires FROM Tires tires"),
})
public class Tires {
    @Id
    @Column(columnDefinition = "varchar(36)")
    private String tiresId;
    private int frontLeft;
    private int frontRight;
    private int rearLeft;
    private int rearRight;

    public Tires(){
        this.tiresId = UUID.randomUUID().toString();
    }
    public String getTiresId() {
        return tiresId;
    }

    public void setTiresId(String tiresId) {
        this.tiresId = tiresId;
    }

    public int getFrontLeft() {
        return frontLeft;
    }

    public void setFrontLeft(int frontLeft) {
        this.frontLeft = frontLeft;
    }

    public int getFrontRight() {
        return frontRight;
    }

    public void setFrontRight(int frontRight) {
        this.frontRight = frontRight;
    }

    public int getRearLeft() {
        return rearLeft;
    }

    public void setRearLeft(int rearLeft) {
        this.rearLeft = rearLeft;
    }

    public int getRearRight() {
        return rearRight;
    }

    public void setRearRight(int rearRight) {
        this.rearRight = rearRight;
    }
}
