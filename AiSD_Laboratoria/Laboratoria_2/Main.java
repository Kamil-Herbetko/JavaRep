package AiSD_Laboratoria.Laboratoria_2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Karta> lista_kart = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);


        // Main loop
        boolean run = true;
        while (run){
            System.out.println("Wybierz opcję:");
            System.out.println("1 - Utworzenie listy.");
            System.out.println("2 - Wyświetlenie listy.");
            System.out.println("3 - Wyświetlenie liczby elementów listy.");
            System.out.println("4 - Wyświetlanie kart o podanej wartości.");
            System.out.println("5 - Wyświetlanie kart o podanym kolorze.");
            System.out.println("6 - Usuwanie kart powtarzających się");
            System.out.println("7 - zakończ");

            switch (scanner.nextLine().strip()){
                case "1" ->{
                    utworzenie_listy(lista_kart, random);
                }

                case "2" ->{
                    wyświetlenie_listy(lista_kart);
                }

                case "3" ->{
                    wyświetlenie_liczby_elementów_listy(lista_kart);
                }

                case "4" ->{
                    System.out.println("Podaj wartość");
                    int wartosc = get_integer(scanner, "Podaj wartość");
                    wyświetlenie_kart_o_danej_wartości(lista_kart, wartosc);
                }

                case "5" ->{
                    System.out.println("Podaj kolor");
                    int kolor = get_integer(scanner, "Podaj kolor");
                    wyświetlenie_kart_o_danym_kolorze(lista_kart, kolor);
                }

                case "6" ->{
                    usuwanie_kart_powtarzających_się(lista_kart);
                }

                case "7" ->{
                    scanner.close();
                    run = false;
                }
            }
        }
    }

    public static void utworzenie_listy(ArrayList<Karta> kartaArrayList, Random random){
        kartaArrayList.clear();
        int wartosc = 1;

        while (wartosc != 0){

            int kolor = random.nextInt(4);
            wartosc = random.nextInt(14);

            if (wartosc != 0){

                if (kartaArrayList.size() == 0){
                    kartaArrayList.add(new Karta(wartosc, kolor));
                }
                else{
                    int size = kartaArrayList.size();

                    for (int i = 0; i < size; i++) {
                        if (kartaArrayList.get(i).getWartosc() > wartosc){
                            kartaArrayList.add(i, new Karta(wartosc, kolor));
                            break;
                        }
                        else if (kartaArrayList.get(i).getWartosc() == wartosc){
                            if (kartaArrayList.get(i).getKolor() >= kolor){
                                kartaArrayList.add(i, new Karta(wartosc, kolor));
                                break;
                            }
                        }
                    }

                    if (kartaArrayList.size() == size){
                        kartaArrayList.add(new Karta(wartosc, kolor));
                    }
                }
            }
        }
    }

    public static void wyświetlenie_listy(ArrayList<Karta> kartaArrayList){
        System.out.println("| Wartość | Kolor   |");
        for (Karta karta : kartaArrayList) {
            System.out.println(karta.toString());
        }
    }

    public static void wyświetlenie_liczby_elementów_listy(ArrayList<Karta> kartaArrayList){
        System.out.println("Liczba elementów listy: " + kartaArrayList.size());
    }

    public static void wyświetlenie_kart_o_danej_wartości(ArrayList<Karta> kartaArrayList, int wartosc){
        System.out.println("| Wartość | Kolor   |");
        Iterator<Karta> iterator = kartaArrayList.iterator();
        while (iterator.hasNext()){
            Karta karta = iterator.next();
            if (karta.getWartosc() == wartosc){
                System.out.println(karta.toString());
            }
        }
    }

    public static void wyświetlenie_kart_o_danym_kolorze(ArrayList<Karta> kartaArrayList, int kolor){
        System.out.println("| Wartość | Kolor   |");
        int i = 0;

        while (i < kartaArrayList.size()){
            if (kartaArrayList.get(i).getKolor() == kolor){
                System.out.println(kartaArrayList.get(i).toString());
            }
            i++;
        }
    }

    public static void usuwanie_kart_powtarzających_się(ArrayList<Karta> kartaArrayList){
        kartaArrayList.add(0, new Karta(1, 0 ));
        kartaArrayList.add(0, new Karta(1, 0 ));
        kartaArrayList.add(0, new Karta(1, 0 ));

        int size = kartaArrayList.size();
        for (int i = 0; i < size; i++) {
            if (i != kartaArrayList.size() - 1){
                while (kartaArrayList.get(i + 1).equals(kartaArrayList.get(i))){
                    kartaArrayList.remove(kartaArrayList.get(i + 1));
                    size -= 1;
                }
            }
        }
    }

    public static int get_integer(Scanner scanner, String tekst){
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
}
