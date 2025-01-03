package sn.fbd.PaymentFacture;

import java.util.ArrayList;
import java.util.List;

public class EntitiesData {

    // Agencies
    public static Agency agency1 = new Agency(1L, "Dakar Plateau", 5);
    public static Agency agency2 = new Agency(2L, "Medina", 4);
    public static Agency agency3 = new Agency(3L, "Parcelles Assainies", 6);
    public static Agency agency4 = new Agency(4L, "Ouakam", 7);
    public static Agency agency5 = new Agency(5L, "Ngor", 3);

    public static Agency agency6 = new Agency(6L, "Hann Bel-Air", 5);
    public static Agency agency7 = new Agency(7L, "Mermoz", 5);
    public static Agency agency8 = new Agency(8L, "Grand Yoff", 6);
    public static Agency agency9 = new Agency(9L, "Yoff", 7);
    public static Agency agency10 = new Agency(10L, "Sicap Baobab", 3);

    public static Agency agency11 = new Agency(11L, "Cambérène", 5);
    public static Agency agency12 = new Agency(12L, "Fann-Point E", 4);
    public static Agency agency13 = new Agency(13L, "Colobane", 6);
    public static Agency agency14 = new Agency(14L, "Guédiawaye", 7);
    public static Agency agency15 = new Agency(15L, "Rufisque", 3);

    public static Agency agency16 = new Agency(16L, "Keur Massar", 8);
    public static Agency agency17 = new Agency(17L, "Pikine", 4);
    public static Agency agency18 = new Agency(18L, "Malika", 6);
    public static Agency agency19 = new Agency(19L, "Tivaouane Peulh", 7);
    public static Agency agency20 = new Agency(20L, "Diamniadio", 3);

    // Entities
    public static Entity orange = new Entity(1L, "Orange", List.of(agency1, agency2, agency3, agency4, agency5));
    public static Entity senelec = new Entity(2L, "Senelec", List.of(agency6, agency7, agency8, agency9, agency10));
    public static Entity senEau = new Entity(3L, "SenEau", List.of(agency11, agency12, agency13, agency14, agency15));
    public static Entity fBank = new Entity(4L, "FBank", List.of(agency16, agency17, agency18, agency19, agency20));

    // Static list of entities
    public static List<Entity> entities;

    // Static block to initialize the list
    static {
        entities = new ArrayList<>();
    }

    // Constructor to populate the entities list
    public EntitiesData() {
        entities.add(orange);
        entities.add(senelec);
        entities.add(senEau);
        entities.add(fBank);
    }
    // Getters and setters
    public List<Entity> getEntities() {
        return entities;
    }

    public void setEntities(List<Entity> entities) {
        EntitiesData.entities = entities;
    }


}
