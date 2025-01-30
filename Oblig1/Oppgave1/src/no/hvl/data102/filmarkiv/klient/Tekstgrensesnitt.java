package no.hvl.data102.filmarkiv.klient;

import no.hvl.data102.filmarkiv.impl.Sjanger;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

import java.util.Scanner;

public class Tekstgrensesnitt {
    private final Scanner scanner = new Scanner(System.in);

    public void leggTilFilm(FilmarkivADT arkiv) {
        Film nyFilm = lesFilm();
        arkiv.leggTilFilm(nyFilm);
        System.out.println("Filmen er lagt til.");
    }

    public void slettFilm(FilmarkivADT arkiv, Scanner scanner) {
        System.out.print("Skriv inn filmnummeret til filmen du vil slette: ");
        int filmnr = scanner.nextInt();
        boolean slettet = arkiv.slettFilm(filmnr);
        System.out.println(slettet ? "Filmen ble slettet." : "Fant ingen film med dette nummeret.");
    }

    public void skrivUtFilmDelstrengITittel(FilmarkivADT arkiv, Scanner scanner) {
        System.out.print("Skriv inn en del av tittelen du vil søke etter: ");
        String delstreng = scanner.next();
        visFilmer(arkiv.soekTittel(delstreng));
    }

    public void skrivUtFilmProdusent(FilmarkivADT arkiv, Scanner scanner) {
        System.out.print("Skriv inn en produsent (eller del av navn): ");
        String produsent = scanner.next();
        visFilmer(arkiv.soekProdusent(produsent));
    }

    public void skrivUtStatistikk(FilmarkivADT arkiv) {
        System.out.println("Antall filmer totalt: " + arkiv.antall());
        for (Sjanger sjanger : Sjanger.values()) {
            System.out.println(sjanger + ": " + arkiv.antall(sjanger));
        }
    }

    public void visAlleFilmer(FilmarkivADT arkiv) {
        visFilmer(arkiv.soekTittel(""));
    }

    private Film lesFilm() {
        System.out.print("Filmnummer: ");
        int filmnr = scanner.nextInt();
        scanner.nextLine(); // Rydd opp etter tallinput

        System.out.print("Regissør: ");
        String regissor = scanner.nextLine();

        System.out.print("Tittel: ");
        String tittel = scanner.nextLine();

        System.out.print("Utgivelsesår: ");
        int utgivelsesår = scanner.nextInt();
        scanner.nextLine(); // Rydd opp etter tallinput

        System.out.print("Sjanger (ACTION, DRAMA, SCIFI, COMEDY): ");
        String sjangerStr = scanner.nextLine().toUpperCase();
        Sjanger sjanger = Sjanger.valueOf(sjangerStr);

        System.out.print("Filmselskap: ");
        String selskap = scanner.nextLine();

        return new Film(filmnr, regissor, tittel, utgivelsesår, sjanger, selskap);
    }

    private void visFilmer(Film[] filmer) {
        if (filmer.length == 0) {
            System.out.println("Ingen filmer funnet.");
        } else {
            for (Film film : filmer) {
                skrivUtFilm(film);
            }
        }
    }

    private void skrivUtFilm(Film film) {
        System.out.println("\nFilmnummer: " + film.getFilmnr());
        System.out.println("Regissør: " + film.getFilmskaper());
        System.out.println("Tittel: " + film.getTittel());
        System.out.println("Utgivelsesår: " + film.getLansering());
        System.out.println("Sjanger: " + film.getSjanger());
        System.out.println("Filmselskap: " + film.getFilmselskap());
    }
}
