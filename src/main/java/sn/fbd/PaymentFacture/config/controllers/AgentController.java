package sn.fbd.PaymentFacture.config.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sn.fbd.PaymentFacture.QueueManager;

@Controller
@RequestMapping("/agent")

public class AgentController {

    // Afficher l'interface de l'agent pour une agence
    @GetMapping("/{entityName}/{agencyName}")
    public String agentInterface(@PathVariable String entityName, @PathVariable String agencyName, Model model) {
        // Récupérer le numéro en cours pour l'agence
        int currentNumber = QueueManager.getCurrentNumber(agencyName);

        // Ajouter les détails au modèle
        model.addAttribute("entityName", entityName);
        model.addAttribute("agencyName", agencyName);
        model.addAttribute("currentNumber", currentNumber);

        return "AgentInterface"; // Affiche l'interface JSP de l'agent
    }

    // Incrémenter le numéro (Client suivant)
    @PostMapping("/{entityName}/{agencyName}/next")
    public String nextClient(@PathVariable String entityName, @PathVariable String agencyName) {
        QueueManager.nextClient(agencyName);
        return "redirect:/agent/" + entityName + "/" + agencyName;
    }

    // Décrémenter le numéro (Client précédent)
    @PostMapping("/{entityName}/{agencyName}/previous")
    public String previousClient(@PathVariable String entityName, @PathVariable String agencyName) {
        QueueManager.previousClient(agencyName);
        return "redirect:/agent/" + entityName + "/" + agencyName;
    }
}
