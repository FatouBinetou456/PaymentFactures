package sn.fbd.PaymentFacture.config.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.fbd.PaymentFacture.*;
import sn.fbd.PaymentFacture.QueueManager;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/agency")
public class AgencyController {

    private final TicketRepository ticketRepository;
    private final AgencyRepository agencyRepository;
    private final ServiceRepository serviceRepository;
    private final QueueManager queueManager;

    @Autowired
    public AgencyController(TicketRepository ticketRepository, AgencyRepository agencyRepository, ServiceRepository serviceRepository, QueueManager queueManager) {
        this.serviceRepository = serviceRepository;
        this.agencyRepository = agencyRepository;
        this.ticketRepository = ticketRepository;
        this.queueManager = queueManager;
    }

    @GetMapping("/{entityName}/{agencyName}")
    public Map<String, Object> getAgencyPage(@PathVariable String entityName,
                                             @PathVariable String agencyName,
                                             HttpSession session) {

        BusinessService businessService = serviceRepository.findByServiceName(entityName);
        Agency agency = agencyRepository.findByLocationAndBusinessService(agencyName, businessService);
        Ticket ticket = ticketRepository.findTicketByAgency(agency);
//        ticket.setCurrentNumber(ticket.getCurrentNumber()); // Increment ticket number
//        ticket.setQueueSize(ticket.getQueueSize() + 1);

        ticketRepository.save(ticket);

        int register = ticket.getRegisterNumber();
        int peopleAhead = ticket.getQueueSize() - 1;
        int currentNumber = ticket.getCurrentNumber();

        Map<String, Object> response = new HashMap<>();
        response.put("entityName", entityName);
        response.put("agencyName", agencyName);
        response.put("eTicketNumber", currentNumber + peopleAhead);
        response.put("positionInQueue", peopleAhead + 1);
        response.put("peopleAhead", peopleAhead);
        response.put("currentNumber", currentNumber);
        response.put("register", register);

        return response;
    }

    @PostMapping("/{entityName}/{agencyName}/issue")
    public Map<String, Object> issueNewTicket(@PathVariable String entityName, @PathVariable String agencyName) {
        queueManager.issueNewTicket(entityName, agencyName);

        // Récupère les informations mises à jour
        int currentNumber = queueManager.getCurrentNumber(entityName, agencyName);
        int registerNumber = queueManager.getLastRegisterNumber(entityName, agencyName);
        int lastTicketNumber = queueManager.getLastTicketNumber(entityName, agencyName);

        // Retourne la réponse
        Map<String, Object> response = new HashMap<>();
        response.put("entityName", entityName);
        response.put("agencyName", agencyName);
        response.put("currentNumber", currentNumber);
        response.put("registerNumber", registerNumber);
        response.put("lastTicketNumber", lastTicketNumber);

        return response;
    }
}
