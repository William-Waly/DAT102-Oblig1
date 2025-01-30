package no.hvl.data102.filmarkiv.test;

import static org.junit.jupiter.api.Assertions.*;

import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Filmarkiv;
import no.hvl.data102.filmarkiv.impl.Sjanger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FilmarkivTest {

    private Filmarkiv arkiv;

    @BeforeEach
    void setUp() {
        arkiv = new Filmarkiv();

        // Legg til noen filmer for testing
        arkiv.leggTilFilm(new Film(1, "Christopher Nolan", "Inception", 2010, Sjanger.SCIFI, "Warner Bros"));
        arkiv.leggTilFilm(new Film(2, "Quentin Tarantino", "Pulp Fiction", 1994, Sjanger.DRAMA, "Miramax"));
        arkiv.leggTilFilm(new Film(3, "James Cameron", "Avatar", 2009, Sjanger.SCIFI, "20th Century Fox"));
        arkiv.leggTilFilm(new Film(4, "Peter Jackson", "The Lord of the Rings", 2001, Sjanger.ACTION, "New Line Cinema"));
    }

    @Test
    void testFinnFilm() {
        Film film = arkiv.finnFilm(1);
        assertNotNull(film, "Filmen med nummer 1 skal finnes");
        assertEquals("Inception", film.getTittel(), "Tittelen på filmen med nummer 1 skal være 'Inception'");
    }

    @Test
    void testLeggTilFilm() {
       int antallFør = arkiv.antall();
       arkiv.leggTilFilm(new Film(5, "Steven Spielberg", "Jurassic Park", 1993, Sjanger.ACTION, "Universal Pictures"));
       assertEquals(antallFør + 1, arkiv.antall(), "Antall filmer skal øke med 1 etter å ha lagt til en film");
    }

    @Test
    void testSlettFilm() {
        boolean slettet = arkiv.slettFilm(2);
        assertTrue(slettet, "Filmen med nummer 2 skal slettes");
        assertNull(arkiv.finnFilm(2), "Filmen med nummer 2 skal ikke finnes etter sletting");
        assertFalse(arkiv.slettFilm(99), "Sletting av en film som ikke finnes skal returnere false");
    }

    @Test
    void testSoekTittel() {
        Film[] treff = arkiv.soekTittel("Inception");
        assertEquals(1, treff.length, "Søket etter 'Inception' skal gi ett treff");
        assertEquals("Inception", treff[0].getTittel(), "Filmen som blir funnet skal ha tittelen 'Inception'");

        Film[] ingenTreff = arkiv.soekTittel("Ukjent");
        assertEquals(0, ingenTreff.length, "Søket etter 'Ukjent' skal gi null treff");
    }

    @Test
    void testSoekProdusent() {
        Film[] treff = arkiv.soekProdusent("Christopher Nolan");
        assertEquals(1, treff.length, "Søket etter 'Christopher Nolan' skal gi ett treff");
        assertEquals("Inception", treff[0].getTittel(), "Filmen som blir funnet skal ha tittelen 'Inception'");
    }

    @Test
    void testAntall() {
        assertEquals(4, arkiv.antall(), "Totalt antall filmer i arkivet skal være 4");
    }

    @Test
    void testAntallMedSjanger() {
        int antallSciFi = arkiv.antall(Sjanger.SCIFI);
        assertEquals(2, antallSciFi, "Det skal være 2 filmer av sjangeren 'SCIFI' i arkivet");

        int antallDrama = arkiv.antall(Sjanger.DRAMA);
        assertEquals(1, antallDrama, "Det skal være 1 film av sjangeren 'DRAMA' i arkivet");

        int antallComedy = arkiv.antall(Sjanger.COMEDY);
        assertEquals(0, antallComedy, "Det skal være 0 filmer av sjangeren 'COMEDY' i arkivet");
    }
}
