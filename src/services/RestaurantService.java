package services;

import entities.restaurant.FelMancare;
import entities.restaurant.Restaurant;
import inout.Audit;

public interface RestaurantService {
    Audit audit = Audit.getInstance();
    void adaugaFelMancare(Restaurant restaurant, FelMancare felMancare);
    void stergeFelMancare(Restaurant restaurant, FelMancare felMancare);

}
