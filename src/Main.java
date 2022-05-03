
import entities.appDelivery.AppDelivery;
import entities.comanda.Comanda;
import entities.comanda.ComandaFelMancare;
import entities.persoane.Client;

import entities.persoane.curier.CurierBiciclist;
import entities.persoane.curier.CurierSofer;
import entities.restaurant.FelMancare;
import entities.restaurant.Restaurant;
import inout.ReadCSVService;
import inout.WriteCSVService;
import services.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class Main{

    public static void main(String[] args) throws IOException {


        ReadCSVService fin = ReadCSVService.getInstance();


        //clienti
//        Client client1 = new Client(1,"Birsan", "Mihai", "0729425374",  "Strada 13 Septembrie");
//        Client client2 = new Client(2,"Popescu", "Ion", "0729499974",  "Bulevardul Dacia");
//        Client client3 = new Client(3,"Marinescu", "Ioana", "0729456374",  "Bulevardul Unirii");
        List<Client> clienti = fin.citireCSV("data/Clienti.csv", "Clienti");
        Client client1 = clienti.get(0), client2 = clienti.get(1), client3 = clienti.get(2);


        //curieri
//        CurierSofer curierSofer1 = new CurierSofer(1, "Ilinca", "Andrei", "0723678234", "5090989437423", "Categoria B", 2500.00);
//        CurierSofer curierSofer2 = new CurierSofer(2, "Toader", "Mirel", "0723888999", "5121278345678", "Categoria A, B", 2600.00);

        List<CurierSofer> curieriSoferi = fin.citireCSV("data/CurieriSoferi.csv", "CurieriSoferi");
        CurierSofer curierSofer1 = curieriSoferi.get(0), curierSofer2 = curieriSoferi.get(1);

//        CurierBiciclist curierBiciclist1 = new CurierBiciclist(3, "Iordache", "Cristi", "0756666777", "5080801789456", 2000.50);
//        CurierBiciclist curierBiciclist2 = new CurierBiciclist(4, "Tomescu", "Tomi", "0756666774", "5080801712456", 2050.50);

        List<CurierBiciclist> curieriBiciclisti = fin.citireCSV("data/CurieriBiciclisti.csv", "CurieriBiciclisti");
        CurierBiciclist curierBiciclist1 = curieriBiciclisti.get(0), curierBiciclist2 = curieriBiciclisti.get(1);

        //restaurante
//        Restaurant restaurant1 = new Restaurant("Tratorria Il Calcio", "Bulevardul Floreasca");
//        Restaurant restaurant2 = new Restaurant("Suzana", "Bulevardul Unirii");
//        Restaurant restaurant3 = new Restaurant("B4Market", "Calea Dorobanti");

        List<Restaurant> restaurante = fin.citireCSV("data/Restaurante.csv", "Restaurante");
        Restaurant restaurant1 = restaurante.get(0), restaurant2 = restaurante.get(1), restaurant3 = restaurante.get(2);

        //Fel Mancare
//        FelMancare felMancare1 = new FelMancare( "Pizza QuatroStagioni", 35.00, "blat, sos rosii, sunca, mozzarela, ciuperci, porumb");
//        FelMancare felMancare2 = new FelMancare("Antricot vita", 57.00, "vita 300g, sos special");
//        FelMancare felMancare3 = new FelMancare("Piept de pui", 25.00, "piept de pui");
//        FelMancare felMancare4 = new FelMancare("Caracatita grill", 78.00, "caracatita, rucola, sos special");
//        FelMancare felMancare5 = new FelMancare("Paste Bologno", 30.00, "spagetti, carne porc, mozzarela");
//        FelMancare felMancare6 = new FelMancare("Somon", 50.00, "somon, lamaie, avocado");
//        FelMancare felMancare7 = new FelMancare("Salata vinete", 20.00, "vinete, ceapa, ulei");

        List<FelMancare> felMancare = fin.citireCSV("data/FelMancare.csv", "FelMancare");
        FelMancare felMancare1 = felMancare.get(0), felMancare2 = felMancare.get(1), felMancare3 = felMancare.get(2), felMancare4 = felMancare.get(3), felMancare5 = felMancare.get(4), felMancare6 = felMancare.get(5), felMancare7 = felMancare.get(6);


        AppDelivery appDelivery = new AppDelivery();
        AppDeliveryServiceImpl AppDService = new AppDeliveryServiceImpl();

        //adaugam restaurante, curieri si clienti/useri
        AppDService.adaugaRestaurant(appDelivery, restaurant1);
        AppDService.adaugaRestaurant(appDelivery, restaurant2);
        AppDService.adaugaRestaurant(appDelivery, restaurant3);

        AppDService.adaugaCurier(appDelivery, curierSofer1);
        AppDService.adaugaCurier(appDelivery, curierBiciclist1);
        AppDService.adaugaCurier(appDelivery, curierSofer2);
        AppDService.adaugaCurier(appDelivery, curierBiciclist2);

        AppDService.adaugaClient(appDelivery, client1);
        AppDService.adaugaClient(appDelivery, client2);
        AppDService.adaugaClient(appDelivery, client3);


        RestaurantServiceImpl RestaurantService = new RestaurantServiceImpl();
        //adaugam felurile de mancare pentru fiecare entities.restaurant
        RestaurantService.adaugaFelMancare(restaurant1, felMancare1);
        RestaurantService.adaugaFelMancare(restaurant1, felMancare5);
        RestaurantService.adaugaFelMancare(restaurant2, felMancare2);
        RestaurantService.adaugaFelMancare(restaurant2, felMancare3);
        RestaurantService.adaugaFelMancare(restaurant3, felMancare4);
        RestaurantService.adaugaFelMancare(restaurant3, felMancare6);

        //scoatem un fel de mancare din lista preparatelor unui entities.restaurant
        RestaurantService.adaugaFelMancare(restaurant1, felMancare7);
        RestaurantService.stergeFelMancare(restaurant1, felMancare7);

        //adaugam o entities.comanda
        Comanda comanda1 = new Comanda(1, client1, restaurant1, curierSofer1, new Date(2022,3,27,12,3),70.00);
        Comanda comanda2 = new Comanda(2, client2, restaurant2, curierBiciclist1, new Date(2022, 27, 3,14,9), 57.00);
        Comanda comanda3 = new Comanda(3, client3, restaurant3, curierBiciclist1, new Date(2022, 3,23, 21,14), 128.00);

        //adaugam felurile de mancare din entities.comanda
        ComandaFelMancare comandaFelMancare1 = new ComandaFelMancare(restaurant1, "Pizza QuatroStagioni", 35.00);
        ComandaFelMancare comandaFelMancare2 = new ComandaFelMancare(restaurant2, "Antricot Vita", 57.00);
        ComandaFelMancare comandaFelMancare3 = new ComandaFelMancare(restaurant3, "Caracatita grill", 78.00);
        ComandaFelMancare comandaFelMancare4 = new ComandaFelMancare(restaurant3, "Somon", 50.00);

        //adaugam felurile de mancare comandate in entities.comanda respectiva
        comanda1.adaugaFelMancare(restaurant1, "Pizza QuatroStagioni", 35.00);
        comanda2.adaugaFelMancare(restaurant2, "Antricot Vita", 57.00);
        comanda3.adaugaFelMancare(restaurant3, "Caracatita grill", 78.00);
        comanda3.adaugaFelMancare(restaurant3, "Somon", 50.00);

        appDelivery.adaugaComanda(comanda1);
        appDelivery.adaugaComanda(comanda2);
        appDelivery.adaugaComanda(comanda3);

        ClientServiceImpl clientService = new ClientServiceImpl();
        clientService.afiseazaComanda(client1);
        System.out.println("-----------");

        ComandaServiceImpl ComandaService = new ComandaServiceImpl();
        //afisare entities.comanda + ce contine entities.comanda
        ComandaService.afiseazaComanda(comanda3);
        System.out.println();

        //afisare profil client
        System.out.println(client1);
        System.out.println();

        //afisare entities.comanda unui client
        ComandaService.afiseazaComanda(comanda1);
        System.out.println();

        CurierSoferServiceImpl curierSoferService = new CurierSoferServiceImpl();
        CurierBiciclistServiceImpl curierBiciclistService = new CurierBiciclistServiceImpl();
        //afisare comenzi facute de un curier:
        curierBiciclistService.afisareComenziEfectuate(curierBiciclist1);
        System.out.println();

        curierSoferService.afisareComenziEfectuate(curierSofer1);
        System.out.println();



        //afisare numar de comenzi efectuate de un curier
        curierBiciclistService.afisareNrComenziEfectuate(curierBiciclist1);
        System.out.println();

        //marim salariul unui curier
        System.out.println(curierSofer1.getNumeComplet() + " are salariul:");
        System.out.println(curierSofer1.getSalariu());
        AppDService.marireSalariu(appDelivery, curierSofer1, 200.00);
        System.out.println(curierSofer1.getNumeComplet() + " are salariul dupa marire:");
        System.out.println(curierSofer1.getSalariu());
        System.out.println();


        //meniu entities.restaurant
        restaurant1.vizualizareMeniu();
        System.out.println();

        //eliminam un client din aplicatie
        AppDService.eliminaClient(appDelivery, client3);

        //eliminam un curier din aplicatie
        AppDService.eliminaCurier(appDelivery, curierBiciclist2);

        //eliminam un entities.restaurant din aplicatie
        AppDService.eliminaRestaurant(appDelivery, restaurant1);

        WriteCSVService fout = WriteCSVService.getInstance();

    }
}
