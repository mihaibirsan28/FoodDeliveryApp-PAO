package services;

import entities.restaurant.FelMancare;
import entities.restaurant.Restaurant;

public class RestaurantServiceImpl implements RestaurantService{
    @Override
    public void adaugaFelMancare(Restaurant restaurant, FelMancare felMancare) {
        restaurant.adaugaFelMancare(felMancare);
        audit.scrieAudit("adaugaFelMancare");
    }

    @Override
    public void stergeFelMancare(Restaurant restaurant, FelMancare felMancare) {
        restaurant.stergeFelMancare(felMancare);
        audit.scrieAudit("stergeFelMancare");
    }

}
