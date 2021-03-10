package PSiO_Ćwiczenia.Kolokwium;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Przydatne_metody {
    //TODO listy imion, nazwisk, pętla tworzenia obiektów
    public static final String[] imiona = {"Bartek", "Kamil", "Rafał", "Wojtek", "Wiesław", "Jakub", "Sławomir", "Ryszard", "Jerzy", "Szymon"};
    public static final String[] nazwiska = {"Nowak", "Kowalski", "Małecki", "Wiśniewski", "Rakoczy", "Kruszyna", "Wójcik", "Lewandowski", "Kamiński", "Zieliński"};

    //TODO Odczytywanie z pliku z formatowaniem
    public static void OdczytywanieZPlikuZFormatowaniem(String file){
        try(BufferedReader breader = new BufferedReader(new FileReader(file))){
            String wiersz_tekstu;
            String[] tokeny;

            while((wiersz_tekstu = breader.readLine()) != null){
                tokeny = wiersz_tekstu.split("[, ?.@!:();]");

                for (String s : tokeny) {
                    System.out.println(s);
                }

                Thread.sleep(10);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }



    //TODO Zapisywanie do pliku
    public static void ZapisywanieDoPliku(String file, String doZapisu){
        try(BufferedWriter bwriter = new BufferedWriter(new FileWriter(file))) {

            bwriter.write(doZapisu);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ZapisywanieDoPliku(String file, String doZapisu, boolean append){
        try(BufferedWriter bwriter = new BufferedWriter(new FileWriter(file, append))) {

            bwriter.write(doZapisu);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //TODO Odczytywanie z pliku
    public static void OdczytywanieZPliku(String file){
        try(BufferedReader breader = new BufferedReader(new FileReader(file))){
            while (breader.readLine() != null){
                System.out.println(breader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //TODO Serializacja
    public static <T> void zapisz(ArrayList<T> listaObiektów, String file){
        try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file))) {
            os.writeObject(listaObiektów);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> ArrayList<T> odczytaj(String file){

        ArrayList<T> listaOdczytanych = new ArrayList<T>();

        try(ObjectInputStream is = new ObjectInputStream(new FileInputStream(file))){
            listaOdczytanych = (ArrayList<T>) is.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return listaOdczytanych;
    }

    //TODO printowanie z arraylisty
    public static <T> void wyświetl(ArrayList<T> lista){
        for (T obj : lista){
            System.out.println(obj.toString());
        }
    }

    //TODO Comparator stringów, liczb, toString

    class  ComparatorStringów <T> implements Comparator<T>{
        @Override
        public int compare(T o1, T o2) {
            return 0;
        }
    }

    class ComparatorLiczb <T> implements Comparator<T>{
        @Override
        public int compare(T o1, T o2) {
            return 0;
        }
    }

    class ComparatorToString <T> implements Comparator<T>{
        @Override
        public int compare(T o1, T o2) {
            return o1.toString().compareTo(o2.toString());
        }
    }

    //TODO obsługa wyjątku przy skanowaniu liczb

    public static int odczytajIZwróć(Scanner scanner, String tekst){
        System.out.println(tekst);
        boolean pobieranieInta= true;
        int odczytany = 0;

        while (pobieranieInta){
            try {
                odczytany = scanner.nextInt();
                scanner.nextLine();
                pobieranieInta = false;
            }
            catch (InputMismatchException e){
                scanner.nextLine();
                System.out.println(tekst);
            }
        }

        return odczytany;
    }
}
