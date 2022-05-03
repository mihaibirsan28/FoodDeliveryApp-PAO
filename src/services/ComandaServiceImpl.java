package services;

import entities.comanda.Comanda;
import entities.restaurant.Restaurant;

public class ComandaServiceImpl implements ComandaService{
    @Override
    public void afiseazaComanda(Comanda comanda) {
        comanda.afiseazaComanda();
        audit.scrieAudit("afiseazaComanda");
    }


}
