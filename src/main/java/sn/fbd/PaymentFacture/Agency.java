package sn.fbd.PaymentFacture;

public class Agency {
    private Long agencyId ;
    private String location ;
    private int numbRegisters ;

    public Agency(Long agencyId, String location, int numbRegisters) {
        this.agencyId = agencyId;
        this.location = location;
        this.numbRegisters = numbRegisters;
    }


    public Long getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(Long agencyId) {
        this.agencyId = agencyId;
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
}
