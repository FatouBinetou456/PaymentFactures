package sn.fbd.PaymentFacture.config.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.fbd.PaymentFacture.QueueManager;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/agent")
public class AgentController {

    private final QueueManager queueManager;

    @Autowired
    public AgentController(QueueManager queueManager) {
        this.queueManager = queueManager;
    }

    @GetMapping("/{entityName}/{agencyName}")
    public Map<String, Object> agentInterface(@PathVariable String entityName, @PathVariable String agencyName) {
        int currentNumber = queueManager.getCurrentNumber(entityName, agencyName);
        int registerNumber = queueManager.getLastRegisterNumber(entityName, agencyName);
        int lastTicketNumber = queueManager.getLastTicketNumber(entityName, agencyName);

        Map<String, Object> response = new HashMap<>();
        response.put("entityName", entityName);
        response.put("agencyName", agencyName);
        response.put("currentNumber", currentNumber);
        response.put("registerNumber", registerNumber);
        response.put("lastTicketNumber", lastTicketNumber);

        return response;
    }

    @PostMapping("/{entityName}/{agencyName}/next")
    public void nextClient(@PathVariable String entityName, @PathVariable String agencyName) {
        queueManager.nextClient(entityName, agencyName);
    }

    @PostMapping("/{entityName}/{agencyName}/previous")
    public void previousClient(@PathVariable String entityName, @PathVariable String agencyName) {
        queueManager.previousClient(entityName, agencyName);
    }
}