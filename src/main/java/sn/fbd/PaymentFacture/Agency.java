package sn.fbd.PaymentFacture;


import jakarta.persistence.*;

@Entity
public class Agency {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long agencyId ;
    private String location ;
    private int numbRegisters ;
    @ManyToOne
    @JoinColumn(name="serviceId")
    private BusinessService businessService;

    @OneToOne(mappedBy = "agency", cascade = CascadeType.ALL)
    private Ticket ticket ;

    public Agency() {}

    public Agency( String location, int numbRegisters, BusinessService businessService) {

        this.businessService = businessService;
        this.location = location;
        this.numbRegisters = numbRegisters;
    }


    public Long getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(Long agencyId) {
        this.agencyId = agencyId;
    }


    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
        ticket.setAgency(this);
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNumbRegisters() {
        return numbRegisters;
    }

    public void setNumbRegisters(int numbRegisters) {
        this.numbRegisters = numbRegisters;
    }

    public BusinessService getBusinessService() {
        return businessService;
    }

    public void setBusinessService(BusinessService businessService) {
        this.businessService = businessService;
    }
}
