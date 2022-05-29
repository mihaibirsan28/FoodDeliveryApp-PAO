package services;

import entities.persoane.curier.CurierSofer;

public class CurierSoferServiceImpl implements CurierSoferService{

    @Override
    public void afisareComenziEfectuate(CurierSofer curierSofer) {
        curierSofer.afisareComenziEfectuate();
        audit.scrieAudit("afisareComenziEfectuate");
    }

    @Override
    public void afisareNrComenziEfectuate(CurierSofer curierSofer) {
        curierSofer.afisareNrComenziEfectuare();
        audit.scrieAudit("afisareNrComenziEfectuate");
    }

}
