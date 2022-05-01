package services;

import entities.appDelivery.AppDelivery;
import entities.persoane.Client;
import entities.persoane.curier.Curier;
import entities.restaurant.Restaurant;

public class AppDeliveryServiceImpl implements AppDeliveryService{

    @Override
    public void adaugaClient(AppDelivery a, Client client) {
        a.adaugaClienti(client);
    }

    @Override
    public void eliminaClient(AppDelivery a, Client client) {
        a.eliminaClient(client);
    }

    @Override
    public void adaugaCurier(AppDelivery a, Curier curier) {
        a.adaugaCurier(curier);
    }

    @Override
    public void eliminaCurier(AppDelivery a, Curier curier) {
        a.eliminaCurier(curier);
    }

    @Override
    public void adaugaRestaurant(AppDelivery a, Restaurant restaurant) {
        a.adaugaRestaurant(restaurant);
    }

    @Override
    public void eliminaRestaurant(AppDelivery a, Restaurant restaurant) {
        a.eliminaRestaurant(restaurant);
    }

    @Override
    public void marireSalariu(AppDelivery a, Curier c, double marire) {
        a.marireSalariu(c,marire);
    }

}
