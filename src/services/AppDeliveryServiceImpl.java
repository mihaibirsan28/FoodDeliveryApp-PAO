package services;

import entities.appDelivery.AppDelivery;
import entities.persoane.Client;
import entities.persoane.curier.Curier;
import entities.restaurant.Restaurant;

public class AppDeliveryServiceImpl implements AppDeliveryService{

    @Override
    public void adaugaClient(AppDelivery a, Client client) {
        a.adaugaClienti(client);
        audit.scrieAudit("adaugaClient");
    }

    @Override
    public void eliminaClient(AppDelivery a, Client client) {
        a.eliminaClient(client);
        audit.scrieAudit("eliminaClient");
    }

    @Override
    public void adaugaCurier(AppDelivery a, Curier curier) {
        a.adaugaCurier(curier);
        audit.scrieAudit("adaugaCurier");
    }

    @Override
    public void eliminaCurier(AppDelivery a, Curier curier) {
        a.eliminaCurier(curier);
        audit.scrieAudit("eliminaCurier");
    }

    @Override
    public void adaugaRestaurant(AppDelivery a, Restaurant restaurant) {
        a.adaugaRestaurant(restaurant);
        audit.scrieAudit("adaugaRestaurant");
    }

    @Override
    public void eliminaRestaurant(AppDelivery a, Restaurant restaurant) {
        a.eliminaRestaurant(restaurant);
        audit.scrieAudit("eliminaRestaurant");
    }

    @Override
    public void marireSalariu(AppDelivery a, Curier c, double marire) {
        a.marireSalariu(c,marire);
        audit.scrieAudit("marireSalariu");
    }

}
