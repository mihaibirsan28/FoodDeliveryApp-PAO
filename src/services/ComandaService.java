package services;

import entities.comanda.Comanda;
import entities.restaurant.Restaurant;
import inout.Audit;

public interface ComandaService {
    Audit audit = Audit.getInstance();
    void afiseazaComanda(Comanda comanda);

}
