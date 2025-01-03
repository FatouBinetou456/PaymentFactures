package sn.fbd.PaymentFacture;

import java.util.HashMap;
import java.util.Map;

public class QueueManager {

    // Map associant les agences à leur numéro en cours de traitement
    private static final Map<String, Integer> currentNumberMap = new HashMap<>();

    // Initialisation des files d’attente pour les agences
    static {
        currentNumberMap.put("Senelec", 1);
        currentNumberMap.put("Orange", 1);
        currentNumberMap.put("SenEau", 1);
        currentNumberMap.put("FBank", 1);
    }

    // Récupérer le numéro en cours pour une agence
    public static int getCurrentNumber(String agencyName) {
        return currentNumberMap.getOrDefault(agencyName, 1);
    }

    // Passer au client suivant
    public static void nextClient(String agencyName) {
        currentNumberMap.put(agencyName, currentNumberMap.getOrDefault(agencyName, 1) + 1);
    }

    // Revenir au client précédent
    public static void previousClient(String agencyName) {
        currentNumberMap.put(agencyName, Math.max(1, currentNumberMap.getOrDefault(agencyName, 1) - 1));
    }

}
