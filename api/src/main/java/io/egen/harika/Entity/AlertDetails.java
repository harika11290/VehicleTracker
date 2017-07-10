package io.egen.harika.Entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.*;


@Entity
@NamedQueries({
    @NamedQuery(name = "AlertDetails.findAll",
            query = "SELECT alertDetails FROM AlertDetails alertDetails order by alertDetails.alertCreationDate desc"),
    @NamedQuery(name = "AlertDetails.findbyVin",
    query = "SELECT alertDetails FROM AlertDetails alertDetails where alertDetails.vin=:alertVin order by alertDetails.alertCreationDate desc ")
})
public class AlertDetails {
	@Id
	@Column(columnDefinition="varchar(36)")
	private String alertId;
    private String vin;
    private String priority;
    private String alertType;
    private Date alertCreationDate;
    private String message;
    

    public String getAlertId() {
		return alertId;
	}

	public void setAlertId(String alertId) {
		this.alertId = alertId;
	}

	public AlertDetails(){
		this.alertId = UUID.randomUUID().toString();
	}
	
	public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getAlertType() {
		return alertType;
	}

	public void setAlertType(String alertType) {
		this.alertType = alertType;
	}

	public Date getAlertCreationDate() {
		return alertCreationDate;
	}

	public void setAlertCreationDate(Date alertCreationDate) {
		this.alertCreationDate = alertCreationDate;
	}

	public String getMessage() {
		return message;
	}
	
    public void setMessage(String message) {
		this.message = message;
	}

	public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
