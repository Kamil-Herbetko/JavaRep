package PSiO_Ćwiczenia.lista7;


import PSiO_Ćwiczenia.lista7.Comparators.ComparatorOsob;
import PSiO_Ćwiczenia.lista7.Klasy.*;
import PSiO_Ćwiczenia.lista7.Wyszukiwanie_konkretnych_klas.*;

import java.io.*;
import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main{
    static Szukanie_Wśród_Osób wyszukiwanie;

    public static void main(String[] args) {
        boolean menu = true;
        ArrayList<Osoba> osoby = new ArrayList<>();


        osoby.add(new PracownikUczelniNaukowo_Dydaktyczny("Maciej", "Bednarz", 1234234980, 25.3, 180, 78, 4500, 1, 23.4, "Matematyki", "magister inżynier"));
        osoby.add(new PracownikUczelniNaukowo_Dydaktyczny("Miirosław", "Kowalik", 1213156980, 35.3, 181, 81, 6500, 9, 2223.4, "Fizyki", "doktor inżynier"));
        osoby.add(new PracownikUczelniNaukowo_Dydaktyczny("Jakub", "Kołodziej", 1213156980, 45.3, 179, 70, 8500, 19, 2231233.4, "Infoormatyki", "profesor inżynier"));
        osoby.add(new PracownikUczelni("Bogumił", "Milusiński", 1325234580, 29.4, 156, 55, 2200, 1, "Portier"));
        osoby.add(new PracownikUczelni("Mateusz", "Kołodziej", 1223423420, 43.3, 164, 65, 5500, 17, "Księgowy"));
        osoby.add(new PracownikUczelni("Jarosław", "Kowal", 1223423480, 33.1, 170, 78, 3500, 6, "Księgowy"));
        osoby.add(new Student("Jerzy", "Kowalski", 1213156980, 19.3, 190, 90, "Informatyka Stosowana", "Informatyka i Zarządzanie", 234567, new ArrayList<>()));
        osoby.add(new Student("Kamil", "Nowak", 1223874980, 21.6, 175, 79, "Informatyka Stosowana", "Informatyka i Zarządzanie", 287234, new ArrayList<>()));
        osoby.add(new Student("Wiesław", "Bednarz", 1211212380, 22.0, 163, 65, "Informatyka Stosowana", "Informatyka i Zarządzanie", 212344, new ArrayList<>()));


        // Menu

        while(menu){
            Scanner scan = new Scanner(System.in);

            System.out.println("Wybierz opcję:");
            System.out.println("1 - wyszukaj osoby przez podanie nazwy składowej i jej wartości");
            System.out.println("2 - modyfikacja listy osób");
            System.out.println("3 - zapisanie danych do pliku");
            System.out.println("4 - odczytanie danych z pliku");
            System.out.println("5 - dodaj kurs studentowi");
            System.out.println("6 - sortowanie");
            System.out.println("7 - wyjście");

            String opcja = scan.nextLine();

            switch(opcja){
                case "1":{
                    wyszukajPrzezSkładową(osoby, scan);
                    break;
                }
                case "2":{
                    modyfikacjaOsób(osoby, scan);
                    break;
                }
                case "3":{
                    zapisz(osoby);
                    break;
                }
                case "4":{
                    odczytaj();
                    break;
                }
                case "5":{
                    dodajKursStudentowi(osoby, scan);
                    break;
                }
                case "6":{
                    sortuj(osoby, scan);
                    break;
                }
                case "7":{
                    menu = false;
                    scan.close();
                    break;
                }
                default:{
                    System.out.println("Przykro mi, ale nie rozpoznaję wybranej komendy. Spróbuj ponownie.");

                }
            }

            System.out.println();
        }
    }

    public static void wyszukajPrzezSkładową(ArrayList<Osoba> osoby, Scanner scan){
        System.out.println("Wybierz grupę do szukania.");
        System.out.println("1 - Osoby");
        System.out.println("2 - Studenci");
        System.out.println("3 - Pracownicy");
        System.out.println("4 - Pracownicy uczelni");
        System.out.println("5 - Pracownicy naukowo - dydaktyczni");
        System.out.println("6 - powrót");

        String wybór = scan.nextLine();

        System.out.println("Wpisz nazwę składowej według której mam szukać.");

        String składowa = scan.nextLine();



        System.out.println("Wpisz wartość składoowej.");

        String wartość = scan.nextLine();

        switch (wybór){
            case "1":{
                wyszukiwanie = new Szukanie_Wśród_Osób();
                wyszukiwanie.szukanie_wśród_Osób(osoby, składowa, wartość);
                break;
            }
            case "2":{
                String składowaKursu = "";

                if (składowa.equals("kursy")){
                    System.out.println("Podaj nazwę składowej kursu według której mam szukać.");
                    składowaKursu = scan.nextLine();
                }

                wyszukiwanie = new Szukanie_w_studentach();
                wyszukiwanie.szukanie_wśród_Osób(osoby, składowa, wartość, składowaKursu);
                break;

            }
            case "3":{
                wyszukiwanie = new Szukanie_Pracowników();
                wyszukiwanie.szukanie_wśród_Osób(osoby, składowa, wartość);
                break;
            }
            case "4":{
                wyszukiwanie = new Szukanie_Pracowników_Uczelni();
                wyszukiwanie.szukanie_wśród_Osób(osoby, składowa, wartość);
                break;
            }
            case "5":{
                wyszukiwanie = new Szukanie_Pracowniików_naukowo_dydaktycznych();
                wyszukiwanie.szukanie_wśród_Osób(osoby, składowa, wartość);
                break;
            }
            case "6":{
                break;
            }
            default:{
                System.out.println("Przykro mi, ale nie rozpoznaję wybranej komendy. Spróbuj ponownie.");
            }
        }
    }

    public static void modyfikacjaOsób(ArrayList<Osoba> osoby, Scanner scan){
        System.out.println("Wybierz opcję:");
        System.out.println("1 - Utwórz osobę");
        System.out.println("2 - Wypisz osoby");
        System.out.println("3 - Usuń osobę");
        System.out.println("4 - powrót");

        String wybor = scan.nextLine();

        switch (wybor){
            case "1":{
                wpisywanieOsób(osoby, scan);
                break;
            }
            case "2":{
                wypiszOsoby(osoby);
                break;
            }
            case "3":{
                System.out.println("Czy chcesz usunąć osobę na konkretnym miejscu w tablicy?");
                System.out.println("1 - tak");
                System.out.println("2 - nie");
                System.out.println("3 - powrót");

                String wybór = scan.nextLine();

                if (wybór.equals("1")) {

                    System.out.println("Podaj index osoby, którą chcesz usunąć.");
                    int index = scan.nextInt();
                    scan.nextLine();

                    usuńOsobę(osoby, index);
                }
                else if (wybór.equals("2")){
                    usuńOsobę(osoby, osoby.size() - 1);
                }
                break;
            }
            case "4":{
                break;
            }
            default:{
                System.out.println("Przykro mi, ale nie rozpoznaję wybranej komendy. Spróbuj ponownie.");
            }
        }
    }

    public static void wpisywanieOsób(ArrayList<Osoba> osoby, Scanner scan){

        System.out.println("Ile osób chcesz utworzyć?");

        int ilosc = scan.nextInt();

        for (int i = 0; i < ilosc; i++) {
            utwórzOsobę(osoby, scan);
        }
    }

    public static void utwórzOsobę(ArrayList<Osoba> osoby, Scanner scan){
        System.out.println("Wybierz opcję:");
        System.out.println("1 - Utwórz Pracownika Uczelni");
        System.out.println("2 - Utwórz Pracownika naukowo - dydaktycznego");
        System.out.println("3 - Utwórz Studenta");


        String wybór = scan.nextLine();

        System.out.println("Podaj imię: ");
        String imie = scan.nextLine();

        System.out.println("Podaj nazwisko: ");
        String nazwisko = scan.nextLine();

        System.out.println("Podaj pesel: ");
        int PESEL = scan.nextInt();
        scan.nextLine();

        System.out.println("Podaj wiek:");
        double wiek = scan.nextDouble();
        scan.nextLine();

        System.out.println("Podaj wzrost:");
        int wzrost = scan.nextInt();
        scan.nextLine();

        System.out.println("Podaj wagę:");
        int waga = scan.nextInt();
        scan.nextLine();


        switch (wybór){
            case "1":{

                System.out.println("Podaj pensję:");
                int pensja = scan.nextInt();
                scan.nextLine();

                System.out.println("Podaj lata pracy:");
                int lataPracy = scan.nextInt();
                scan.nextLine();

                System.out.println("Stanowisko:");
                String stanowisko = scan.nextLine();


                osoby.add(new PracownikUczelni(imie, nazwisko, PESEL, wiek, wzrost, waga, pensja, lataPracy, stanowisko));
                scan.close();
                break;
            }
            case "2":{

                System.out.println("Podaj pensję:");
                int pensja = scan.nextInt();
                scan.nextLine();

                System.out.println("Podaj lata pracy:");
                int lataPracy = scan.nextInt();
                scan.nextLine();

                System.out.println("Podaj dorobek:");
                double dorobek = scan.nextDouble();
                scan.nextLine();

                System.out.println("Podaj katedrę: ");
                String katedra = scan.nextLine();

                System.out.println("Podaj stopień naukowy: ");
                String stopieńNaukowy = scan.nextLine();


                osoby.add(new PracownikUczelniNaukowo_Dydaktyczny(imie, nazwisko, PESEL, wiek, wzrost, waga, pensja, lataPracy, dorobek, katedra, stopieńNaukowy));
                scan.close();
                break;
            }
            case "3":{

                System.out.println("Podaj kierunek: ");
                String kierunek = scan.nextLine();

                System.out.println("Podaj wydział: ");
                String wydział = scan.nextLine();

                System.out.println("Podaj numer indeksu:");
                int numerIndeksu = scan.nextInt();
                scan.nextLine();

                osoby.add(new Student(imie, nazwisko, PESEL, wiek, wzrost, waga, kierunek, wydział, numerIndeksu, new ArrayList<Kursy>()));
                scan.close();
                break;
            }
        }
    }

    public static void wypiszOsoby(ArrayList<?> osoby){
        for (int i = 0; i < osoby.size(); i++) {
            if (osoby.get(i) != null){
                System.out.println(osoby.get(i));
            }
        }
    }

    public static void usuńOsobę(ArrayList<Osoba> osoby, int index){
        osoby.remove(index);
    }

    public static void zapisz(ArrayList<Osoba> osoby){
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Osoby.ser"))) {
            os.writeObject(osoby);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void dodajKursStudentowi(ArrayList<Osoba> osoby, Scanner scan){
        boolean czyStudentNieIstnieje = true;

        System.out.println("Podaj numer pesel studenta, któremu chcesz dodać kurs:");

        String numer = scan.nextLine();

        for (Osoba os: osoby){
            if (os instanceof Student){
                if (Integer.toString(os.getPESEL()).equals(numer)){
                    czyStudentNieIstnieje = false;

                    System.out.println("Podaj liczbę kursów do dodania:");
                    int liczba = scan.nextInt();
                    scan.nextLine();

                    for (int i = 0; i < liczba; i++) {

                        System.out.println("Podaj nazwę kursu:");
                        String nazwa = scan.nextLine();

                        System.out.println("Podaj ilość punktów ECTS kursu:");
                        int punkty = scan.nextInt();
                        scan.nextLine();

                        System.out.println("Czy kurs kończy się egzaminem?");

                        String wybór = scan.nextLine();

                        if (wybór.equals("tak")){
                            ((Student) os).dodajKurs(new Kursy(nazwa, punkty, true));
                        }
                        else if (wybór.equals("nie")){
                            ((Student) os).dodajKurs(new Kursy(nazwa, punkty, false));
                        }
                        else {
                            System.out.println("Przykro mi, ale nie jestem w stanie powiedzieć czy kurs kończy się egzaminem. Spróbuj ponownie");
                        }
                    }
                }
            }
        }
        if (czyStudentNieIstnieje) {
            System.out.println("Przykro mi, ale nie istnieje student o danym PESELU.");
        }
    }

    public static void sortuj(ArrayList<Osoba> osoby, Scanner scan){
        System.out.println("Wybierz opcję sortowania:");
        System.out.println("1 - po imieniu");
        System.out.println("2 - po nazwisku");
        System.out.println("3 - po nazwisku i imieniu");
        System.out.println("4 - po wieku");
        System.out.println("5 - po zarobkach (opcja dla pracowników)");
        System.out.println("6 - po stażu pracy (opcja dla pracowników)");
        System.out.println("7 - kursy po nazwach dla wyszukanego po indeksie studenta");
        System.out.println("8 - powrót");

        String wybor = scan.nextLine();

        ComparatorOsob comparatorOsob = new ComparatorOsob();

        switch (wybor){
            case "1" -> {
                sortujOsoby(osoby, comparatorOsob.getCompare_imie());
            }
            case "2" -> {
                sortujOsoby(osoby, comparatorOsob.getCompare_nazwisko());
            }
            case "3" -> {
                sortujOsoby(osoby, comparatorOsob.getCompare_nazwiskoIImie());
            }
            case "4" -> {
                sortujOsoby(osoby, comparatorOsob.getCompare_wiek());
            }
            case "5" -> {
                ArrayList<Pracownik> pracownicy = listaPracowników(osoby);

                sortujPracownik(pracownicy, comparatorOsob.getCompare_zarobki());

                wypiszOsoby(pracownicy);
            }
            case "6" -> {
                ArrayList<Pracownik> pracownicy = listaPracowników(osoby);

                sortujPracownik(pracownicy, comparatorOsob.getCompare_staż());

                wypiszOsoby(pracownicy);

            }
            case "7" -> {
                boolean studentIstnieje = false;
                Student student = new Student();

                System.out.println("Podaj indeks studenta:");

                int indeks = scan.nextInt();
                scan.nextLine();


                for (Osoba o : osoby){
                    if (o instanceof Student){
                        if (((Student)o).getNumer_indeksu() == indeks){
                            student = (Student)o;
                            studentIstnieje = true;
                        }
                    }
                }

                if (studentIstnieje){
                    sortujKursy(student.getKursy(), comparatorOsob.getCompare_kursy());
                }
                else{
                    System.out.println("Student o podanym indeksie nie istnieje.");
                }

            }
        }

    }

    public static void odczytaj(){
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("Osoby.ser"))) {
            ArrayList<Osoba> odczytaneOsoby = (ArrayList<Osoba>) is.readObject();

            for (Osoba osoba : odczytaneOsoby) {
                if (osoba != null) {
                    System.out.println(osoba);
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static <T extends Comparator<Osoba>> void sortujOsoby(ArrayList<Osoba> osoby, T comparator){
        Collections.sort(osoby, comparator);
    }

    public static <T extends Comparator<Pracownik>> void sortujPracownik(ArrayList<Pracownik> osoby, T comparator){
        Collections.sort(osoby, comparator);
    }

    public static <T extends Comparator<Kursy>> void sortujKursy(ArrayList<Kursy> osoby, T comparator){
        Collections.sort(osoby, comparator);
    }

    public static ArrayList<Pracownik> listaPracowników(ArrayList<Osoba> osoby){
        ArrayList<Pracownik> pracownicy = new ArrayList<>();

        for (Osoba o : osoby){
            if (o instanceof Pracownik){
                pracownicy.add((Pracownik) o);
            }
        }

        return pracownicy;
    }

}
