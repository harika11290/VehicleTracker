package io.egen.harika.Repository;

import java.util.List;

import io.egen.harika.Entity.AlertDetails;

public interface AlertRepository {
	List<AlertDetails> findAllAlerts();
	List<AlertDetails> findAlertsbyVin(String vin);
	AlertDetails createAlerts(AlertDetails alertDetails);
}
