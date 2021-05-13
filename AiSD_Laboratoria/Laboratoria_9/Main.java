package AiSD_Laboratoria.Laboratoria_9;

import AiSD_Laboratoria.Laboratoria_9.ONP.MyAnalayzer;
import AiSD_Laboratoria.Laboratoria_9.Tree.Tree;
import AiSD_Ćwiczenia.Ćwiczenia_2_2.Exceptions.EmptyQueueException;
import AiSD_Ćwiczenia.Ćwiczenia_2_2.Exceptions.FullQueueException;
import AiSD_Ćwiczenia.Ćwiczenia_2_2.Interfaces.IQueue;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Character[] znaki = {'+', '-', '*', '/', '%'};
        Character[] cyfry = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
        Scanner scanner = new Scanner(System.in);
        String wyrazenie = "";
        IQueue<Object> queue;
        String[] litery = {};
        Tree drzewo = new Tree();


        boolean run = true;
        while(run){
            System.out.println("Wybierz opcję:");
            System.out.println("1 - Wczytaj wyrażenie");
            System.out.println("2 - Tworzenie drzewa wyrażenia");
            System.out.println("3 - Obliczanie wyrażenia arytmetycznego zapisanego w drzewie");
            System.out.println("4 - Wyświetlanie wyrażenia w postaci infiksowej");
            System.out.println("5 - Wyświetlanie wyrażenia w postaci postfiksowej");
            System.out.println("6 - Obliczanie liczby liści");
            System.out.println("7 - Obliczanie liczby węzłów");
            System.out.println("8 - Obliczanie wysokości drzewa");
            System.out.println("9 - Wyświetlanie drzewa wszerz");
            System.out.println("10 - Wyjście");

            switch (scanner.nextLine().strip()){
                case "1" -> {
                    System.out.println("Podaj wyrażenie:");
                    wyrazenie = scanner.nextLine();
                    queue = MyAnalayzer.analize(wyrazenie);
                    String onp = MyAnalayzer.toRPNString(queue);
                    litery = onp.split(", ");
                }

                case "2" -> {
                    drzewo = new Tree();
                    drzewo.createTree(litery);
                }

                case "3" -> {
                    drzewo.calculate();
                }

                case "4" -> {
                    drzewo.wyswietlInfiks();
                }

                case "5" -> {
                    drzewo.wyswietlPostfiks();
                }

                case "6" -> {
                    drzewo.wyswietlLiscie();
                }

                case "7" -> {
                    drzewo.wyswietlWezly();
                }

                case "8" -> {
                    drzewo.wyswietlWysokosc();
                }

                case "9" -> {
                    try {
                        drzewo.przechodzenieWszerz();
                    } catch (FullQueueException e) {
                        e.printStackTrace();
                    } catch (EmptyQueueException e) {
                        e.printStackTrace();
                    }
                }

                case "10" -> {
                    scanner.close();
                    run = false;
                }
            }

            System.out.println();
        }
    }
}
