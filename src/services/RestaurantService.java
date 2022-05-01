package services;

import entities.restaurant.FelMancare;
import entities.restaurant.Restaurant;

public interface RestaurantService {
    void adaugaFelMancare(Restaurant restaurant, FelMancare felMancare);
    void stergeFelMancare(Restaurant restaurant, FelMancare felMancare);

}
