package entities.restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Restaurant {

    private int id;
    private String nume;
    private String adresa;
    private List<FelMancare> felMancare;

    public Restaurant(){
        this.felMancare = new ArrayList<>();
    }

    public Restaurant(String nume, String adresa){
        this.nume = nume;
        this.adresa = adresa;
        this.felMancare = new ArrayList<>();
    }

    public Restaurant(int id, String nume, String adresa){
        this.id = id;
        this.nume = nume;
        this.adresa = adresa;
        this.felMancare = new ArrayList<>();
    }

    public Restaurant(String nume, String adresa, ArrayList<FelMancare> felMancare) {
        this.nume = nume;
        this.adresa = adresa;
        this.felMancare = felMancare;
    }

    public Restaurant(int id, String nume, String adresa, ArrayList<FelMancare> felMancare) {
        this.id = id;
        this.nume = nume;
        this.adresa = adresa;
        this.felMancare = felMancare;
    }

    public void adaugaFelMancare(FelMancare f) {
        if (f instanceof FelMancare)
            this.felMancare.add((FelMancare) f);
    }

    public void stergeFelMancare(FelMancare f) {
        if (f instanceof FelMancare)
            this.felMancare.remove((FelMancare) f);
    }

    public void vizualizareMeniu() {
        System.out.println("Meniu restaurant: " + this.getNume());
        for (FelMancare felMancare: this.felMancare) {
            System.out.println("->" +felMancare.getNume() + "-> " + felMancare.getPret() + " lei") ;
            System.out.println("ingrediente: " + felMancare.getIngrediente());
        }
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public void showRestaurant(Restaurant restaurant) {
        System.out.println(restaurant.getNume() + " - " + restaurant.getAdresa());
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != getClass()) return false;
        Restaurant restaurant = (Restaurant) o;
        return getId() == restaurant.getId() && Objects.equals(getNume(), restaurant.getNume()) && Objects.equals(getAdresa(), restaurant.getAdresa());
    }

    @Override
    public String toString() {
        return "Restaurantul " + this.getNume() + " se afla pe " + this.getAdresa();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNume(), getAdresa());
    }
}

