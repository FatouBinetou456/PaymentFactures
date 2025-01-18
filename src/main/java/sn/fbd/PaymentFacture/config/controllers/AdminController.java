package sn.fbd.PaymentFacture.config.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import sn.fbd.PaymentFacture.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final ServiceRepository serviceRepository;
    private AgencyRepository agencyRepository;

    @Autowired
    public AdminController(AgencyRepository agencyRepository, ServiceRepository serviceRepository) {
        this.agencyRepository = agencyRepository;
        this.serviceRepository = serviceRepository;
    }

    @GetMapping("/{entityName}")
    public String adminInterface(@PathVariable String entityName, Model model) {
        BusinessService businessService=serviceRepository.findByServiceName(entityName);
        List<Agency> businessAgencies=agencyRepository.findByBusinessService(businessService);
        List<Ticket> myBusinessTickets=businessAgencies.stream()
                .map(agency -> agency.getTicket())
                .collect(Collectors.toList());


        model.addAttribute("myBusinessTickets", myBusinessTickets);
        model.addAttribute("entityName", entityName);



        return "AdminPage";
    }


}
