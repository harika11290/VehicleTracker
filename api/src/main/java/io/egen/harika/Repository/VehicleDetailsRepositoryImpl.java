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
    @Override
    public List<VehicleDetails> findAllVehicles() {
        TypedQuery<VehicleDetails> query = em.createNamedQuery("VehicleDetails.findAll", VehicleDetails.class);
        return query.getResultList();
    }

    @Override
    public VehicleDetails findVehicle(String vin) {
        return em.find(VehicleDetails.class,vin);
    }

    @Override
    public VehicleDetails findVehicleByVIN(String vin) {
        TypedQuery<VehicleDetails> query = em.createNamedQuery("VehicleDetails.findByVIN", VehicleDetails.class);
        query.setParameter("vIN", vin);
        List<VehicleDetails> resultList = query.getResultList();

        if (resultList != null && resultList.size() == 1) {
            return resultList.get(0);
        } else {
            return null;
        }
    }

    @Override
    public VehicleDetails addVehicleDetails(VehicleDetails vehicleDetails) {
        em.persist(vehicleDetails);
        return vehicleDetails;
    }

    @Override
    public VehicleDetails updateVehicleDetails(VehicleDetails vehicleDetails) {
       return em.merge(vehicleDetails);
    }

    @Override
    public void deleteDetails(VehicleDetails vehicleDetails) {
        em.remove(vehicleDetails);
    }
}
