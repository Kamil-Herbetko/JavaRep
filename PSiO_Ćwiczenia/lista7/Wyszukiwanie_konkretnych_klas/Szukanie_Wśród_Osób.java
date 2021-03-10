package PSiO_Ćwiczenia.lista7.Wyszukiwanie_konkretnych_klas;

import PSiO_Ćwiczenia.lista7.Klasy.Osoba;

import java.util.ArrayList;

public class Szukanie_Wśród_Osób{


    public void szukanie_wśród_Osób(ArrayList<Osoba> osoby, String składowa, String wartość, String...args) {
        for (Osoba os: osoby){
            if (os != null) {
                szukaj_wśród_składowych(os, składowa, wartość);
            }
        }
    }

    protected void szukaj_wśród_składowych(Osoba osoba, String składowa, String wartość){
        switch (składowa){
            case "imie":{
                if (osoba.getImie().equals(wartość)){
                    System.out.println(osoba);
                }
                break;
            }

            case "nazwisko":{
                if (osoba.getNazwisko().equals(wartość)){
                    System.out.println(osoba);
                }
                break;
            }

            case "PESEL":{
                if ((Integer.toString(osoba.getPESEL())).equals(wartość)){
                    System.out.println(osoba);
                }
                break;
            }

            case "wiek":{
                if ((Double.toString(osoba.getWiek())).equals(wartość)){
                    System.out.println(osoba);
                }
                break;
            }

            case "wzrost":{
                if ((Integer.toString(osoba.getWzrost())).equals(wartość)){
                    System.out.println(osoba);
                }
                break;
            }

            case "waga":{
                if ((Integer.toString(osoba.getWaga())).equals(wartość)){
                    System.out.println(osoba);
                }
                break;
            }
        }
    }
}
