package sn.fbd.PaymentFacture.config.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import sn.fbd.PaymentFacture.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
//@RequestMapping("/")
public class EntityController {


    private final ServiceRepository serviceRepository;

    @Autowired
    public EntityController(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @GetMapping("/{entityName}")
    public String getEntityDetails(@PathVariable String entityName, Model model) {
        // Récupérer l'entité depuis la base de données
        BusinessService entity = serviceRepository.findByServiceName(entityName);

        if (entity == null) {
            model.addAttribute("error", "Oups!! Le service que vous souhaitez visiter n'est pas disponible");
            return "ErrorPage";
        }

        // Extraire les noms des agences
        List<String> agencyNames = entity.getAgencies().stream()
                .map(Agency::getLocation)
                .collect(Collectors.toList());

        model.addAttribute("myEntity", entity.getServiceName());
        model.addAttribute("myAgencies", agencyNames);
        return "EntityPage";
    }


}
