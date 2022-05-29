package services;

import entities.persoane.curier.CurierBiciclist;

public class CurierBiciclistServiceImpl implements CurierBiciclistService{

    @Override
    public void afisareComenziEfectuate(CurierBiciclist curierBiciclist) {
        curierBiciclist.afisareComenziEfectuate();
        audit.scrieAudit("afisareComenziEfectuate");
    }

    @Override
    public void afisareNrComenziEfectuate(CurierBiciclist curierBiciclist) {
        curierBiciclist.afisareNrComenziEfectuare();
        audit.scrieAudit("afisareNrComenziEfectuate");
    }
}
