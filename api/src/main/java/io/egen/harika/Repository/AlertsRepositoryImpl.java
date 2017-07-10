package io.egen.harika.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.harika.Entity.AlertDetails;
import io.egen.harika.Entity.VehicleDetails;

@Repository
public class AlertsRepositoryImpl implements AlertRepository{
	@PersistenceContext
	EntityManager em;
	
	public List<AlertDetails> findAllAlerts() {
		TypedQuery<AlertDetails> query = em.createNamedQuery("AlertDetails.findAll", AlertDetails.class);
        return query.getResultList();
	}

	public List<AlertDetails> findAlertsbyVin(String vin) {
		TypedQuery<AlertDetails> query = em.createNamedQuery("AlertDetails.findbyVin", AlertDetails.class);
		query.setParameter("alertVin", vin);
        return query.getResultList();
	}

	public AlertDetails createAlerts(AlertDetails alertDetails) {
		em.persist(alertDetails);
		return alertDetails;
	}
	

}
