package Restaurant;

import java.util.Objects;

public class FelMancare {

    //private int id;
    //private Restaurant restaurant;
    private String nume;
    private double pret;
    private String ingrediente;

    public FelMancare() {
    }

//    public FelMancare( String nume, double pret, String ingrediente) {
//        //this.restaurant = restaurant;
//        this.nume = nume;
//        this.pret = pret;
//        this.ingrediente = ingrediente;
//    }

    public FelMancare(String nume, double pret, String ingrediente) {
        //this.id = id;
        //this.restaurant = restaurant;
        this.nume = nume;
        this.pret = pret;
        this.ingrediente = ingrediente;
    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public Restaurant getRestaurant() {
//        return restaurant;
//    }
//
//    public void setRestaurant(Restaurant restaurant) {
//        this.restaurant = restaurant;
//    }

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

    public String getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(String ingrediente) {
        this.ingrediente = ingrediente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FelMancare felMancare = (FelMancare) o;
        return Double.compare(felMancare.getPret(), getPret()) == 0 && Objects.equals(getNume(), felMancare.getNume()) && Objects.equals(getIngrediente(), felMancare.getIngrediente());
        //getId() == felMancare.getId() && getRestaurant() == felMancare.getRestaurant()
    }

    @Override
    public int hashCode() {
        return Objects.hash( getNume(), getPret(), getIngrediente());
    }
}