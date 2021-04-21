package AiSD_Laboratoria.Laboratoria_5;

import AiSD_Ćwiczenia.Ćwiczenia_2_2.Exceptions.EmptyStackException;
import AiSD_Ćwiczenia.Ćwiczenia_3.Classes.TwoWayCycledListWithSentinel;
import AiSD_Ćwiczenia.Ćwiczenia_3.Zadania.ListStack;

import java.io.*;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws EmptyStackException {
        Random random = new Random();
        TwoWayCycledListWithSentinel<Auto> listaSamochodow = new TwoWayCycledListWithSentinel<>();
        Scanner scanner = new Scanner(System.in);
        String[] marki = {"BMW", "Mercedes", "Ford", "Fiat", "Nissan", "Opel", "Dodge", "Audi", "Volkswagen", "Skoda", "Dacia", "Volvo", "Lexus", "Bugatti", "Porsche"};
        String[] typ = {"SUV", "Coupe", "Hatchback", "Sedan", "Kabriolet", "Combi", "Van", "Liftback", "Minivan"};
        String[] kolory = {"Niebieski", "Czerwony", "Żółty", "Pomarańczowy", "Zielony", "Szary", "Czarny", "Biały", "Bordowy", "Szmaragdowy", "Fioletowy", "Różowy", "Grafitowy"};

        // Main loop
        boolean run = true;
        while (run){
            System.out.println("Wybierz opcję:");
            System.out.println("1 - Utworzenie nowej bazy danych.");
            System.out.println("2 - Odczyt bazy z pliku.");
            System.out.println("3 - Wyświetlenie wszystkich rekordów.");
            System.out.println("4 - Wyświetlanie danych jednego samochodu.");
            System.out.println("5 - Dopisanie nowego samochodu.");
            System.out.println("6 - Usunięcie samochodu z bazy");
            System.out.println("7 - Aktualizowanie bazy danych");
            System.out.println("8 - Wyświetlanie danych samochodu o podanej marce.");
            System.out.println("9 - Wyświetlanie danych samochodów, wyprodukowanych w podanym roku.");
            System.out.println("10 - Wyświetlenie danych samochodów o cenach poniżej podanej.");
            System.out.println("11 - Zapis bazy do pliku.");
            System.out.println("12 - Wyjazd z parkingu do kupionego samochodu");
            System.out.println("13 - Zakończ");

            switch (scanner.nextLine().strip()){
                case "1" ->{
                    utworzenieListy(listaSamochodow, random, marki, typ, kolory);
                }
                case "2" -> {
                    listaSamochodow = odczytZPliku();
                }
                case "3" -> {
                    wyswietlWszystkie(listaSamochodow);
                }
                case "4" -> {
                    wyswietlJeden(listaSamochodow, scanner);
                }
                case "5" -> {
                    dopisanieSamochodu(listaSamochodow,scanner);
                }
                case "6" -> {
                    usunZBazy(listaSamochodow, scanner);
                }
                case "7" -> {
                    aktualizowanieSamochodu(listaSamochodow, scanner);
                }
                case "8" -> {
                    wyswietlanieOPodanejMarce(listaSamochodow, scanner);
                }
                case "9" -> {
                    wyswietlanieOPodanymRoku(listaSamochodow, scanner);
                }
                case "10" -> {
                    wyswietlanieOCenieNizszejNizPodana(listaSamochodow, scanner);
                }
                case "11" -> {
                    zapisDoPliku(listaSamochodow);
                }
                case "12" -> {
                    autaDoWyjechania(listaSamochodow, scanner);
                }
                case "13" -> {
                    run = false;
                    scanner.close();
                    return;
                }
            }

            System.out.println();
        }
    }

    public static void utworzenieListy(TwoWayCycledListWithSentinel<Auto> listaSamochodow, Random random, String[] marki, String[] typ, String[] kolory){
        Auto.number = 0;
        listaSamochodow.clear();
        for (int i = 0; i < 40 + random.nextInt(40); i++) {
            Auto auto = new Auto(marki[random.nextInt(marki.length)], typ[random.nextInt(typ.length)], 1990 + random.nextInt(32), 5000 + random.nextInt(900000), kolory[random.nextInt(kolory.length)], random.nextInt(25));
            listaSamochodow.insert(auto);
        }
    }

    public static void wyswietlWszystkie(TwoWayCycledListWithSentinel<Auto> listaSamochodow){
        Iterator<Auto> iterator = listaSamochodow.iterator();
        System.out.printf("| %-13s | %-11s | %-9s | %-14s | %-6s | %-12s | %-11s | %-9s |%n", "Numer silnika", "Marka", "Typ", "Data produkcji", "Cena", "Kolor", "Składowanie", "Przecena");
        while (iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
    }

    public static void wyswietlJeden(TwoWayCycledListWithSentinel<Auto> listaSamochodow, Scanner scanner){
        System.out.println("Podaj numer silnika samochodu który chcesz wyświetlić");
        int numer = get_integer(scanner, "Podaj numer silnika samochodu który chcesz wyświetlić");
        Iterator<Auto> iterator = listaSamochodow.iterator();
        while (iterator.hasNext()){
            Auto auto = iterator.next();
            if (auto.getNR_SILNIKA() == numer){
                System.out.println(auto.toString());
            }

        }
    }

    public static void dopisanieSamochodu(TwoWayCycledListWithSentinel<Auto> listaSamochodow, Scanner scanner){
        System.out.println("Podaj markę samochodu");
        String marka = scanner.nextLine().strip();

        System.out.println("Podaj typ samochodu");
        String typ = scanner.nextLine().strip();

        System.out.println("Podaj datę produkcji samochodu");
        int data = get_integer(scanner, "Podaj datę produkcji samochodu");

        System.out.println("Podaj cenę samochodu");
        int cena = get_integer(scanner, "Podaj cenę samochodu");

        System.out.println("Podaj kolor samochodu");
        String kolor = scanner.nextLine().strip();

        System.out.println("Podaj czas składowania samochodu");
        int czas = get_integer(scanner, "Podaj czas składowania samochodu");

        listaSamochodow.insert(new Auto(marka, typ, data, cena, kolor, czas));
    }

    public static void usunZBazy(TwoWayCycledListWithSentinel<Auto> listaSamochodow, Scanner scanner){
        System.out.println("Podaj numer silnika samochodu który chcesz usunąć");
        int numer = get_integer(scanner, "Podaj numer silnika samochodu który chcesz usunąć");
        Iterator<Auto> iterator = listaSamochodow.iterator();
        while (iterator.hasNext()){
            Auto auto = iterator.next();
            if (auto.getNR_SILNIKA() == numer){
                listaSamochodow.delete(auto);
                return;
            }
        }
        System.out.println("Nie znaleziono samochodu o podanym numerze silnika");
    }

    public static void aktualizowanieSamochodu(TwoWayCycledListWithSentinel<Auto> listaSamochodow, Scanner scanner){
        System.out.println("Podaj numer silnika samochodu który chcesz zaktualizować");
        int numer = get_integer(scanner, "Podaj numer silnika samochodu który chcesz zaktualizować");
        Iterator<Auto> iterator = listaSamochodow.iterator();
        while (iterator.hasNext()){
            Auto auto = iterator.next();
            if (auto.getNR_SILNIKA() == numer){
                boolean run = true;
                while (run){
                    System.out.println("Wybierz cechę do zaktualizowania:");
                    System.out.println("1 - Marka");
                    System.out.println("2 - Typ");
                    System.out.println("3 - Data produkcji");
                    System.out.println("4 - Cena");
                    System.out.println("5 - Kolor");
                    System.out.println("6 - Czas składowania");
                    System.out.println("7 - Powrtót");

                    String wybór = scanner.nextLine().strip();
                    switch (wybór){
                        case "1" -> {
                            System.out.println("Podaj markę");
                            auto.setMarka(scanner.nextLine().strip());
                        }
                        case "2" -> {
                            System.out.println("Podaj typ");
                            auto.setTyp(scanner.nextLine().strip());
                        }
                        case "3" -> {
                            System.out.println("Podaj datę produkcji");
                            auto.setData_produkcji(get_integer(scanner, "Podaj datę produkcji"));
                        }
                        case "4" -> {
                            System.out.println("Podaj cenę");
                            auto.setCena(get_integer(scanner, "Podaj cenę"));
                            auto.setPrzecena();
                        }
                        case "5" -> {
                            System.out.println("Podaj kolor");
                            auto.setKolor(scanner.nextLine().strip());
                        }
                        case "6" -> {
                            System.out.println("Podaj czas składowania");
                            auto.setSkladowanie(get_integer(scanner, "Podaj czas składowania"));
                            auto.setPrzecena();
                        }
                        case "7" -> {
                            return;
                        }
                    }
                    System.out.println();
                }
            }
        }
        System.out.println("Nie znaleziono samochodu o podanym numerze silnika");
    }

    public static void wyswietlanieOPodanejMarce(TwoWayCycledListWithSentinel<Auto> listaSamochodow, Scanner scanner){
        System.out.println("Podaj markę samochodów które chcesz wyświetlić");
        String marka = scanner.nextLine().strip();
        Iterator<Auto> iterator = listaSamochodow.iterator();

        while (iterator.hasNext()){
            Auto auto = iterator.next();
            if (auto.getMarka().equals(marka)){
                System.out.println(auto.toString());
            }
        }
    }

    public static void wyswietlanieOPodanymRoku(TwoWayCycledListWithSentinel<Auto> listaSamochodow, Scanner scanner){
        System.out.println("Podaj rok produkcji samochodów które chcesz wyświetlić");
        int data = get_integer(scanner, "Podaj rok produkcji samochodów które chcesz wyświetlić");
        Iterator<Auto> iterator = listaSamochodow.iterator();

        while (iterator.hasNext()){
            Auto auto = iterator.next();
            if (auto.getData_produkcji() == data){
                System.out.println(auto.toString());
            }
        }
    }

    public static void wyswietlanieOCenieNizszejNizPodana(TwoWayCycledListWithSentinel<Auto> listaSamochodow, Scanner scanner){
        System.out.println("Podaj cenę poniżej której samochody chcesz wyświetlić");
        int cena = get_integer(scanner, "Podaj cenę poniżej której samochody chcesz wyświetlić");

        Iterator<Auto> iterator = listaSamochodow.iterator();

        while (iterator.hasNext()){
            Auto auto = iterator.next();
            if (auto.getPrzecena() < cena){
                System.out.println(auto.toString());
            }
        }
    }

    public static TwoWayCycledListWithSentinel<Auto> odczytZPliku(){
        TwoWayCycledListWithSentinel<Auto> lista = new TwoWayCycledListWithSentinel<>();

        try(ObjectInputStream is = new ObjectInputStream(new FileInputStream("lista.ser"))) {
            Auto.number = is.read();
            lista = (TwoWayCycledListWithSentinel<Auto>) is.readObject();



        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public static void zapisDoPliku(TwoWayCycledListWithSentinel<Auto> listaSamochodow){
        try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("lista.ser"))) {
            os.write(Auto.number);
            os.writeObject(listaSamochodow);


        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public static void autaDoWyjechania(TwoWayCycledListWithSentinel<Auto> listaSamochodow, Scanner scanner) throws EmptyStackException {
        if (!listaSamochodow.isEmpty()){
            ListStack<Auto> parking = new ListStack<>();
            ListStack<Auto> wyjechane = new ListStack<>();
            Iterator<Auto> iterator = listaSamochodow.iterator();
            while (iterator.hasNext()){
                parking.push(iterator.next());
            }

            System.out.println("Podaj numer silnika kupionego samochodu");
            int numer = get_integer(scanner, "Podaj numer silnika kupionego samochodu");
            String wyjazd = "Muszą wyjechać samochody w podanej kolejności o numerach: ";
            String powrót = "Następnie muszą wrócić samochody w podanej kolejności o numerach: ";

            while (parking.top().getNR_SILNIKA() > numer){
                Auto auto = parking.pop();
                wyjazd += auto.getNR_SILNIKA() + " ";
                wyjechane.push(auto);
            }
            System.out.println(wyjazd);

            while (!wyjechane.isEmpty()){
                powrót += wyjechane.pop().getNR_SILNIKA() + " ";
            }
            System.out.println(powrót);

        }



    }

}
