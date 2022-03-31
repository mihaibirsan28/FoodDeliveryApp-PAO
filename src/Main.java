
import AppDelivery.AppDelivery;
import Comanda.Comanda;
import Comanda.ComandaFelMancare;
import Persoane.Client;
import Persoane.Curier.Curier;
import Persoane.Curier.CurierBiciclist;
import Persoane.Curier.CurierSofer;
import Restaurant.FelMancare;
import Restaurant.Restaurant;

import  java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Date;

public class Main implements Service{


    @Override
    public void adaugaClient(AppDelivery a, Client client) {
        a.adaugaClienti(client);
    }

    @Override
    public void eliminaClient(AppDelivery a, Client client) {
        a.eliminaClient(client);
    }

    @Override
    public void adaugaCurier(AppDelivery a, Curier curier) {
        a.adaugaCurier(curier);
    }

    @Override
    public void eliminaCurier(AppDelivery a, Curier curier) {
        a.eliminaCurier(curier);
    }

    @Override
    public void adaugaRestaurant(AppDelivery a, Restaurant restaurant) {
        a.adaugaRestaurant(restaurant);
    }

    @Override
    public void eliminaRestaurant(AppDelivery a, Restaurant restaurant) {
        a.eliminaRestaurant(restaurant);
    }

    @Override
    public void marireSalariu(AppDelivery a, Curier c, double marire) {
        a.marireSalariu(c,marire);
    }

    @Override
    public void afiseazaComanda(Client client) {
        client.afiseazaComanda();
    }

    @Override
    public void afisareComenziEfectuate(CurierSofer curierSofer) {
        curierSofer.afisareComenziEfectuate();
    }

    @Override
    public void afisareComenziEfectuate(CurierBiciclist curierBiciclist) {
        curierBiciclist.afisareComenziEfectuate();
    }

    @Override
    public void adaugaFelMancare(Restaurant restaurant, FelMancare felMancare) {
        restaurant.adaugaFelMancare(felMancare);
    }

    @Override
    public void stergeFelMancare(Restaurant restaurant, FelMancare felMancare) {
        restaurant.stergeFelMancare(felMancare);
    }

    @Override
    public void afisareNrComenziEfectuate(CurierSofer curierSofer) {
        curierSofer.afisareNrComenziEfectuare();
    }

    @Override
    public void afisareNrComenziEfectuate(CurierBiciclist curierBiciclist) {
        curierBiciclist.afisareNrComenziEfectuare();
    }

    @Override
    public void afiseazaComanda(Comanda comanda) {
        comanda.afiseazaComanda();
    }

//    @Override
//    public void afisareCurieriSoferi(AppDelivery a, ArrayList<CurierSofer> soferi) {
//        a.afisareCurieriSoferi(soferi);
//    }

