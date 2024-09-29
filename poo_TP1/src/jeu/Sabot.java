package jeu;

import cartes.Carte;
import cartes.JeuDeCartes;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Sabot implements Iterable<Carte> {
    private Carte[] cartes;
    private int nbCartes;

    public Sabot(Carte[] cartes) {
        this.cartes = cartes;
        this.nbCartes = cartes.length;
    }

    public boolean estVide() {
        return nbCartes == 0;
    }

    public Carte piocher() throws NoSuchElementException {
        if (estVide()) {
            throw new NoSuchElementException("Le sabot est vide");
        }
        return cartes[--nbCartes];
    }

    public void ajouterCarte(Carte carte) throws IllegalStateException {
        if (nbCartes >= cartes.length) {
            throw new IllegalStateException("Sabot plein");
        }
        cartes[nbCartes++] = carte;
    }

    @Override
    public Iterator<Carte> iterator() {
        return new Iterator<Carte>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < nbCartes;
            }

            @Override
            public Carte next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return cartes[index++];
            }

            @Override
            public void remove() {
                if (index == 0) {
                    throw new IllegalStateException("Rien à supprimer");
                }
                System.arraycopy(cartes, index, cartes, index - 1, nbCartes - index);
                nbCartes--;
                index--;
            }
        };
    }
}
