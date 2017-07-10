package io.egen.harika.Repository;

import io.egen.harika.Entity.VehicleDetails;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class VehicleDetailsRepositoryImpl implements VehicleDetailsRepository {
    @PersistenceContext
    private EntityManager em;
    
    public List<VehicleDetails> findAllVehicles() {
        TypedQuery<VehicleDetails> query = em.createNamedQuery("VehicleDetails.findAll", VehicleDetails.class);
        return query.getResultList();
    }

    
    public VehicleDetails findVehicle(String vin) {
        return em.find(VehicleDetails.class,vin);
    }

    
    public VehicleDetails checkIfVehicleExists(String vin) {
    	
        TypedQuery<VehicleDetails> query = em.createNamedQuery("VehicleDetails.findByVIN", VehicleDetails.class);
        query.setParameter("Vin", vin);
        List<VehicleDetails> resultList = query.getResultList();
        if (resultList != null && resultList.size() == 1) {
            return resultList.get(0);
        } else {
            return null;
        }
    }

    
    public List<VehicleDetails> addVehicleDetails(List<VehicleDetails> vehicleDetails) {
    	VehicleDetails vDetails = new VehicleDetails();
    	for(int i=0;i<vehicleDetails.size();i++ ){
    		vDetails = vehicleDetails.get(i);
    		em.persist(vDetails);
    	}
        return vehicleDetails;
    }

    
    public List<VehicleDetails> updateVehicleDetails(List<VehicleDetails> vehicleDetails) {
    	VehicleDetails vDetails = new VehicleDetails();
    	for(int i=0;i<vehicleDetails.size();i++ ){
    		vDetails = vehicleDetails.get(i);
             em.merge(vDetails);
    	}
        return vehicleDetails;
    }

    
    public void deleteDetails(VehicleDetails vehicleDetails) {

        em.remove(vehicleDetails);
    }
}
