package sn.fbd.PaymentFacture.config.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sn.fbd.PaymentFacture.BusinessService;
import sn.fbd.PaymentFacture.ServiceRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/home")
public class HomeController {

        private final ServiceRepository serviceRepository;

        @Autowired
        public HomeController(ServiceRepository serviceRepository) {
            this.serviceRepository = serviceRepository;
        }

        @GetMapping
        public List<BusinessService> getHome() {
            return serviceRepository.findAll()
                    .stream()
                    .collect(Collectors.toList());
        }


}
