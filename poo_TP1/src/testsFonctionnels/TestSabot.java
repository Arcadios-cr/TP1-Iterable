package testsFonctionnels;

import cartes.JeuDeCartes;
import cartes.Carte;
import jeu.Sabot;

public class TestSabot {

    public static void main(String[] args) {

        JeuDeCartes jeuDeCartes = new JeuDeCartes();

        Sabot sabot = new Sabot(jeuDeCartes.getListeCarte());
        while (!sabot.estVide()) {
            System.out.println("Je pioche : " + sabot.piocher());
        }

        System.out.println("\nTest avec l'itérateur :");
        sabot = new Sabot(jeuDeCartes.getListeCarte());  
        for (Carte carte : sabot) {
            System.out.println("Carte avec itérateur : " + carte);
        }

        // Exceptions : ajouter une carte à un sabot plein et piocher une carte dans un sabot vide
        try {
            sabot.piocher();  // (sabot vide)
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
        }
    }
}
