package sn.fbd.PaymentFacture;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ServiceRepository extends JpaRepository<BusinessService, Long> {
    BusinessService findByServiceName(String serviceName);
    List <BusinessService> findAll();
}