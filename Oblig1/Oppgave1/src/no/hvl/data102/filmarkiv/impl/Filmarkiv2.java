package no.hvl.data102.filmarkiv.impl;

import java.util.ArrayList;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT{

	private int antall;
	private LinearNode<Film> start;
	
	public Filmarkiv2() {
        this.antall = 0;
        this.start = null;
	}
	
	@Override
	public Film finnFilm(int nr) {
		LinearNode<Film> aktuell = start;
		
		
		while (aktuell != null) {
			if (aktuell.data.getFilmnr() == nr) {
				return aktuell.data;
			}
			aktuell = aktuell.neste;
		}
		return null;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		LinearNode<Film> nyNode = new LinearNode<>(nyFilm);
		nyNode.neste = start;
		start = nyNode;
		antall++;
		
	}

	@Override
	public boolean slettFilm(int filmnr) {
		LinearNode<Film> aktuell = start;
		LinearNode<Film> forrige = null;
		
		while (aktuell != null) {
			if (aktuell.data.getFilmnr() == filmnr) {
				if (forrige == null) {
					start = aktuell.neste;
				} else {
					forrige.neste = aktuell.neste;
				}
				antall--;
				return true;
			}
			forrige = aktuell;
			aktuell = aktuell.neste;
		}
		return false;
		
		
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		ArrayList<Film> treff = new ArrayList<>();
		LinearNode<Film> aktuell = start;
		
		while (aktuell != null) {
			if (aktuell.data.getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
				treff.add(aktuell.data);
			}
			aktuell = aktuell.neste;
		}
		return treff.toArray(new Film[0]);
	}

	@Override
	public Film[] soekProdusent(String delstreng) {
		ArrayList<Film> treff = new ArrayList<>();
		LinearNode<Film> aktuell = start;
		
		while (aktuell != null) {
			if (aktuell.data.getFilmskaper().toLowerCase().contains(delstreng.toLowerCase())) {
				treff.add(aktuell.data);
			}
			aktuell = aktuell.neste;
		}
		return treff.toArray(new Film[0]);
	}

	@Override
	public int antall(Sjanger sjanger) {
		int antFilmer = 0;
		LinearNode<Film> aktuell = start;
		
		for (int i = 0; i < antall; i++) {
			if (aktuell.data.getSjanger() == sjanger) {
				antFilmer++;
			}
			aktuell = aktuell.neste;
		}
		return antFilmer;
	}

	@Override
	public int antall() {
		return antall;
	}
	
}