    public static void main(String[] args) {

        Main main = new Main();

        //clienti
        Client client1 = new Client(1,"Birsan", "Mihai", "0729425374",  "Strada 13 Septembrie");
        Client client2 = new Client(2,"Popescu", "Ion", "0729499974",  "Bulevardul Dacia");
        Client client3 = new Client(3,"Marinescu", "Ioana", "0729456374",  "Bulevardul Unirii");

        //curieri
        CurierSofer curierSofer1 = new CurierSofer(1, "Ilinca", "Andrei", "0723678234", "5090989437423", "Categiria B", 2500.00);
        CurierSofer curierSofer2 = new CurierSofer(2, "Toader", "Mirel", "0723888999", "5121278345678", "Categoria A, B", 2600.00);

        CurierBiciclist curierBiciclist1 = new CurierBiciclist(3, "Iordache", "Cristi", "0756666777", "5080801789456", 2000.50);
        CurierBiciclist curierBiciclist2 = new CurierBiciclist(4, "Tomescu", "Tomi", "0756666774", "5080801712456", 2050.50);

        //restaurante
        Restaurant restaurant1 = new Restaurant("Tratorria Il Calcio", "Bulevardul Floreasca");
        Restaurant restaurant2 = new Restaurant("Suzana", "Bulevardul Unirii");
        Restaurant restaurant3 = new Restaurant("B4Market", "Calea Dorobanti");

        //Fel Mancare
        FelMancare felMancare1 = new FelMancare( "Pizza QuatroStagioni", 35.00, "blat, sos rosii, sunca, mozzarela, ciuperci, porumb");
        FelMancare felMancare2 = new FelMancare("Antricot vita", 57.00, "vita 300g, sos special");
        FelMancare felMancare3 = new FelMancare("Piept de pui", 25.00, "piept de pui");
        FelMancare felMancare4 = new FelMancare("Caracatita grill", 78.00, "caracatita, rucola, sos special");
        FelMancare felMancare5 = new FelMancare("Paste Bologno", 30.00, "spagetti, carne porc, mozzarela");
        FelMancare felMancare6 = new FelMancare("Somon", 50.00, "somon, lamaie, avocado");
        FelMancare felMancare7 = new FelMancare("Salata vinere", 20.00, "vinete, ceapa, ulei");

        AppDelivery appDelivery = new AppDelivery();

        //adaugam restaurante, curieri si clienti/useri
        appDelivery.adaugaRestaurant(restaurant1);
        appDelivery.adaugaRestaurant(restaurant2);
        appDelivery.adaugaRestaurant(restaurant3);

        appDelivery.adaugaCurier(curierSofer1);
        appDelivery.adaugaCurier(curierBiciclist1);
        appDelivery.adaugaCurier(curierSofer2);
        appDelivery.adaugaCurier(curierBiciclist2);

        appDelivery.adaugaClienti(client1);
        appDelivery.adaugaClienti(client2);
        appDelivery.adaugaClienti(client3);

        //adaugam felurile de mancare pentru fiecare restaurant
        restaurant1.adaugaFelMancare(felMancare1);
        restaurant1.adaugaFelMancare(felMancare5);
        restaurant2.adaugaFelMancare(felMancare2);
        restaurant2.adaugaFelMancare(felMancare3);
        restaurant3.adaugaFelMancare(felMancare4);
        restaurant3.adaugaFelMancare(felMancare6);

        //scoatem un fel de mancare din lista preparatelor unui restaurant
        restaurant1.adaugaFelMancare(felMancare7);
        restaurant1.stergeFelMancare(felMancare7);

        //adaugam o comanda
        Comanda comanda1 = new Comanda(1, client1, restaurant1, curierSofer1, new Date(2022,3,27,12,3),70.00);
        Comanda comanda2 = new Comanda(2, client2, restaurant2, curierBiciclist1, new Date(2022, 27, 3,14,9), 57.00);
        Comanda comanda3 = new Comanda(3, client3, restaurant3, curierBiciclist1, new Date(2022, 3,23, 21,14), 128.00);

        //adaugam felurile de mancare din comanda
        ComandaFelMancare comandaFelMancare1 = new ComandaFelMancare(restaurant1, "Pizza QuatroStagioni", 35.00);
        ComandaFelMancare comandaFelMancare2 = new ComandaFelMancare(restaurant2, "Antricot Vita", 57.00);
        ComandaFelMancare comandaFelMancare3 = new ComandaFelMancare(restaurant3, "Caracatita grill", 78.00);
        ComandaFelMancare comandaFelMancare4 = new ComandaFelMancare(restaurant3, "Somon", 50.00);

        //adaugam felurile de mancare comandate in comanda respectiva
        comanda1.adaugaFelMancare(restaurant1, "Pizza QuatroStagioni", 35.00);
        comanda2.adaugaFelMancare(restaurant2, "Antricot Vita", 57.00);
        comanda3.adaugaFelMancare(restaurant3, "Caracatita grill", 78.00);
        comanda3.adaugaFelMancare(restaurant3, "Somon", 50.00);

        appDelivery.adaugaComanda(comanda1);
        appDelivery.adaugaComanda(comanda2);
        appDelivery.adaugaComanda(comanda3);

        //afisare comanda + ce contine comanda
        comanda3.afiseazaComanda();
        System.out.println();

        //afisare profil client
        System.out.println(client1);
        System.out.println();

        //afisare comanda unui client
        client1.afiseazaComanda();
        System.out.println();

        //afisare comenzi facute de un curier:
        //curierBiciclist1.adaugaComanda(comanda2);
        curierBiciclist1.afisareComenziEfectuate();
        System.out.println();

        //afisare numar de comenzi efectuate de un curier
        curierBiciclist1.afisareNrComenziEfectuare();
        System.out.println();

        //marim salariul unui curier
        System.out.println(curierSofer1.getNumeComplet() + " are salariul:");
        System.out.println(curierSofer1.getSalariu());
        appDelivery.marireSalariu(curierSofer1, 200.00);
        System.out.println(curierSofer1.getNumeComplet() + " are salariul dupa marire:");
        System.out.println(curierSofer1.getSalariu());
        System.out.println();

        //meniu restaurant
        restaurant1.vizualizareMeniu();
        System.out.println();

        //eliminam un client din aplicatie
        appDelivery.eliminaClient(client3);

        //eliminam un curier din aplicatie
        appDelivery.eliminaCurier(curierBiciclist2);

        //eliminam un restaurant din aplicatie
        appDelivery.eliminaRestaurant(restaurant1);

        //afisare curieri cu permis de conducere
        // appDelivery.afisareCurieriSoferi(appDelivery.soferi);

    }
}
