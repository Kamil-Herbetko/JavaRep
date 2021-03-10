package AiSD_Laboratoria.Laboratoria_1;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Pracownik[] tabPracowników = new Pracownik[100];
        String[] nazwiska = {"Kowalski", "Nowak", "Wiśniewski", "Morzymas", "Michalski", "Stankiewicz", "Lewandowski", "Wójcik", "Kowalczyk", "Szymański", "Kamiński", "Woźniak"};
        String[] imiona = {"Jan", "Szymon", "Michał", "Artur", "Jakub", "Mateusz", "Adam", "Witold", "Mikołaj", "Marcin", "Cyprian", "Piotr", "Kamil"};
        String[] stanowsika = {"Księgowy", "Nauczyciel", "Urzędnik", "Prawnik", "Informatyk", "Wykładowca", "Menadżer", "Sprzedawca", "Lekarz", "Malarz", "Ksiądz", "Przewodnik"};
        Double[] etaty = {0.25, 0.5, 0.75, 1.0};

        for (int i = 0; i < 90; i++) {
            Random random = new Random();
            if (random.nextInt(2) == 1) {
                tabPracowników[i] = new PracownikEtatowy(nazwiska[random.nextInt(nazwiska.length)], imiona[random.nextInt(imiona.length)], 10000000000L + (long) (Math.random() * (99999999999L - 10000000000L)), stanowsika[random.nextInt(stanowsika.length)], random.nextInt(30), etaty[random.nextInt(etaty.length)], random.nextDouble() * 20000 + 1000);
            } else {
                tabPracowników[i] = new PracownikGodzinowy(nazwiska[random.nextInt(nazwiska.length)], imiona[random.nextInt(imiona.length)], 10000000000L + (long) (Math.random() * (99999999999L - 10000000000L)), stanowsika[random.nextInt(stanowsika.length)], random.nextInt(30), random.nextDouble() * 118 + 14, random.nextInt(120) + 40);
            }
        }




        // main loop
        boolean run = true;
        while (run){
            System.out.println("Wybierz opcję:");
            System.out.println("1 - utworzenie pracownika");
            System.out.println("2 - wyświetlanie pracowników");
            System.out.println("3 - zapisz do pliku");
            System.out.println("4 - odczytaj z pliku i wyświetl");
            System.out.println("5 - zakończ");

            Scanner scanner = new Scanner(System.in);

            switch (scanner.nextLine().strip()){
                case "1" ->{
                    dodaj_pracownika(tabPracowników, scanner);
                    System.out.println();
                }
                case "2" ->{
                    wyświetl(tabPracowników);
                    System.out.println();
                }
                case "3" ->{
                    zapisz(tabPracowników);
                    System.out.println();
                }
                case "4" ->{
                    odczytajIwyświetl();
                    System.out.println();
                }
                case "5" ->{
                    run = false;
                    scanner.close();
                    System.out.println();
                }

            }
        }

    }

    public static void dodaj_pracownika(Pracownik[] tabPracowników, Scanner scanner){
        if (policzPracowników(tabPracowników) == tabPracowników.length){
            System.out.println("Tablica pełna");
        }
        else {
            System.out.println("Jakiego pracownika chcesz utworzyć?");
            System.out.println("1 - pracownik etatowy");
            System.out.println("2 - pracownik godzinowy");
            System.out.println("3 - powrót");

            String wybór = scanner.nextLine().strip();

            System.out.println("Podaj nazwisko");
            String nazwisko = scanner.nextLine();
            System.out.println("Podaj imię");
            String imie = scanner.nextLine();
            System.out.println("Podaj pesel");
            long pesel = pesel(scanner, "Podaj pesel");
            System.out.println("Podaj stanowisko");
            String stanowisko = scanner.nextLine();
            System.out.println("Podaj staż");
            int staż = integer(scanner, "Podaj staż");
            System.out.println("Podaj stawkę");
            double stawka = aDouble(scanner, "Podaj stawkę");

            switch (wybór) {
                case "1" -> {
                    System.out.println("Podaj etat");
                    double etat = aDouble(scanner, "Podaj etat");
                    tabPracowników[policzPracowników(tabPracowników)] = new PracownikEtatowy(nazwisko, imie, pesel, stanowisko, staż, etat, stawka);
                }
                case "2" ->{
                    System.out.println("Podaj liczbę godzin");
                    int liczba_godzin = integer(scanner, "Podaj liczbę godzin");
                    tabPracowników[policzPracowników(tabPracowników)] = new PracownikGodzinowy(nazwisko, imie, pesel, stanowisko, staż, stawka, liczba_godzin);
                }
            }
        }
    }


    public static void zapisz(Pracownik[] pracownicy){

        try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Pracownicy.ser"))) {
            os.writeObject(policzPracowników(pracownicy));

            for (int i = 0; i < pracownicy.length; i++) {
                if (pracownicy[i] != null){
                    os.writeObject(pracownicy[i]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int policzPracowników(Pracownik[] pracownicy){
        int ilość = 0;

        for (int i = 0; i < pracownicy.length; i++) {
            if (pracownicy[i] != null){
                ilość += 1;
            }
        }

        return ilość;
    }

    public static void odczytajIwyświetl(){
        try(ObjectInputStream is = new ObjectInputStream(new FileInputStream("Pracownicy.ser"))) {
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("| %-25s | %-15s | %-11s | %-15s | %-7s | %-10s | %n", "Nazwisko", "Imię", "Pesel", "Stanowisko", "Staż", "Pensja");
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

            int liczbaObiektów = (int) is.readObject();

            for (int i = 0; i < liczbaObiektów; i++) {
                System.out.println(((Pracownik) is.readObject()).toString());
            }

            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void wyświetl(Pracownik[] pracownicy){
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-25s | %-15s | %-11s | %-15s | %-7s | %-10s | %n", "Nazwisko", "Imię", "Pesel", "Stanowisko", "Staż", "Pensja");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        IteratorTablicy iteratorTablicy = new IteratorTablicy(pracownicy);
        while (iteratorTablicy.hasNext()){
            System.out.println(iteratorTablicy.next().toString());
        }

        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public static long pesel(Scanner scanner, String tekst){
        long pesel = 0l;
        boolean loop = true;

        while (loop){
            try {
                pesel = scanner.nextLong();
                scanner.nextLine();
                loop = false;
            }
            catch (Exception e) {
                scanner.nextLine();
                System.out.println();
                System.out.println(tekst);
            }
        }

        return pesel;
    }

    public static int integer(Scanner scanner, String tekst){
        int integer = 0;
        boolean loop = true;

        while (loop){
            try {
                integer = scanner.nextInt();
                scanner.nextLine();
                loop = false;
            }
            catch (Exception e) {
                scanner.nextLine();
                System.out.println();
                System.out.println(tekst);
            }
        }

        return integer;
    }

    public static double aDouble(Scanner scanner, String tekst){
        double adouble = 0.0;
        boolean loop = true;

        while (loop){
            try {
                adouble = scanner.nextDouble();
                scanner.nextLine();
                loop = false;
            }
            catch (Exception e) {
                scanner.nextLine();
                System.out.println();
                System.out.println(tekst);
            }
        }

        return adouble;
    }
}
