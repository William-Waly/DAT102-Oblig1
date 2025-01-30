package no.hvl.data102.filmarkiv.klient;

import no.hvl.data102.filmarkiv.impl.Sjanger;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Filmarkiv;

import java.util.Scanner;

public class Meny {
    private final Tekstgrensesnitt tekstgr;
    private final FilmarkivADT filmarkiv;

    public Meny(FilmarkivADT filmarkiv) {
        this.tekstgr = new Tekstgrensesnitt();
        this.filmarkiv = filmarkiv;
    }

    public void start() {
        leggTilTestdata(filmarkiv);
        Scanner scanner = new Scanner(System.in);
        boolean avslutt = false;

        while (!avslutt) {
            int valg = visHovedmeny(scanner);

            switch (valg) {
                case 1 -> tekstgr.leggTilFilm(filmarkiv);
                case 2 -> tekstgr.slettFilm(filmarkiv, scanner);
                case 3 -> tekstgr.skrivUtFilmDelstrengITittel(filmarkiv, scanner);
                case 4 -> tekstgr.skrivUtFilmProdusent(filmarkiv, scanner);
                case 5 -> tekstgr.skrivUtStatistikk(filmarkiv);
                case 6 -> tekstgr.visAlleFilmer(filmarkiv);
                case 0 -> {
                    avslutt = true;
                    System.out.println("Avslutter programmet.");
                }
                default -> System.out.println("Ugyldig valg, prøv igjen.");
            }
        }
        scanner.close();
    }

    private int visHovedmeny(Scanner scanner) {
        System.out.println("\nVelg en operasjon:");
        System.out.println("1: Legg til en ny film");
        System.out.println("2: Slett en film");
        System.out.println("3: Søk etter filmer basert på tittel");
        System.out.println("4: Søk etter filmer basert på produsent");
        System.out.println("5: Vis statistikk");
        System.out.println("6: Vis alle filmer");
        System.out.println("0: Avslutt");
        System.out.print("Ditt valg: ");
        return scanner.nextInt();
    }

    private void leggTilTestdata(FilmarkivADT arkiv) {
        arkiv.leggTilFilm(new Film(1, "Regissør 1", "Actionfilm 1", 2020, Sjanger.ACTION, "Studio 1"));
        arkiv.leggTilFilm(new Film(2, "Regissør 2", "Dramafilm 2", 2019, Sjanger.DRAMA, "Studio 2"));
        arkiv.leggTilFilm(new Film(3, "Regissør 3", "SciFi-film 3", 2021, Sjanger.SCIFI, "Studio 3"));
        arkiv.leggTilFilm(new Film(4, "Regissør 4", "Komifilm 4", 2018, Sjanger.COMEDY, "Studio 4"));
    }
}

