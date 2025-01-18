package sn.fbd.PaymentFacture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QueueManager {

    private final TicketRepository ticketRepository;
    private final AgencyRepository agencyRepository;

    @Autowired
    public QueueManager(TicketRepository ticketRepository, AgencyRepository agencyRepository) {
        this.ticketRepository = ticketRepository;
        this.agencyRepository = agencyRepository;
    }


    public void nextClient(String businessService,String agencyName) {
        Optional<Agency> agencyOpt = agencyRepository.findByLocation(agencyName);

        if (agencyOpt.isPresent()) {
            Agency agency = agencyOpt.get();
            Ticket ticket = ticketRepository.findTicketByAgency(agency);

            if (ticket != null) {
                ticket.setCurrentNumber(ticket.getCurrentNumber() + 1);
                if (ticket.getRegisterNumber()==agency.getNumbRegisters()){
                    ticket.setRegisterNumber(1);

                }
                else {
                    ticket.setRegisterNumber(ticket.getRegisterNumber()+1);
                }
                ticketRepository.save(ticket);
            } else {
                throw new IllegalStateException("No ticket found for agency: " + agencyName);
            }
        } else {
            throw new IllegalStateException("No agency found with name: " + agencyName);
        }
    }
    public void previousClient(String businessService, String agencyName) {
        Optional<Agency> agencyOpt = agencyRepository.findByLocation(agencyName);

        if (agencyOpt.isPresent()) {
            Agency agency = agencyOpt.get();
            Ticket ticket = ticketRepository.findTicketByAgency(agency);

            if (ticket != null) {
                if (ticket.getCurrentNumber() > 100) {
                    ticket.setCurrentNumber(ticket.getCurrentNumber() - 1);
                    if (ticket.getRegisterNumber()==agency.getNumbRegisters()){
                        ticket.setRegisterNumber(1);

                    }
                    else {
                        ticket.setRegisterNumber(ticket.getRegisterNumber()+1);
                    }
                    ticketRepository.save(ticket);
                }
            } else {
                throw new IllegalStateException("No ticket found for agency: " + agencyName);
            }
        } else {
            throw new IllegalStateException("No agency found with name: " + agencyName);
        }
    }


    public int getCurrentNumber(String businessService, String agencyName) {
        Optional<Agency> agencyOpt = agencyRepository.findByLocation(agencyName);

        if (agencyOpt.isPresent()) {
            Agency agency = agencyOpt.get();
            Ticket ticket = ticketRepository.findTicketByAgency(agency);

            if (ticket != null) {
                return ticket.getCurrentNumber();
            } else {
                throw new IllegalStateException("No ticket found for agency: " + agencyName);
            }
        } else {
            throw new IllegalStateException("No agency found with name: " + agencyName);
        }
    }

    public int getLastRegisterNumber(String businessService, String agencyName) {
        Optional<Agency> agencyOpt = agencyRepository.findByLocation(agencyName);

        if (agencyOpt.isPresent()) {
            Agency agency = agencyOpt.get();
            Ticket ticket = ticketRepository.findTicketByAgency(agency);

            if (ticket != null) {
                return ticket.getRegisterNumber();
            } else {
                throw new IllegalStateException("No ticket found for agency: " + agencyName);
            }
        } else {
            throw new IllegalStateException("No agency found with name: " + agencyName);
        }
    }
}
