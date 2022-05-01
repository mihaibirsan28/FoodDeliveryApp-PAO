package entities.persoane;


import entities.comanda.Comanda;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Client extends Persoana {

    private int id;
    private String adresa;
    private Comanda comanda;
    private List<Comanda> comenzi;

    public Client() {
    }

    public Client(String nume, String prenume, String numarTelefon) {
        super(nume, prenume, numarTelefon);

    }

    public Client(int id, String nume, String prenume, String numarTelefon, String adresa) {
        super(nume, prenume, numarTelefon);
        this.id = id;
        this.adresa = adresa;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Comanda getComanda() {
        return comanda;
    }

    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }

    public String getNumeComplet() {
        return this.getNume() + " " + this.getPrenume();
    }

    public void afiseazaComanda() {
        if (this.comanda == null) {
            System.out.println("Clientul " + this.getNumeComplet() + " nu a comandat nimic!");
            return;
        }
        System.out.println("Clientul  " + this.getNumeComplet() + " are o comanda in valoare de: " + this.comanda.getTotalPlata());
        this.comanda.afiseazaComanda();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass());
        Client client = (Client) o;
        return getId() == client.getId() && Objects.equals(getAdresa(), client.getAdresa());
    }

    @Override
    public String toString() {
        return "Clientul " +
                this.getNumeComplet() +
                ", cu adresa: " + this.getAdresa() + '\'' +
                " si numarul de telefon: " + this.getNumarTelefon();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAdresa());
    }
}
