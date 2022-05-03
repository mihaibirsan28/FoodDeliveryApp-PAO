package services;

import entities.persoane.Client;

public class ClientServiceImpl implements ClientService{

    @Override
    public void afiseazaComanda(Client client) {
        client.afiseazaComanda();
        audit.scrieAudit("afiseazaComanda");
    }

}
