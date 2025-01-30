package no.hvl.data102.filmarkiv.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Filmarkiv2;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class Filmarkiv2Test {

    private Filmarkiv2 filmarkiv;

    @BeforeEach
    public void setup() {
        filmarkiv = new Filmarkiv2();
        filmarkiv.leggTilFilm(new Film(1, "Regissør 1", "Actionfilm 1", 2020, Sjanger.ACTION, "Studio 1"));
        filmarkiv.leggTilFilm(new Film(2, "Regissør 2", "Dramafilm 2", 2019, Sjanger.DRAMA, "Studio 2"));
        filmarkiv.leggTilFilm(new Film(3, "Regissør 3", "Komifilm 3", 2021, Sjanger.COMEDY, "Studio 3"));
    }

    @Test
    public void testLeggTilFilm() {
        Film nyFilm = new Film(4, "Regissør 4", "SciFi-film 4", 2022, Sjanger.SCIFI, "Studio 4");
        filmarkiv.leggTilFilm(nyFilm);
        assertEquals(4, filmarkiv.antall());
    }

    @Test
    public void testSlettFilm() {
        boolean slettet = filmarkiv.slettFilm(2);
        assertTrue(slettet);
        assertNull(filmarkiv.finnFilm(2));
        assertEquals(2, filmarkiv.antall());
    }

    @Test
    public void testFinnFilm() {
        Film film = filmarkiv.finnFilm(1);
        assertNotNull(film);
        assertEquals("Actionfilm 1", film.getTittel());
    }

    @Test
    public void testSoekTittel() {
        Film[] treff = filmarkiv.soekTittel("film");
        assertEquals(3, treff.length);
    }

    @Test
    public void testAntall() {
        assertEquals(1, filmarkiv.antall(Sjanger.ACTION));
        assertEquals(1, filmarkiv.antall(Sjanger.DRAMA));
        assertEquals(1, filmarkiv.antall(Sjanger.COMEDY));
    }
}