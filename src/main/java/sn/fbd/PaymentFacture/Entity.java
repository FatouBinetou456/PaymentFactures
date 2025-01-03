package sn.fbd.PaymentFacture;

import java.util.List;

public class Entity {
    private Long entityId ;
    private String entityName;
    private List<Agency> agencies;


    public Entity(Long entityId, String entityName, List<Agency> agencies) {
        this.entityId = entityId;
        this.entityName = entityName;
        this.agencies = agencies;
    }



    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public List<Agency> getAgencies() {
        return agencies;
    }

    public void setAgencies(List<Agency> agencies) {
        this.agencies = agencies;
    }

}
