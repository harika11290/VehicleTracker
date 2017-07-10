package io.egen.harika.Repository;



import io.egen.harika.Entity.AlertDetails;
import io.egen.harika.Entity.VehicleReadings;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class VehicleReadingsRespositoryImpl implements VehicleReadingsRepository{
    @PersistenceContext
    private EntityManager em;
    
    public List<VehicleReadings> findAllVehicles() {
        TypedQuery<VehicleReadings> query = em.createNamedQuery("VehicleReadings.findAll", VehicleReadings.class);
        return query.getResultList();
    }

    
    public List<VehicleReadings> findVehicleReadingsbyVin(String vin) {
    	TypedQuery<VehicleReadings> query = em.createNamedQuery("VehicleReadings.findByVIN", VehicleReadings.class);
        query.setParameter("Vin", vin);
    	return query.getResultList();
    }
 
    public Boolean checkifVehicleReadingsExists(String vin){
    	Boolean exists = false;
    	TypedQuery<VehicleReadings> query = em.createNamedQuery("VehicleReadings.findByVIN", VehicleReadings.class);
        query.setParameter("Vin", vin);
        List<VehicleReadings> resultList = query.getResultList();
        System.out.println("No of elemets found"+ resultList.size());
        if (resultList != null && resultList.size() >= 1) {
            exists = true;
        } 
        return exists;
    }
    
    public VehicleReadings addVehicleReadings(VehicleReadings vehicleReadings) {
    	
        em.persist(vehicleReadings);
        return vehicleReadings;
    }

    
    public VehicleReadings updateVehicleReadings(VehicleReadings vehicleReadings) {
        em.merge(vehicleReadings);
        return vehicleReadings;
    }

    
    public void delete(List<VehicleReadings> vReadings,List<AlertDetails> alerts) {
    	for(int i=0; i< vReadings.size();i++){
    		VehicleReadings vehicleReadings = vReadings.get(i);
    		 em.remove(vehicleReadings);
    	}
    	//To remove alert details of deleted vehicle readings
    	for(int i=0; i< alerts.size();i++){
    		AlertDetails alertDetails = alerts.get(i);
    		 em.remove(alertDetails);
    	}
       
    }
}
