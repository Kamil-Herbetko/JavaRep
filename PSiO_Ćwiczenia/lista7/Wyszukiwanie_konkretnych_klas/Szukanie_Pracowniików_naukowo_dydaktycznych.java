package PSiO_Ćwiczenia.lista7.Wyszukiwanie_konkretnych_klas;

import PSiO_Ćwiczenia.lista7.Klasy.Osoba;
import PSiO_Ćwiczenia.lista7.Klasy.PracownikUczelniNaukowo_Dydaktyczny;

import java.util.ArrayList;

public class Szukanie_Pracowniików_naukowo_dydaktycznych extends Szukanie_Pracowników{
    @Override
    public void szukanie_wśród_Osób(ArrayList<Osoba> osoby, String składowa, String wartość, String... args) {
        for (Osoba os : osoby){
            if (os != null) {
                if (os instanceof PracownikUczelniNaukowo_Dydaktyczny) {
                    szukaj_wśród_składowych((PracownikUczelniNaukowo_Dydaktyczny) os, składowa, wartość);
                }
            }
        }
    }


    protected void szukaj_wśród_składowych(PracownikUczelniNaukowo_Dydaktyczny pracownikUczelniNaukowoDydaktyczny, String składowa, String wartość) {
        super.szukaj_wśród_składowych(pracownikUczelniNaukowoDydaktyczny, składowa, wartość);

        switch (składowa){
            case "dorobek":{
                if (Double.toString(pracownikUczelniNaukowoDydaktyczny.getDorobek()).equals(wartość)){
                    System.out.println(pracownikUczelniNaukowoDydaktyczny);
                }
            }
            case "katedra":{
                if (pracownikUczelniNaukowoDydaktyczny.getKatedra().equals(wartość)){
                    System.out.println(pracownikUczelniNaukowoDydaktyczny);
                }
            }
            case "stopień naaukowy":{
                if (pracownikUczelniNaukowoDydaktyczny.getStopieńNaukowy().equals(wartość)){
                    System.out.println(pracownikUczelniNaukowoDydaktyczny);
                }
            }
        }
    }
}
