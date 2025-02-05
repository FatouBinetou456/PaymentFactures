package sn.fbd.PaymentFacture;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
public class BusinessService implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long serviceId;
    private String serviceName;

    @OneToMany(mappedBy = "businessService",cascade = CascadeType.ALL)
    private List<Agency> agencies;


    public BusinessService(String serviceName) {

        this.serviceName = serviceName;

    }

    public BusinessService() {}

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public List<Agency> getAgencies() {
        return agencies;
    }

    public void setAgencies(List<Agency> agencies) {
        this.agencies = agencies;
    }

}
