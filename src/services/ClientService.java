package services;

import entities.persoane.Client;
import inout.Audit;

public interface ClientService {
    Audit audit = Audit.getInstance();
    void afiseazaComanda(Client client);

}
