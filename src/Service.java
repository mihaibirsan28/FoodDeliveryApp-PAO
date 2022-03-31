import AppDelivery.AppDelivery;
import Comanda.Comanda;
import Persoane.Client;
import Persoane.Curier.Curier;
import Persoane.Curier.CurierBiciclist;
import Persoane.Curier.CurierSofer;
import Restaurant.FelMancare;
import Restaurant.Restaurant;

import java.util.ArrayList;


public interface Service {

    void adaugaClient(AppDelivery a, Client client);
    void eliminaClient(AppDelivery a, Client client);
    void adaugaCurier(AppDelivery a, Curier curier);
    void eliminaCurier(AppDelivery a, Curier curier);
    void adaugaRestaurant(AppDelivery a, Restaurant restaurant);
    void eliminaRestaurant(AppDelivery a, Restaurant restaurant);
    void marireSalariu(AppDelivery a, Curier c, double marire);
    void afiseazaComanda(Client client);
    void afisareComenziEfectuate(CurierSofer curierSofer);
    void afisareComenziEfectuate(CurierBiciclist curierBiciclist);
    void adaugaFelMancare(Restaurant restaurant, FelMancare felMancare);
    void stergeFelMancare(Restaurant restaurant, FelMancare felMancare);
    void afisareNrComenziEfectuate(CurierSofer curierSofer);
    void afisareNrComenziEfectuate(CurierBiciclist curierBiciclist);
    void afiseazaComanda(Comanda comanda);
}
