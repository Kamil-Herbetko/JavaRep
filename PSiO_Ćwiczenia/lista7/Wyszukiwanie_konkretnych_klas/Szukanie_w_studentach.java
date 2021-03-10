package PSiO_Ćwiczenia.lista7.Wyszukiwanie_konkretnych_klas;

import PSiO_Ćwiczenia.lista7.Klasy.Kursy;
import PSiO_Ćwiczenia.lista7.Klasy.Osoba;
import PSiO_Ćwiczenia.lista7.Klasy.Student;

import java.util.ArrayList;

public class Szukanie_w_studentach extends Szukanie_Wśród_Osób {
    @Override
    public void szukanie_wśród_Osób(ArrayList<Osoba> osoby, String składowa, String wartość, String...args) {
        for (Osoba os: osoby){
            if (os != null) {
                if (os instanceof Student) {
                    szukaj_wśród_składowych((Student) os, składowa, wartość, args[0]);
                }
            }
        }
    }

    protected void szukaj_wśród_składowych(Student student, String składowa, String wartość, String...args) {
        super.szukaj_wśród_składowych(student, składowa, wartość);

        switch (składowa){
            case "kierunek":{
                if (student.getKierunek().equals(wartość)){
                    System.out.println(student);
                }
                break;
            }
            case "wydział":{
                if (student.getWydział().equals(wartość)){
                    System.out.println(student);
                }
                break;
            }
            case "numer indeksu":{
                if (Integer.toString(student.getNumer_indeksu()).equals(wartość)){
                    System.out.println(wartość);
                }
                break;
            }
            case "kursy":{
                switch (args[0]){
                    case "nazwa kursu":{
                        for (Kursy kursy : student.getKursy()){
                            if (kursy.getNazwa_kursu().equals(wartość)){
                                System.out.println(student);
                            }
                        }
                        break;
                    }
                    case "ilość ECTS":{
                        for (Kursy kursy : student.getKursy()){
                            if (Integer.toString(kursy.getIloscECTS()).equals(wartość)){
                                System.out.println(student);
                            }
                        }
                        break;
                    }
                    case "czy kończy się egzaminem":{
                        for (Kursy kursy : student.getKursy()){
                            if (Boolean.toString(kursy.isCzyKończySięEgzaminem()).equals(wartość)){
                                System.out.println(student);
                            }
                        }
                        break;
                    }
                }
                break;
            }
        }
    }


}
