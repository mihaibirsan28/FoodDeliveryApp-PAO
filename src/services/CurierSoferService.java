package services;

import entities.persoane.curier.CurierSofer;
import inout.Audit;

public interface CurierSoferService {
    Audit audit = Audit.getInstance();

    void afisareComenziEfectuate(CurierSofer curierSofer);

    void afisareNrComenziEfectuate(CurierSofer curierSofer);

}
