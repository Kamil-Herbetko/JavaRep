package PSiO_Ćwiczenia.lista7.Wyszukiwanie_konkretnych_klas;

import PSiO_Ćwiczenia.lista7.Klasy.Osoba;
import PSiO_Ćwiczenia.lista7.Klasy.PracownikUczelni;

import java.util.ArrayList;

public class Szukanie_Pracowników_Uczelni extends Szukanie_Pracowników{
    @Override
    public void szukanie_wśród_Osób(ArrayList<Osoba> osoby, String składowa, String wartość, String... args) {
        for (Osoba os : osoby){
            if (os != null) {
                if (os instanceof PracownikUczelni) {
                    szukaj_wśród_składowych((PracownikUczelni) os, składowa, wartość);
                }
            }
        }
    }

    protected void szukaj_wśród_składowych(PracownikUczelni pracownikUczelni, String składowa, String wartość) {
        super.szukaj_wśród_składowych(pracownikUczelni, składowa, wartość);

        if (składowa.equals("stanowisko")){
            if (pracownikUczelni.getStanowisko().equals(wartość)) {
                System.out.println(pracownikUczelni);
            }
        }
    }
}
