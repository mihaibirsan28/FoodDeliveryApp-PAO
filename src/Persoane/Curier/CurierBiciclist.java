package Persoane.Curier;

import Comanda.Comanda;
import Persoane.Client;
import Restaurant.Restaurant;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.PriorityQueue;

public class CurierBiciclist extends Curier{

    private int id;
    private String CNP;
    private double salariu;
    private int nrComenzi=0;
    ArrayList<Comanda> comenzi;

    public CurierBiciclist() {
    }

    public CurierBiciclist(String nume, String prenume, String numarTelefon) {
        super(nume, prenume, numarTelefon);
    }

    public CurierBiciclist(int id, String nume, String prenume, String numarTelefon, String cnp, double salariu) {
        super(nume, prenume, numarTelefon);
        this.id = id;
        this.CNP = cnp;
        this.salariu = salariu;
        this.comenzi = new ArrayList<>();
    }

    public void adaugaComanda(Comanda comanda) {
        //Comanda comanda = new Comanda(id, client, restaurant, this, plasareComanda, totalPlata);
        this.comenzi.add(comanda);
        this.nrComenzi += 1;
    }

    public void afisareNrComenziEfectuare() {
        System.out.println("Curierul " + this.getNume() + " " + this.getPrenume() + " a efecutat " + this.nrComenzi + " comenzi");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public double getSalariu() {
        return salariu;
    }

    public void setSalariu(double salariu) {
        this.salariu = salariu;
    }

    public void afisareComenziEfectuate() {
        System.out.println("Curierul " + this.getNumeComplet() + " a efectuat urmatoarele comenzi;");
        int k=1;
        for (Comanda c : this.comenzi) {
            System.out.println("Comanda " + k + ":");
            c.afiseazaComanda();
            k++;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;
        CurierBiciclist curierBiciclist = (CurierBiciclist) o;
        return Objects.equals(getCNP(), curierBiciclist.getCNP());
    }
}
