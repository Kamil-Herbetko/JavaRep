package PSiO_Ćwiczenia.lista7.Wyszukiwanie_konkretnych_klas;

import PSiO_Ćwiczenia.lista7.Klasy.Osoba;
import PSiO_Ćwiczenia.lista7.Klasy.Pracownik;

import java.util.ArrayList;

public class Szukanie_Pracowników extends Szukanie_Wśród_Osób{
    @Override
    public void szukanie_wśród_Osób(ArrayList<Osoba> osoby, String składowa, String wartość, String...args) {
        for (Osoba os: osoby){
            if (os != null) {
                if (os instanceof Pracownik) {
                    szukaj_wśród_składowych((Pracownik) os, składowa, wartość);
                }
            }
        }
    }


    protected void szukaj_wśród_składowych(Pracownik pracownik, String składowa, String wartość) {
        super.szukaj_wśród_składowych(pracownik, składowa, wartość);

        switch (składowa){
            case "pensja":{
                if (Integer.toString(pracownik.getPensja()).equals(wartość)){
                    System.out.println(pracownik);
                }
                break;
            }
            case "lata praacy":{
                if (Integer.toString(pracownik.getLataPracy()).equals(wartość)){
                    System.out.println(pracownik);
                }
                break;
            }
        }
    }
}
