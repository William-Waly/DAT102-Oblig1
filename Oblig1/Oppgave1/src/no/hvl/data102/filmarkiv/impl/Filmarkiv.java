package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

import java.util.ArrayList;

public class Filmarkiv implements FilmarkivADT {
    private Film[] filmer;
    private int antall;

    private static final int STANDARD_STORRELSE = 100;

    // Konstruktører
    public Filmarkiv() {
        this(STANDARD_STORRELSE);
    }

    public Filmarkiv(int storrelse) {
        filmer = new Film[storrelse];
        antall = 0;
    }

    @Override
    public Film finnFilm(int nr) {
        for (int i = 0; i < antall; i++) {
            if (filmer[i].getFilmnr() == nr) {
                return filmer[i];
            }
        }
        return null;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        if (antall == filmer.length) {
            utvidKapasitet();
        }
        filmer[antall] = nyFilm;
        antall++;
    }

    @Override
    public boolean slettFilm(int filmnr) {
        for (int i = 0; i < antall; i++) {
            if (filmer[i].getFilmnr() == filmnr) {
                filmer[i] = filmer[antall - 1]; // Flytter siste element til denne plassen
                filmer[antall - 1] = null; // Nullstiller siste plass
                antall--;
                return true;
            }
        }
        return false;
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        ArrayList<Film> treff = new ArrayList<>();
        for (int i = 0; i < antall; i++) {
            if (filmer[i].getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
                treff.add(filmer[i]);
            }
        }
        return treff.toArray(new Film[0]);
    }

    @Override
    public Film[] soekProdusent(String delstreng) {
        ArrayList<Film> treff = new ArrayList<>();
        for (int i = 0; i < antall; i++) {
            if (filmer[i].getFilmskaper().toLowerCase().contains(delstreng.toLowerCase())) {
                treff.add(filmer[i]);
            }
        }
        return treff.toArray(new Film[0]);
    }

    @Override
    public int antall(Sjanger sjanger) {
        int teller = 0;
        for (int i = 0; i < antall; i++) {
            if (filmer[i].getSjanger() == sjanger) {
                teller++;
            }
        }
        return teller;
    }

    @Override
    public int antall() {
        return antall;
    }

    // Privat metode for å utvide kapasiteten til arrayet
    private void utvidKapasitet() {
        Film[] nyTabell = new Film[filmer.length * 2];
        System.arraycopy(filmer, 0, nyTabell, 0, filmer.length);
        filmer = nyTabell;
    }
}
