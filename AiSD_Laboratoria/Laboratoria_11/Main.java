package AiSD_Laboratoria.Laboratoria_11;

import java.io.*;
import java.text.Collator;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    static HashMap<String, Integer> mapa = new HashMap<>();

    public static void main(String[] args) throws EmptyQueueException, FullQueueException {
        Scanner scanner = new Scanner(System.in);

        RBTree<String> drzewo = new RBTree<>(new StringPL_Comparator());
        String line;
        String[] words;


        boolean run = true;
        while (run){
            System.out.println("Wybierz opcję");
            System.out.println("1 - Wczytanie tekstu z pliku i utworzenie drzewa");
            System.out.println("2 - Wyświetlenie zapisu alfabetycznie z liniami w których dane słowo wystąpiło");
            System.out.println("3 - Wyświetlanie drzewa wszerz");
            System.out.println("4 - Usuwanie słowa");
            System.out.println("5 - Zakończ");

            switch (scanner.nextLine().strip()){
                case "1" ->{
                    System.out.println("Podaj nazwę pliku z rozszerzeniem");
                    String nazwa = scanner.nextLine().strip();

                    try (BufferedReader br = new BufferedReader(new FileReader(nazwa))) {
                        drzewo = new RBTree<>(new StringPL_Comparator());
                        mapa.clear();
                        int i0 = 0;
                        while ((line = br.readLine())!= null){

                            i0++;

                            if(!line.equals("")) {
                                words = line.toLowerCase().split("[, ?.@!:();„”—]");
                                for (String word: words) {
                                    if(!word.equals("") && !word.equals("-")){

                                        if( czy_juz_byl(word) == true )
                                        {
                                            drzewo.search2(word,i0);
                                        }
                                        else
                                        {
                                            drzewo.insert(word);
                                            drzewo.search2(word,i0);
                                            mapa.put(word,1);
                                        }
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                case "2" -> drzewo.inorder();
                case "3" -> drzewo.wszerz();
                case "4" ->{
                    System.out.println("Podaj słowo które chcesz usunąć");
                    String del = drzewo.remove(scanner.nextLine().strip());
                    if (del == null) {
                        System.out.println("Nie ma takiego słowa w tekście");
                    } else {
                        System.out.println("Słowo zostało poprawnie usunięte");
                    }
                }
                case "5" ->{
                    scanner.close();
                    run = false;
                }
            }

            System.out.println();
        }
    }

    public static boolean czy_juz_byl(String s){

        for (String i : mapa.keySet()) {

            if(i.equals(s)) {
                return true;
            }
        }

        return false;

    }
    public static class StringPL_Comparator implements Comparator<String>{

        @Override
        public int compare(String o1, String o2) {
            Collator c = Collator.getInstance(new Locale("pl", "PL"));
            return c.compare(o1, o2);
        }
    }

}