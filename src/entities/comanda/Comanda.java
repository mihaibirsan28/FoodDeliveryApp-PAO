package entities.comanda;

import entities.persoane.Client;
import entities.persoane.curier.Curier;
import entities.persoane.curier.CurierBiciclist;
import entities.persoane.curier.CurierSofer;
import entities.restaurant.Restaurant;

import java.util.*;

public class Comanda {

    private int id;
    private Client client;
    private Curier curier;
    private CurierSofer curierSofer;
    private CurierBiciclist curierBiciclist;
    private Restaurant restaurant;
    private Date plasareComanda;
    private double totalPlata;
    List<ComandaFelMancare> continutComanda;

    public Comanda() {
    }

    public Comanda(int id,Client client, Restaurant restaurant, Date plasareComanda, double totalPlata) {
        this.id = id;
        this.client = client;
        this.restaurant = restaurant;
        this.plasareComanda = plasareComanda;
        this.totalPlata = totalPlata;
        continutComanda = new ArrayList<>();
    }

    public Comanda(int id, Client client, Restaurant restaurant, CurierSofer curier, Date plasareComanda, double totalPlata) {
        this.id = id;
        this.client = client;
        this.restaurant = restaurant;
        this.curier = curier;
        this.plasareComanda = plasareComanda;
        this.totalPlata = totalPlata;
        continutComanda = new ArrayList<>();
        client.setComanda(this);
        curier.adaugaComanda(this);
    }

    public Comanda(int id, Client client, Restaurant restaurant, CurierBiciclist curier, Date plasareComanda, double totalPlata) {
        this.id = id;
        this.client = client;
        this.restaurant = restaurant;
        this.curier = curier;
        this.plasareComanda = plasareComanda;
        this.totalPlata = totalPlata;
        continutComanda = new ArrayList<>();
        client.setComanda(this);
        curier.adaugaComanda(this);
    }

    public void adaugaFelMancare(Restaurant restaurant, String nume, double pret) {
        ComandaFelMancare adaugaFelMancare = new ComandaFelMancare(restaurant, nume, pret);
        this.continutComanda.add(adaugaFelMancare);
        //this.totalPlata += pret;
    }

    public void afiseazaComanda() {
        System.out.println("Comanda contine:");
        for (ComandaFelMancare c : this.continutComanda) {
            System.out.println( "- " + c);
        }
        System.out.println("Pret total: " + this.totalPlata);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Curier getCurier() {
        return curier;
    }

    public void setCurier(Curier curier) {
        this.curier = curier;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Date getPlasareComanda() {
        return plasareComanda;
    }

    public void setPlasareComanda(Date plasareComanda) {
        this.plasareComanda = plasareComanda;
    }

    public double getTotalPlata() {
        return totalPlata;
    }

    public void setTotalPlata(double totalPlata) {
        this.totalPlata = totalPlata;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Comanda comanda = (Comanda) o;
        return getId() == comanda.getId() && getClient() == comanda.getClient() &&  getRestaurant() == comanda.getRestaurant() && getCurier() == comanda.getCurier() && Double.compare(getTotalPlata(), comanda.getTotalPlata()) == 0 && Objects.equals(getPlasareComanda(), comanda.getPlasareComanda());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getClient(),  getRestaurant(), getCurier(), getPlasareComanda(), getTotalPlata());
    }
}
