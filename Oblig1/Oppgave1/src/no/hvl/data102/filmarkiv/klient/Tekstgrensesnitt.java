package no.hvl.data102.filmarkiv.klient;

import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Sjanger;
import java.util.Scanner;

public class Tekstgrensesnitt {
	// Leser inn opplysninger om en film fra tastatur og returnere et Film-objekt
	public Film lesFilm() {
		Scanner input = new Scanner(System.in);
		System.out.println("Skriv inn filmnr: ");
		int filmnr = Integer.parseInt(input.nextLine());
		System.out.println("Skriv inn filmskaper: ");
		String filmskaper = input.nextLine();
		System.out.println("Skriv inn tittel: ");
		String tittel = input.nextLine();
		System.out.println("Skriv inn lanseringsår: ");
		int lansering = Integer.parseInt(input.nextLine());
		System.out.println("Skriv inn filmselskap: ");
		String filmselskap = input.nextLine();
		System.out.println("Skriv inn sjanger: ");
		Sjanger sjanger = Sjanger.valueOf(input.nextLine());
		input.close();
		
		Film film = new Film(filmnr, filmskaper, tittel, lansering, sjanger, filmselskap);
		return film;
	}

	// Skriver ut en film med alle opplysninger på skjerm (husk tekst for sjanger)
	public void skrivUtFilm(Film film) {
		if (film != null) {
			System.out.println("Filmnummer: " + film.getFilmnr());
			System.out.println("Filmskaper: " + film.getFilmskaper());
			System.out.println("Tittel: " + film.getTittel());
			System.out.println("Lanseringsår: " + film.getLansering());
			System.out.println("Sjanger: " + film.getSjanger());
			System.out.println("Filmselskap: " + film.getFilmselskap());
		} else {
			System.out.println("Ingen film å vise.");
		}

	}

	// Skriver ut alle filmer med en spesiell delstreng i tittelen
	public void skrivUtFilmDelstrengITittel(FilmarkivADT arkiv, String delstreng) {
		Film[] filmer = arkiv.soekTittel(delstreng);

		if (filmer.length > 0) {
			for (Film film : filmer) {
				skrivUtFilm(film);
				System.out.println();
			}
		} else {
			System.out.println("Ingen filmer funnet med delstreng i tittelen: " + delstreng);
		}

	}

	// Skriver ut alle Filmer av en produsent (produsent er delstreng)
	public void skrivUtFilmProdusent(FilmarkivADT arkiv, String delstreng) {
		Film[] filmer = arkiv.soekProdusent(delstreng);

		if (filmer.length > 0) {
			for (Film film : filmer) {
				skrivUtFilm(film);
				System.out.println();
			}
		} else {
			System.out.println("Ingen filmer funnet med produsent: " + delstreng);
		}

	}

	// Skriver ut en enkel statistikk som inneholder antall filmer totalt
	// og hvor mange det er i hver sjanger.
	public void skrivUtStatistikk(FilmarkivADT arkiv) {
		System.out.println("Antall filmer totalt: " + arkiv.antall());
		for (Sjanger sjanger : Sjanger.values()) {
			System.out.println("Antall filmer i sjangeren " + sjanger + ": " + arkiv.antall(sjanger));
		}

	}
	// osv ... andre metoder
}