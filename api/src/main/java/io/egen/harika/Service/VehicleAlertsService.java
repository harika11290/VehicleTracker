package io.egen.harika.Service;

import java.util.List;

import io.egen.harika.Entity.AlertDetails;

public interface VehicleAlertsService {

List<AlertDetails> findAllAlerts();
List<AlertDetails> findAlertsbyVin(String vin);

}
