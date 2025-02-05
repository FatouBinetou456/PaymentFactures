package sn.fbd.PaymentFacture.config.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.fbd.PaymentFacture.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/entity")
public class EntityController {

    private final ServiceRepository serviceRepository;

    @Autowired
    public EntityController(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @GetMapping("/{entityName}")
    public Object getEntityDetails(@PathVariable String entityName) {
        BusinessService entity = serviceRepository.findByServiceName(entityName);

        if (entity == null) {
            return List.of("Oups!! Le service que vous souhaitez visiter n'est pas disponible");
        }

        List<String> agencyNames = entity.getAgencies().stream()
                .map(Agency::getLocation)
                .collect(Collectors.toList());

        return new EntityResponse(entity.getServiceName(), agencyNames);
    }

    //Permet de structurer la réponse JSON.

    private record EntityResponse(String serviceName, List<String> agencies) {}
}
