package inout;

import entities.persoane.Client;
import entities.persoane.curier.CurierBiciclist;
import entities.persoane.curier.CurierSofer;
import entities.restaurant.FelMancare;
import entities.restaurant.Restaurant;
import exceptii.WrongObjectType;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCSVService {

    private static ReadCSVService instance;

    public static ReadCSVService getInstance(){
        if (instance == null){
            instance = new ReadCSVService();
        }
        return instance;
    }

    public <T> List<T> citireCSV(String path, String numeObiect){
        List<T> date = new ArrayList<>();
        List<String[]> rows = new ArrayList<>();
        try (BufferedReader fin = new BufferedReader(new FileReader(path))){
            String line = fin.readLine();
            while ((line = fin.readLine()) != null){
                String[] obiect = line.split(",");
                for(int i = 0; i < obiect.length; i++)
                    obiect[i] = obiect[i].trim();
                rows.add(obiect);
            }
            if (numeObiect.equalsIgnoreCase("Clienti")){
                for (var obj : rows){
                    Client client = new Client(Integer.parseInt(obj[0]), obj[1], obj[2], obj[3], obj[4]);
                    date.add((T) client);
                }
            }
            else if (numeObiect.equalsIgnoreCase("CurieriBiciclisti")){
                for (var obj : rows){
                    CurierBiciclist curierBiciclist = new CurierBiciclist(Integer.parseInt(obj[0]), obj[1], obj[2], obj[3], obj[4], Double.parseDouble(obj[5]));
                    date.add((T) curierBiciclist);
                }
            }
            else if (numeObiect.equalsIgnoreCase("CurieriSoferi")){
                for (var obj : rows){
                    CurierSofer curierSofer = new CurierSofer(obj[0], obj[1], obj[2], obj[3], obj[4], obj[5], obj[6]);
                    date.add((T) curierSofer);
                }
            }
            else if (numeObiect.equalsIgnoreCase("FelMancare")){
                for (var obj : rows){
                    FelMancare felMancare = new FelMancare(obj[0], obj[1], obj[2]);
                    date.add((T) felMancare);
                }
            }
            else if (numeObiect.equalsIgnoreCase("Restaurante")){
                for (var obj : rows){
                    Restaurant restaurant = new Restaurant(obj[0], obj[1]);
                    date.add((T) restaurant);
                }
            }
            else throw new WrongObjectType("Nu exista tipul obectelor citite.")
        }catch (IOException | WrongObjectType e) {
            e.printStackTrace();
        }
        return date;
    }
}
