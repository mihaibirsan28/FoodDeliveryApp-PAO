package inout;

import entities.persoane.Client;
import entities.persoane.curier.CurierBiciclist;
import entities.persoane.curier.CurierSofer;
import entities.restaurant.FelMancare;
import entities.restaurant.Restaurant;
import exceptii.WrongObjectType;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteCSVService {

    private static WriteCSVService instance;

    private WriteCSVService() {}

    public static WriteCSVService getInstance() {
        if (instance == null) {
            instance = new WriteCSVService();
        }
        return instance;
    }

    public <T> void scrieCSV(T obiect, String path) {
        try (BufferedWriter fout = new BufferedWriter(new FileWriter(path, true))) {
            String line = "";
            if (obiect instanceof Client) {
                Client client = (Client) obiect;
                line += client.getId() + ", " + client.getNume() + ", " + client.getPrenume() + ", " + client.getNumarTelefon() + ", " + client.getAdresa();
                fout.write(line);
            }
            else if(obiect instanceof CurierBiciclist) {
                CurierBiciclist curierBiciclist = (CurierBiciclist) obiect;
                line += curierBiciclist.getId() + ", " + curierBiciclist.getNume() + ", " + curierBiciclist.getPrenume() + ", " + curierBiciclist.getNumarTelefon() + ", " + curierBiciclist.getCNP() + ", " + curierBiciclist.getSalariu();
                fout.write(line);
            }
            else if(obiect instanceof CurierSofer) {
                CurierSofer curierSofer = (CurierSofer) obiect;
                line += curierSofer.getId() + ", " + curierSofer.getNume() + ", " + curierSofer.getPrenume() + ", " + curierSofer.getNumarTelefon() + ", " + curierSofer.getCNP() + ", " + curierSofer.getPermisAuto() + ", " + curierSofer.getSalariu();
                fout.write(line);
            }
            else if(obiect instanceof FelMancare) {
                FelMancare felMancare = (FelMancare) obiect;
                line += felMancare.getNume() + ", " + felMancare.getPret() + ", " + felMancare.getIngrediente();
                fout.write(line);
            }
            else if(obiect instanceof Restaurant) {
                Restaurant restaurant = (Restaurant) obiect;
                line += restaurant.getNume() + ", " + restaurant.getAdresa();
                fout.write(line);
            }
            else throw new WrongObjectType("Obiectul nu poate sa fie scris in fisier.");
        }catch (IOException | WrongObjectType e) {
            e.printStackTrace();
        }
    }
}
