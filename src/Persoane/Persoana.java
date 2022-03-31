package Persoane;

import java.util.Objects;

public abstract class Persoana {

    private String nume;
    private String prenume;
    private String numarTelefon;


    public Persoana() {
    }

    public Persoana(String nume, String prenume, String numarTelefon) {
        this.nume = nume;
        this.prenume = prenume;
        this.numarTelefon = numarTelefon;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getNumeComplet() {
        return nume + " " + prenume;
    }

    public String getNumarTelefon() {
        return numarTelefon;
    }

    public void setNumarTelefon(String numarTelefon) {
        this.numarTelefon = numarTelefon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Persoana persoana = (Persoana) o;
        return Objects.equals(getNume(), persoana.getNume()) && Objects.equals(getPrenume(), persoana.getPrenume()) && Objects.equals(getNumarTelefon(), persoana.getNumarTelefon());
    }

    @Override
    public  int hashCode() {
        return Objects.hash(getNume(), getPrenume(), getNumarTelefon());
    }
}
