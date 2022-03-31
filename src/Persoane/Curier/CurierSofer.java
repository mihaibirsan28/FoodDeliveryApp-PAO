package Persoane.Curier;

import Comanda.Comanda;
import Persoane.Client;
import Restaurant.Restaurant;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.PriorityQueue;

public class CurierSofer extends Curier{

    private int id;
    private String CNP;
    private String permisAuto;
    private double salariu;
    private int nrComenzi=0;
    ArrayList<Comanda> comenzi;

    public CurierSofer() {
    }

    public CurierSofer(String nume, String prenume, String numarTelefon) {
        super(nume, prenume, numarTelefon);
    }

    public CurierSofer(int id,String nume, String prenume, String numarTelefon, String cnp, String permisAuto, double salariu) {
        super(nume, prenume, numarTelefon);
        this.id = id;
        this.CNP = cnp;
        this.permisAuto = permisAuto;
        this.salariu = salariu;
        this.comenzi = new ArrayList<>();
    }

    public void adaugaComanda(Comanda comanda) {
        //Comanda comanda = new Comanda(id, client, restaurant, plasareComanda, totalPlata);
        this.comenzi.add(comanda);
        this.nrComenzi += 1;
    }

//    public void eliminaComanda() {
//        this.comenzi.remove();
//    }

    public void afisareComenziEfectuate() {
        System.out.println("Curierul " + this.getNumeComplet() + " a efectuat urmatoarele comenzi;");
        int k=1;
        for (Comanda c : this.comenzi) {
            System.out.println("Comanda " + k + ":");
            c.afiseazaComanda();
            k++;
        }
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

    public String getPermisAuto() {
        return permisAuto;
    }

    public void setPermisAuto(String permisAuto) {
        this.permisAuto = permisAuto;
    }

    public double getSalariu() {
        return salariu;
    }

    public void setSalariu(double salariu) {
        this.salariu = salariu;
    }

    public int getNrComenzi() {
        return nrComenzi;
    }

    public void setNrComenzi(int nrComenzi) {
        this.nrComenzi = nrComenzi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o)) return false;
        CurierSofer curierSofer = (CurierSofer) o;
        return Objects.equals(getCNP(), curierSofer.getCNP()) && Objects.equals(getPermisAuto(), curierSofer.getPermisAuto());
    }

    @Override
    public String toString() {
        return "Curierul" + getNumeComplet() +
                " (CNP: " + CNP + ") " +
                " detine permis de conducere pentru " + getPermisAuto() + " ,are un salariu de" +
                getSalariu() + " lei ." +
                " Pana in momentul de fata a efectuate " + nrComenzi + " comenzi.";
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCNP(), getPermisAuto());
    }
}
