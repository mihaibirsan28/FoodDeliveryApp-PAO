package entities.restaurant;

import java.util.Objects;

public class FelMancare {
    private int id;
    private String nume;
    private double pret;
    private String ingrediente;

    public FelMancare() {
    }


    public FelMancare(String nume, double pret, String ingrediente) {
        this.nume = nume;
        this.pret = pret;
        this.ingrediente = ingrediente;
    }

    public FelMancare(int id, String nume, double pret, String ingrediente) {
        this.id = id;
        this.nume = nume;
        this.pret = pret;
        this.ingrediente = ingrediente;
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
        if (!(o instanceof FelMancare)) return false;
        FelMancare that = (FelMancare) o;
        return getId() == that.getId() && Double.compare(that.getPret(), getPret()) == 0 && Objects.equals(getNume(), that.getNume()) && Objects.equals(getIngrediente(), that.getIngrediente());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNume(), getPret(), getIngrediente());
    }
}
