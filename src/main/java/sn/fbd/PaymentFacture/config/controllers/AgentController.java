package sn.fbd.PaymentFacture.config.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import sn.fbd.PaymentFacture.QueueManager;

@Controller
@RequestMapping("/agent")
public class AgentController {

    private final QueueManager queueManager;

    @Autowired
    public AgentController(QueueManager queueManager) {
        this.queueManager = queueManager;
    }

    @GetMapping("/{entityName}/{agencyName}")
    public String agentInterface(@PathVariable String entityName, @PathVariable String agencyName, Model model) {
        int currentNumber = queueManager.getCurrentNumber(entityName,agencyName);
        int registerNumber= queueManager.getLastRegisterNumber(entityName,agencyName);
        model.addAttribute("entityName", entityName);
        model.addAttribute("agencyName", agencyName);
        model.addAttribute("currentNumber", currentNumber);
        model.addAttribute("registerNumber", registerNumber);
        System.out.println("Current Number for " + agencyName + ": " + currentNumber);

        return "AgentInterface";
    }

    @PostMapping("/{entityName}/{agencyName}/next")
    public String nextClient(@PathVariable String entityName, @PathVariable String agencyName) {
        queueManager.nextClient(entityName,agencyName);
        return "redirect:/agent/" + entityName + "/" + agencyName;
    }

    @PostMapping("/{entityName}/{agencyName}/previous")
    public String previousClient(@PathVariable String entityName, @PathVariable String agencyName) {
        queueManager.previousClient(entityName,agencyName);
        return "redirect:/agent/" + entityName + "/" + agencyName;
    }
}
