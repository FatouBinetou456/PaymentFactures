package sn.fbd.PaymentFacture.config.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.fbd.PaymentFacture.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final ServiceRepository serviceRepository;
    private final AgencyRepository agencyRepository;

    @Autowired
    public AdminController(AgencyRepository agencyRepository, ServiceRepository serviceRepository) {
        this.agencyRepository = agencyRepository;
        this.serviceRepository = serviceRepository;
    }

    @GetMapping("/{entityName}")
    public Map<String, Object> adminInterface(@PathVariable String entityName) {
        BusinessService businessService = serviceRepository.findByServiceName(entityName);
        List<Agency> businessAgencies = agencyRepository.findByBusinessService(businessService);
        List<Ticket> myBusinessTickets = businessAgencies.stream()
                .map(Agency::getTicket)
                .collect(Collectors.toList());

        Map<String, Object> response = new HashMap<>();
        response.put("myBusinessTickets", myBusinessTickets);
        response.put("entityName", entityName);

        return response;
    }
}
