package sn.fbd.PaymentFacture.config.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import sn.fbd.PaymentFacture.Agency;
import sn.fbd.PaymentFacture.EntitiesData;

import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping("/")
public class EntityController {

    @RequestMapping("/Senelec")
    public String Senelec(Model model) {

        List<String> snlcAg = new ArrayList<>();

        // Iterate over the entities and add their names to the list
        for (Agency agency : EntitiesData.senelec.getAgencies()) {
            snlcAg.add(agency.getLocation());
        }

        model.addAttribute("myEntity", "Senelec");
        model.addAttribute("myAgencies", snlcAg);
        return "EntityPage";
    }

    @RequestMapping("/SenEau")
    public String SenEau(Model model) {

        List<String> snEauAg = new ArrayList<>();

        // Iterate over the entities and add their names to the list
        for (Agency agency : EntitiesData.senEau.getAgencies()) {
            snEauAg.add(agency.getLocation());
        }

        model.addAttribute("myEntity", "SenEau");
        model.addAttribute("myAgencies", snEauAg);
        return "EntityPage";
    }


    @RequestMapping("/Orange")
    public String Orange(Model model) {

        List<String> orngAg = new ArrayList<>();

        // Iterate over the entities and add their names to the list
        for (Agency agency : EntitiesData.orange.getAgencies()) {
            orngAg.add(agency.getLocation());
        }

        model.addAttribute("myEntity", "Orange");
        model.addAttribute("myAgencies", orngAg);
        return "EntityPage";
    }
    @RequestMapping("/FBank")
    public String FBank(Model model) {

        List<String> fbnkAg = new ArrayList<>();

        // Iterate over the entities and add their names to the list
        for (Agency agency : EntitiesData.fBank.getAgencies()) {
            fbnkAg.add(agency.getLocation());
        }

        model.addAttribute("myEntity", "FBank");
        model.addAttribute("myAgencies", fbnkAg);
        return "EntityPage";
    }
}
