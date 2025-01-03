package sn.fbd.PaymentFacture.config.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sn.fbd.PaymentFacture.EntitiesData;
import sn.fbd.PaymentFacture.Entity;

import java.util.ArrayList;
import java.util.List;

import static sn.fbd.PaymentFacture.EntitiesData.entities;

@Controller
@RequestMapping
public class HomeController {

    @RequestMapping
    public String home() {
        return "home";
    }


    @GetMapping
    public String getHome(Model model) {
        new EntitiesData();
//        if (EntitiesData.entities == null || EntitiesData.entities.isEmpty()) {
//            System.out.println("La liste des entités est vide ou non initialisée !");
//        }
//        else {
//
//            for (Entity entity : EntitiesData.entities) {
//                // Afficher manuellement les détails de chaque entité
//               System.out.println("Entity ID: " + entity.getEntityId());
//              System.out.println("Entity Name: " + entity.getEntityName());
//            }
//            }

        List<String> entityNames = new ArrayList<>();

        for (Entity entity : EntitiesData.entities) {
            entityNames.add(entity.getEntityName());
        }

        model.addAttribute("myEntities", entityNames);

        return "home";
    }


}

