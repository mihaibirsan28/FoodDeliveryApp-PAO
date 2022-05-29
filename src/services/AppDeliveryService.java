package services;

import entities.appDelivery.AppDelivery;
import entities.persoane.Client;
import entities.persoane.curier.Curier;
import entities.restaurant.Restaurant;
import inout.Audit;

public interface AppDeliveryService {

    Audit audit = Audit.getInstance();
    void adaugaClient(AppDelivery a, Client client);
    void eliminaClient(AppDelivery a, Client client);
    void adaugaCurier(AppDelivery a, Curier curier);
    void eliminaCurier(AppDelivery a, Curier curier);
    void adaugaRestaurant(AppDelivery a, Restaurant restaurant);
    void eliminaRestaurant(AppDelivery a, Restaurant restaurant);
    void marireSalariu(AppDelivery a, Curier c, double marire);

}
