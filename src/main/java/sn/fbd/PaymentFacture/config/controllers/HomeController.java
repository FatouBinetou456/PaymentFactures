package sn.fbd.PaymentFacture.config.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sn.fbd.PaymentFacture.BusinessService;
import sn.fbd.PaymentFacture.ServiceRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping
public class HomeController {

    private ServiceRepository serviceRepository;

    @Autowired
    public HomeController(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }



    @RequestMapping
    public String home() {
        return "home";
    }


    @GetMapping
    public String getHome(Model model) {


        List<String> entityNames = serviceRepository.findAll()
                .stream()
                .map(BusinessService::getServiceName)
                .collect(Collectors.toList());

        model.addAttribute("myEntities", entityNames);

        return "home";
    }


}

