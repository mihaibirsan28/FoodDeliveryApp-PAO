package entities.persoane.curier;

import entities.persoane.Persoana;

public abstract class Curier extends Persoana {

    private String CNP;
    //private double salariu;

    Curier() {
    }

    Curier(String nume, String prenume, String numarTelefon) {
        super(nume, prenume, numarTelefon);
    }

}
