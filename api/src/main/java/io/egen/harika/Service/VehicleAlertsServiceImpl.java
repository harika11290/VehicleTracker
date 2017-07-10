package io.egen.harika.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.harika.Entity.AlertDetails;
import io.egen.harika.Repository.AlertsRepositoryImpl;

@Service
public class VehicleAlertsServiceImpl implements VehicleAlertsService{

	@Autowired
	private AlertsRepositoryImpl alertsRepositoryImpl;
	
	@Transactional(readOnly=true)
	public List<AlertDetails> findAllAlerts() {
		return alertsRepositoryImpl.findAllAlerts();
	}

	@Transactional(readOnly=true)
	public List<AlertDetails> findAlertsbyVin(String vin) {
		// TODO Auto-generated method stub
		return alertsRepositoryImpl.findAlertsbyVin(vin);
	}

}
