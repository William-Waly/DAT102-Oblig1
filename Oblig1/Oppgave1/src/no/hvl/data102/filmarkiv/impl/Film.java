package no.hvl.data102.filmarkiv.impl;

import java.util.Objects;

public class Film {
	private int filmnr;
	private String filmskaper;
	private String tittel;
	private int lansering;
	private String filmselskap;
	private Sjanger sjanger;
	
	public Film() {
		
	}
	
	public Film(int filmnr, String filmskaper, String tittel, int lansering, Sjanger sjanger, String filmselskap) {
	this.filmnr = filmnr;
	this.filmskaper = filmskaper;
	this.tittel = tittel;
	this.lansering = lansering;
	this.filmselskap = filmselskap;
	this.sjanger = sjanger;
	}
	
	public int getFilmnr() {
		return filmnr;
	}

	public void setFilmnr(int filmnr) {
		this.filmnr = filmnr;
	}

	public String getFilmskaper() {
		return filmskaper;
	}

	public void setFilmskaper(String filmskaper) {
		this.filmskaper = filmskaper;
	}

	public String getTittel() {
		return tittel;
	}

	public void setTittel(String tittel) {
		this.tittel = tittel;
	}

	public int getLansering() {
		return lansering;
	}

	public void setLansering(int lansering) {
		this.lansering = lansering;
	}

	public Sjanger getSjanger() {
		return sjanger;
	}

	public void setSjanger(Sjanger sjanger) {
		this.sjanger = sjanger;
	}

	public String getFilmselskap() {
		return filmselskap;
	}

	public void setFilmselskap(String filmselskap) {
		this.filmselskap = filmselskap;
	}

	@Override
	public int hashCode() {
		return Objects.hash(filmnr, filmselskap, filmskaper, lansering, sjanger, tittel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return filmnr == other.filmnr && Objects.equals(filmselskap, other.filmselskap)
				&& Objects.equals(filmskaper, other.filmskaper) && lansering == other.lansering
				&& sjanger == other.sjanger && Objects.equals(tittel, other.tittel);
	}

	
}