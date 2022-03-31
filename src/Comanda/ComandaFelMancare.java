package Comanda;

import Restaurant.Restaurant;

import java.util.Objects;

public class ComandaFelMancare {

    private Restaurant restaurant;
    private String nume;
    private double pret;

    public ComandaFelMancare() {
    }

    public ComandaFelMancare(Restaurant restaurant, String nume, double pret) {
        this.restaurant = restaurant;
        this.nume = nume;
        this.pret = pret;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    //    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        ComandaFelMancare comandaFelMancare = (ComandaFelMancare) o;
//        return getId() == comandaFelMancare.getId() && getIdComanda() == comandaFelMancare.getIdComanda() && getIdFelMancare() == comandaFelMancare.getIdFelMancare();
//    }
    @Override
    public String toString() {
        return this.getNume() + " -----> " + this.getPret();
    }


    @Override
    public int hashCode() {
        return Objects.hash(getNume(), getPret());
    }
}
