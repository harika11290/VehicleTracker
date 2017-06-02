package io.egen.harika.Repository;



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
    @Override
    public List<VehicleReadings> findAllVehicles() {
        TypedQuery<VehicleReadings> query = em.createNamedQuery("VehicleReadings.findAll", VehicleReadings.class);
        return query.getResultList();
    }

    @Override
    public VehicleReadings findVehicleReading(String vin) {
        return em.find(VehicleReadings.class,vin);
    }

    @Override
    public VehicleReadings addVehicleReadings(VehicleReadings vehicleReadings) {
        em.persist(vehicleReadings);
        return vehicleReadings;
    }

    @Override
    public VehicleReadings updateVehicleReadings(VehicleReadings vehicleReadings) {
        return em.merge(vehicleReadings);
    }

    @Override
    public void delete(VehicleReadings vehicleReadings) {
        em.remove(vehicleReadings);
    }
}
