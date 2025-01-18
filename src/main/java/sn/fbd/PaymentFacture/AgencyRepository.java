package sn.fbd.PaymentFacture;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AgencyRepository extends JpaRepository<Agency, Long> {


    Optional<Agency> findByLocation(String location);

    Agency findByLocationAndBusinessService(String location, BusinessService businessService);
    List<Agency> findAll();
    List<Agency> findByBusinessService(BusinessService businessService);
}
