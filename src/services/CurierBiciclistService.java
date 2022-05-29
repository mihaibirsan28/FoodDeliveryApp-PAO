package services;

import entities.persoane.curier.CurierBiciclist;
import inout.Audit;

public interface CurierBiciclistService {
    Audit audit = Audit.getInstance();

    void afisareComenziEfectuate(CurierBiciclist curierBiciclist);

    void afisareNrComenziEfectuate(CurierBiciclist curierBiciclist);

}
