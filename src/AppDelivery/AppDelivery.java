package AppDelivery;

import Comanda.Comanda;
import Persoane.Client;
import Persoane.Curier.Curier;
import Persoane.Curier.CurierBiciclist;
import Persoane.Curier.CurierSofer;
import Restaurant.FelMancare;
import Restaurant.Restaurant;

import java.util.ArrayList;

public class AppDelivery {

    private ArrayList<Client> clienti;
    private ArrayList<CurierSofer> soferi;
    private ArrayList<CurierBiciclist> biciclisti;
    private ArrayList<Restaurant> restaurante;
    private ArrayList<Comanda> comenzi;

    public AppDelivery() {
        this.clienti = new ArrayList<>();
        this.soferi = new ArrayList<>();
        this.biciclisti = new ArrayList<>();
        this.restaurante = new ArrayList<>();
        this.comenzi = new ArrayList<>();
    }

    public AppDelivery(ArrayList<Client> clienti, ArrayList<CurierSofer> soferi, ArrayList<CurierBiciclist> biciclisti, ArrayList<Restaurant> restaurante, ArrayList<Comanda> comenzi) {
        this.clienti = clienti;
        this.soferi = soferi;
        this.biciclisti = biciclisti;
        this.restaurante = restaurante;
        this.comenzi = comenzi;
    }

    public void adaugaClienti(Client c) {
        if (c instanceof Client)
            this.clienti.add((Client) c);
    }

    public void eliminaClient(Client c) {
        if (c instanceof Client)
            this.clienti.remove((Client) c);
    }

    public void adaugaCurier(Curier c) {
        if (c instanceof CurierSofer)
            this.soferi.add((CurierSofer) c);
        if (c instanceof CurierBiciclist)
            this.biciclisti.add((CurierBiciclist) c);
    }

    public void eliminaCurier(Curier c) {
        if (c instanceof CurierSofer)
            this.soferi.remove((CurierSofer) c);
        if (c instanceof CurierBiciclist)
            this.biciclisti.remove((CurierBiciclist) c);
    }

    public void adaugaRestaurant(Restaurant r) {
        if (r instanceof Restaurant)
            this.restaurante.add((Restaurant) r);
    }

    public void eliminaRestaurant(Restaurant r) {
        if (r instanceof Restaurant)
            this.restaurante.remove((Restaurant) r);
    }

    public void adaugaComanda(Comanda comanda) {
        if (comanda instanceof Comanda)
            this.comenzi.add((Comanda) comanda);
    }

    public void eliminaComanda(Comanda comanda) {
        if (comanda instanceof Comanda)
            this.comenzi.remove((Comanda) comanda);
    }

    public void marireSalariu(Curier c, double marire) {
        if (c instanceof CurierSofer)
            ((CurierSofer) c).setSalariu(((CurierSofer) c).getSalariu() + marire);
        if (c instanceof CurierBiciclist)
            ((CurierBiciclist) c).setSalariu(((CurierBiciclist) c).getSalariu() + marire);
    }

//    public void vizualizareMeniu(Restaurant restaurant) {
//        for (FelMancare felMancare: this.)
//    }



}
