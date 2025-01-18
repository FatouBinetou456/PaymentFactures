package sn.fbd.PaymentFacture.config.controllers;


import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import sn.fbd.PaymentFacture.*;

import java.util.Optional;

@Controller
public class AgencyController {

    private final TicketRepository ticketRepository;
    private final AgencyRepository agencyRepository;
    private final ServiceRepository serviceRepository;

    @Autowired
    public AgencyController(TicketRepository ticketRepository,AgencyRepository agencyRepository,ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
        this.agencyRepository = agencyRepository;
        this.ticketRepository = ticketRepository;
    }

//    public String getAgencyPage(){
    @GetMapping("/{entityName}/{agencyName}")
    public String getAgencyPage(@PathVariable String entityName,
                                @PathVariable String agencyName, Model model,
                                HttpSession session) {

            BusinessService businessService = serviceRepository.findByServiceName(entityName);
            Agency agency = agencyRepository.findByLocationAndBusinessService(agencyName, businessService);
            Ticket ticket = ticketRepository.findTicketByAgency(agency);
            ticket.setCurrentNumber(ticket.getCurrentNumber() ); // Increment ticket number
            ticket.setQueueSize(ticket.getQueueSize() + 1);

            ticketRepository.save(ticket);

            int register=ticket.getRegisterNumber();
            int peopleAhead = ticket.getQueueSize() - 1;
            int currentNumber = ticket.getCurrentNumber() ;



        // Save the updated ticket


        model.addAttribute("entityName", entityName);
        model.addAttribute("agencyName", agencyName);
        model.addAttribute("eTicketNumber", currentNumber+peopleAhead);
        model.addAttribute("positionInQueue", peopleAhead+1);
        model.addAttribute("peopleAhead", peopleAhead);
        model.addAttribute("currentNumber", currentNumber);
        model.addAttribute("register", register);







        return "agencyPage";
    }
}
