package sn.fbd.PaymentFacture;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntityService {

    @Autowired
    private final ServiceRepository serviceRepository;


    @Autowired
    public EntityService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }


    public BusinessService getServiceByName(String serviceName) {
        return serviceRepository.findByServiceName(serviceName);

    }

    public List<BusinessService> getAllEntities() {
        return serviceRepository.findAll();
    }


}
