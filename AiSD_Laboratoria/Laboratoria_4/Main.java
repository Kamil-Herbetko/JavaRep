package AiSD_Laboratoria.Laboratoria_4;


import AiSD_Ćwiczenia.Ćwiczenia_3.Classes.OneWayLinkedStraightListWithHead;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int[] tablicaOdkrytych = new int[52];
        OneWayLinkedStraightListWithHead<Karta> linkedList = new OneWayLinkedStraightListWithHead<>();
        Scanner scanner = new Scanner(System.in);


        // Main loop
        boolean run = true;
        while (run){
            System.out.println("Wybierz opcję:");
            System.out.println("1 - Utworzenie listy.");
            System.out.println("2 - Wyświetlenie listy.");
            System.out.println("3 - Wyświetlenie liczby elementów listy oraz ile jest kart zakrytych i ile odkrytych.");
            System.out.println("4 - Wyświetlanie kart o podanej wartości.");
            System.out.println("5 - Wyświetlanie kart o podanym kolorze.");
            System.out.println("6 - Usuwanie kart zakrytych");
            System.out.println("7 - zakończ");

            switch (scanner.nextLine().strip()){
                case "1" ->{
                    utworzenie_listy(linkedList, tablicaOdkrytych, random);
                }

                case "2" ->{
                    wyświetlenie_listy(linkedList);
                }

                case "3" ->{
                    wyświetlenie_liczby_elementów_listy(linkedList, tablicaOdkrytych);
                }

                case "4" ->{
                    System.out.println("Podaj wartość");
                    int wartosc = get_integer(scanner, "Podaj wartość");
                    wyświetlenie_kart_o_danej_wartości(linkedList, wartosc);
                }

                case "5" ->{
                    System.out.println("Podaj kolor");
                    int kolor = get_integer(scanner, "Podaj kolor");
                    wyświetlenie_kart_o_danym_kolorze(linkedList, kolor);
                }

                case "6" ->{
                    usuwanie_kart_zakrytych(linkedList, tablicaOdkrytych);
                }

                case "7" ->{
                    scanner.close();
                    run = false;
                }
            }
        }
    }

    public static void utworzenie_listy(OneWayLinkedStraightListWithHead<Karta> linkedList, int[] tablicaOdkrytych, Random random){
        linkedList.clear();
        for (int i = 0; i < 52; i++) {
            tablicaOdkrytych[i] = 0;
        }
        int wartosc = 1;

        while (wartosc != 0){

            int kolor = random.nextInt(4);
            wartosc = random.nextInt(15);

            if (wartosc != 0){
                if (wartosc == 14){
                    linkedList.insert(new Karta(wartosc, kolor));
                }

                else if (linkedList.size() == 0){
                    tablicaOdkrytych[(wartosc-1) + (kolor)*13] = 1;
                    linkedList.insert(new Karta(wartosc, kolor));
                }

                else{
                    if (tablicaOdkrytych[(wartosc-1) + (kolor)*13] == 0) {
                        tablicaOdkrytych[(wartosc-1) + (kolor)*13] = 1;
                        int size = linkedList.size();

                        for (int i = 0; i < size; i++) {
                            Karta karta = linkedList.get(i);
                            if (karta.getWartosc() > wartosc){
                                linkedList.insert(i, new Karta(wartosc, kolor));
                                break;
                            }
                            else if (karta.getWartosc() == wartosc){
                                if (karta.getKolor() >= kolor){
                                    linkedList.insert(i, new Karta(wartosc, kolor));
                                    break;
                                }
                            }
                        }

                        if (linkedList.size() == size){
                            linkedList.insert(new Karta(wartosc, kolor));
                        }
                    }
                }
            }
        }
    }

    public static void wyświetlenie_listy(OneWayLinkedStraightListWithHead<Karta> linkedList){
        System.out.println("| Wartość | Kolor   |");
        Iterator<Karta> iterator = linkedList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
    }

    public static void wyświetlenie_liczby_elementów_listy(OneWayLinkedStraightListWithHead<Karta> linkedList, int[] tablicaOdkrytych){
        int liczbaOdkrytych = 0;
        int size = linkedList.size();
        for (int i = 0; i < 52; i++) {
            liczbaOdkrytych += tablicaOdkrytych[i];
        }
        System.out.println("Liczba elementów listy: " + size);
        System.out.println("Liczba elementów zakrytych: " + (size - liczbaOdkrytych));
        System.out.println("Liczba elementów odkrytych: " + liczbaOdkrytych);
    }

    public static void wyświetlenie_kart_o_danej_wartości(OneWayLinkedStraightListWithHead<Karta> linkedList, int wartość){
        System.out.println("| Wartość | Kolor   |");
        Iterator<Karta> iterator = linkedList.iterator();
        while (iterator.hasNext()){
            Karta next = iterator.next();
            if (next.getWartosc() == wartość){
                System.out.println(next.toString());
            }
        }
    }

    public static void wyświetlenie_kart_o_danym_kolorze(OneWayLinkedStraightListWithHead<Karta> linkedList, int kolor){
        System.out.println("| Wartość | Kolor   |");
        Iterator<Karta> iterator = linkedList.iterator();
        while (iterator.hasNext()){
            Karta next = iterator.next();
            if ((next.getWartosc() != 14) && (next.getKolor() == kolor)){
                System.out.println(next.toString());
            }
        }
    }

    public static void usuwanie_kart_zakrytych(OneWayLinkedStraightListWithHead<Karta> linkedList, int[] tablicaOdkrytych){
        int liczbaOdkrytych = 0;
        for (int i = 0; i < 52; i++) {
            liczbaOdkrytych += tablicaOdkrytych[i];
        }

        while (linkedList.size() != liczbaOdkrytych){
            linkedList.delete(liczbaOdkrytych);
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
