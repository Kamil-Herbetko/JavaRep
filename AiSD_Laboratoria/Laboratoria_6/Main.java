package AiSD_Laboratoria.Laboratoria_6;

import AiSD_Ćwiczenia.Ćwiczenia_2_2.Exceptions.EmptyQueueException;
import AiSD_Ćwiczenia.Ćwiczenia_2_2.Exceptions.FullQueueException;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FullQueueException, EmptyQueueException {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        Magazyn magazyn = new Magazyn(new String[]{}, new String[][]{}, new int[][]{}, new double[][]{});
        Firma firma = new Firma(new String[][]{}, new String[][][]{}, new int[][][]{}, new double[][][]{});

        String[] tablicaNazwKlientów = {"BMW", "Mercedes", "Ford", "Fiat", "Nissan", "Opel", "Dodge", "Audi", "Volkswagen", "Skoda", "Dacia", "Volvo", "Lexus", "Bugatti", "Porsche"};
        String[] tablicaNazwTowarów = {"SUV", "Coupe", "Hatchback", "Sedan", "Kabriolet", "Combi", "Van", "Liftback", "Minivan"};

        // Main loop
        boolean run = true;
        while (run) {
            System.out.println("Wybierz opcję:");
            System.out.println("1 - Utworzenie nowej firmy.");
            System.out.println("2 - Utworzenie nowego magazynu.");
            System.out.println("3 - Wyświetlenie dochodu magazynu.");
            System.out.println("4 - Wyświetlanie dochodu firmy.");
            System.out.println("5 - Dodanie klienta do magazynu.");
            System.out.println("6 - Dodanie magazynu do firmy.");
            System.out.println("7 - Dodanie klienta do magazynu firmy.");
            System.out.println("8 - Zakończ.");
            switch (scanner.nextLine().strip()) {
                case "1" -> {
                    utworzenieFirmy(firma, random, tablicaNazwKlientów, tablicaNazwTowarów);
                }
                case "2" -> {
                    utworzenieMagazynu(magazyn, random, tablicaNazwKlientów, tablicaNazwTowarów);
                }
                case "3" -> {
                    wyswietlDochódMagazynu(magazyn);
                }
                case "4" -> {
                    wyswietlDochódFirmy(firma);
                }
                case "5" -> {
                    dodanieKlientaDoMagazynu(magazyn, scanner);
                }
                case "6" -> {
                    dodanieMagazynuDoFirmy(firma, scanner);
                }
                case "7" -> {
                    dodanieKlientaDoMagazynuFirmy(firma, scanner);
                }
                case "8" -> {
                    run = false;
                    scanner.close();
                    return;
                }
            }

            System.out.println();
        }
    }

    public static void utworzenieFirmy(Firma firma, Random random, String[] tablicaNazwKlientów, String[] tablicaNazwTowarów) throws FullQueueException {
        firma.getMagazyny().clear();

        for (int i = 0; i < random.nextInt(5) + 3; i++) {
            Magazyn magazyn = new Magazyn(new String[]{}, new String[][]{}, new int[][]{}, new double[][]{});
            for (int j = 0; j < random.nextInt(5) + 1; j++) {
                Klient klient = new Klient(tablicaNazwKlientów[random.nextInt(15)], new String[]{},  new int[]{}, new double[]{});
                for (int k = 0; k < random.nextInt(5) + 1; k++) {
                    klient.getZamówienia().enqueue(new Zamówienie(tablicaNazwTowarów[random.nextInt(9)], random.nextInt(10) + 1, random.nextDouble() * 100000 + 10000));
                }
                magazyn.getLista_klientów().enqueue(klient);
            }
            firma.getMagazyny().add(magazyn);
        }
    }

    public static void utworzenieMagazynu(Magazyn magazyn, Random random, String[] tablicaNazwKlientów, String[] tablicaNazwTowarów) throws EmptyQueueException, FullQueueException {
        while (!magazyn.getLista_klientów().isEmpty()){
            magazyn.getLista_klientów().dequeue();
        }
        for (int j = 0; j < random.nextInt(10) + 1; j++) {
            Klient klient = new Klient(tablicaNazwKlientów[random.nextInt(15)], new String[]{},  new int[]{}, new double[]{});
            for (int k = 0; k < random.nextInt(10) + 1; k++) {
                klient.getZamówienia().enqueue(new Zamówienie(tablicaNazwTowarów[random.nextInt(9)], random.nextInt(10) + 1, random.nextDouble() * 100000 + 10000));
            }
            magazyn.getLista_klientów().enqueue(klient);
        }
    }

    public static void wyswietlDochódMagazynu(Magazyn magazyn) throws EmptyQueueException {
        double kwota = magazyn.zrealizuj();
        System.out.println("Przychód z magazynu wynosi: " + kwota);
    }

    public static void wyswietlDochódFirmy(Firma firma) throws EmptyQueueException {
        firma.oblicz_przychody();
    }

    public static void dodanieKlientaDoMagazynu(Magazyn magazyn, Scanner scanner) throws FullQueueException {
        System.out.println("Podaj nazwę klienta");
        String nazwa = scanner.nextLine().strip();
        System.out.println("Podaj liczbę zamówień");
        int liczbaZam = get_integer(scanner, "Podaj liczbę zamówień");
        Klient klient = new Klient(nazwa, new String[]{}, new int[]{}, new double[]{});

        for (int i = 0; i < liczbaZam; i++) {
            System.out.println("Podaj nazwę produktu");
            String nazwaZam = scanner.nextLine().strip();
            System.out.println("Podaj ilość sztuk");
            int liczbaSzt = get_integer(scanner, "Podaj ilość sztuk");
            System.out.println("Podaj cenę jednostkową");
            double cenaJed = get_double(scanner, "Podaj cenę jednostkową");
            klient.getZamówienia().enqueue(new Zamówienie(nazwaZam, liczbaSzt, cenaJed));
        }

        magazyn.getLista_klientów().enqueue(klient);
    }

    public static void dodanieMagazynuDoFirmy(Firma firma, Scanner scanner) throws FullQueueException {
        Magazyn magazyn = new Magazyn(new String[]{}, new String[][]{}, new int[][]{}, new double[][]{});
        System.out.println("Podaj liczbę klientów w magazynie");
        int liczbaKlin = get_integer(scanner, "Podaj liczbę klientów w magazynie");

        for (int i = 0; i < liczbaKlin; i++) {
            dodanieKlientaDoMagazynu(magazyn, scanner);
        }

        firma.getMagazyny().add(magazyn);
    }

    public static void dodanieKlientaDoMagazynuFirmy(Firma firma, Scanner scanner) throws FullQueueException {
        int iloscMag = firma.getMagazyny().size();
        System.out.println("Wybierz do którego magazynu chcesz dodać klienta. Firma posiada ich " + iloscMag);
        int wybór = get_integer(scanner, "Wybierz do którego magazynu chcesz dodać klienta. Firma posiada ich " + iloscMag, iloscMag) - 1;
        dodanieKlientaDoMagazynu(firma.getMagazyny().get(wybór), scanner);
    }

    public static int get_integer(Scanner scanner, String tekst){
        int integer = 0;
        boolean loop = true;

        while (loop){
            try {
                integer = scanner.nextInt();
                if (integer < 0){
                    throw new IllegalArgumentException();
                }
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

    public static int get_integer(Scanner scanner, String tekst, int bound){
        int integer = 0;
        boolean loop = true;

        while (loop){
            try {
                integer = scanner.nextInt();
                if ((integer < 1) && (integer <= bound)){
                    throw new IllegalArgumentException();
                }
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


    public static double get_double(Scanner scanner, String tekst){
        double doub = 0.0;
        boolean loop = true;

        while (loop){
            try {
                doub = scanner.nextDouble();
                if (doub < 0){
                    throw new IllegalArgumentException();
                }
                scanner.nextLine();
                loop = false;
            }
            catch (Exception e) {
                scanner.nextLine();
                System.out.println();
                System.out.println(tekst);
            }
        }

        return doub;
    }
}
