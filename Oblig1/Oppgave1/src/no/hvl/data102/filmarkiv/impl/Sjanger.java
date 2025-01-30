package no.hvl.data102.filmarkiv.impl;

public enum Sjanger {
    ACTION, DRAMA, COMEDY, HORROR, SCIFI, DOCUMENTARY;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
