package sn.fbd.PaymentFacture.config.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import sn.fbd.PaymentFacture.Agency;

@Controller
public class AgencyController {



//    public String getAgencyPage(){
    @GetMapping("/{entityName}/{agencyName}")
    public String getAgencyPage(@PathVariable String entityName, @PathVariable String agencyName, Model model) {
        // Simulate retrieving the current queue status
        int eTicketNumber = (int) (Math.random() * 900) + 100;
        int positionInQueue = (int) (Math.random() * 50) + 1;
        int peopleAhead = positionInQueue - 1;
        int currentNumber = eTicketNumber - peopleAhead;


        // Add the details to the model
        model.addAttribute("entityName", entityName);
        model.addAttribute("agencyName", agencyName);
        model.addAttribute("eTicketNumber", eTicketNumber);
        model.addAttribute("positionInQueue", positionInQueue);
        model.addAttribute("peopleAhead", peopleAhead);
        model.addAttribute("currentNumber", currentNumber);



        return "agencyPage";
    }
}
