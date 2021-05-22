package AiSD_Laboratoria.Laboratoria_10;

import AiSD_Ćwiczenia.Ćwiczenia_2_2.Exceptions.EmptyQueueException;
import AiSD_Ćwiczenia.Ćwiczenia_2_2.Exceptions.FullQueueException;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FullQueueException, EmptyQueueException {
        Scanner scanner = new Scanner(System.in);
        String tekst = "";
        String znaki = "";
        String zakodowany_tekst = "";
        ArrayList<Integer> wagi_znaków = new ArrayList<>();
        ArrayList<String> kody_znaków = new ArrayList<>();
        Node root = null;
        SortedPriorityQueue priorityQueue;

        boolean run = true;
        while (run){
            System.out.println("Wybierz opcję");
            System.out.println("1 - Wczytanie tekstu z pliku");
            System.out.println("2 - Utworzenie drzewa, prezentacja i zapis zakodowanego tekstu do pliku");
            System.out.println("3 - Odkodowanie tekstu z użyciem drzewa");
            System.out.println("4 - Wyjście");

            switch (scanner.nextLine().strip()){
                case "1" ->{
                    System.out.println("Podaj nazwę pliku");
                    String filename = scanner.nextLine().strip();

                    File plik = new File(filename);

                    try(BufferedReader breader = new BufferedReader(new FileReader(plik))) {
                        tekst = "";
                        znaki = "";
                        wagi_znaków.clear();
                        String wierszTekstu = "";

                        while ((wierszTekstu = breader.readLine()) != null){
                            tekst+= wierszTekstu;
                        }

                        for (int i = 0; i < tekst.length(); i++) {
                            char znak = tekst.charAt(i);
                            if (znaki.indexOf(znak) < 0){
                                znaki += znak;
                                wagi_znaków.add(1);
                            }
                            else {
                                int ilość = wagi_znaków.get(znaki.indexOf(znak));
                                wagi_znaków.set(znaki.indexOf(znak), ilość + 1);
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
                case "2" ->{
                    kody_znaków.clear();
                    zakodowany_tekst = "";
                    System.out.println("Podaj nazwę pliku");
                    String filename = scanner.nextLine().strip();
                    File plik = new File(filename);

                    priorityQueue = new SortedPriorityQueue(tekst.length() + 1);
                    for (int i = 0; i < znaki.length(); i++) {
                        priorityQueue.enqueue(new Node(Character.toString(znaki.charAt(i)), wagi_znaków.get(i)));
                    }

                    while (priorityQueue.size() > 1){
                        Node one = priorityQueue.dequeue();
                        Node two = priorityQueue.dequeue();
                        Node combined = new Node(one.getChars() + two.getChars(), one.getWeight() + two.getWeight(), one, two);
                        priorityQueue.enqueue(combined);
                    }
                    root = priorityQueue.dequeue();

                    for (int i = 0; i < znaki.length(); i++) {
                        String kod = "";
                        char znak = znaki.charAt(i);
                        Node elem = root;
                        while ((elem.getLeft() != null) || (elem.getRight() != null)){
                            if ((elem.getLeft() != null) && (elem.getLeft().getChars().indexOf(znak) > -1)){
                                elem = elem.getLeft();
                                kod += "0";

                            }
                            else {
                                elem = elem.getRight();
                                kod += "1";
                            }
                        }
                        kody_znaków.add(kod);
                    }

                    for (int i = 0; i < tekst.length(); i++) {
                        char znak = tekst.charAt(i);
                        Node elem = root;
                        while ((elem.getLeft() != null) || (elem.getRight() != null)){
                            if ((elem.getLeft() != null) && (elem.getLeft().getChars().indexOf(znak) > -1)){
                                elem = elem.getLeft();
                                zakodowany_tekst += "0";

                            }
                            else {
                                elem = elem.getRight();
                                zakodowany_tekst += "1";
                            }
                        }
                    }

                    System.out.println("Tekst: " + tekst);
                    System.out.println("Zakodowany tekst: " + zakodowany_tekst);
                    System.out.println();
                    for (int i = 0; i < znaki.length(); i++) {
                        String znak = Character.toString(znaki.charAt(i));
                        if (znak.equals(" ")) znak = "spacja";
                        System.out.printf("%6s - %-5d %s %n", znak, wagi_znaków.get(i), kody_znaków.get(i));
                    }

                    try(BufferedWriter bwriter = new BufferedWriter(new FileWriter(plik))) {
                        bwriter.write(zakodowany_tekst);
                        bwriter.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                case "3" ->{
                    String odkodowane = "";
                    Node node = root;
                    for (int i = 0; i < zakodowany_tekst.length(); i++) {
                        String cyfra = Character.toString(zakodowany_tekst.charAt(i));
                        if ((node.getLeft() == null) && (node.getRight() == null)){
                            odkodowane += node.getChars();
                            node = root;
                        }
                        if (cyfra.equals("0")){
                            node = node.getLeft();
                        }
                        else {
                            node = node.getRight();
                        }
                    }

                    odkodowane += node.getChars();
                    System.out.println("Odkodowany tekst: " + odkodowane);
                }
                case "4" ->{
                    scanner.close();
                    run = false;
                }
            }

            System.out.println();
        }
    }
}
