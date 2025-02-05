package sn.fbd.PaymentFacture;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Ticket implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name ="agencyId")
    @JsonIgnore
    private Agency agency;

    private int currentNumber;

    private int queueSize;

    private int registerNumber;

    // Constructors
    public Ticket() {}

    public Ticket(Agency agency, int currentNumber, int queueSize, int registerNumber) {

        this.agency = agency;
        this.queueSize = queueSize;
        this.currentNumber = currentNumber;
        this.registerNumber = registerNumber;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }



    public int getCurrentNumber() {
        return currentNumber;
    }

    public void setCurrentNumber(int currentNumber) {
        this.currentNumber = currentNumber;
    }
    @JsonIgnore
    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public int getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(int registerNumber) {
        this.registerNumber = registerNumber;
    }

    public int getQueueSize() {
        return queueSize;
    }

    public void setQueueSize(int queueSize) {
        this.queueSize = queueSize;
    }
}
