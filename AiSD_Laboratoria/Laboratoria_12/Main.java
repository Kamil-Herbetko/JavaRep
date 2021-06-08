package AiSD_Laboratoria.Laboratoria_12;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> mapaMiast = new HashMap<>();
        HashSet<String> mapaPowtorzeń = new HashSet<>();
        Graph g = null;





        boolean run = true;
        while (run) {
            System.out.println("Wybierz opcję");
            System.out.println("1 - Załadowanie danych z klawiatury i utworzenie grafu");
            System.out.println("2 - Wypisanie utworzonego grafu za pomocą list sąsiedztwa");
            System.out.println("3 - Wypisanie wszystkich miast osiągalnych z podanego oraz wypisanie długości najkrótszej drogi do nich");
            System.out.println("4 - Przechodzenie grafu w głąb");
            System.out.println("5 - Zakończ");

            switch (scanner.nextLine().strip()) {
                case "1" -> {
                    System.out.println("Podaj liczbę miast");
                    int v = get_integer(scanner, "Podaj liczbę miast");
                    System.out.println("Podaj kolejne miasta");

                    mapaMiast = new HashMap<>();
                    String[] names = new String[v];
                    for (int i = 0; i < v; i++) {
                        names[i] = scanner.nextLine().strip();
                        mapaMiast.put(names[i], i);
                    }

                    System.out.println("Podaj liczbę połączeń");
                    int a = get_integer(scanner, "Podaj liczbę połączeń");

                    boolean lrun = true;
                    int[] begin = new int[a];
                    int[] end = new int[a];
                    int[] weight = new int[a];
                    mapaPowtorzeń = new HashSet<>();

                    while (lrun){
                        lrun = false;

                        try{
                            System.out.println("Podaj kolejne połączenia w formacie: 'nr_miasta_startowego-nr_miasta_końcowego; waga', miasta wprowadzone są indeksowane od zera!");
                            for (int i = 0; i < a; i++) {
                                String[] tokens = scanner.nextLine().split("[- ;]");
                                if (!mapaPowtorzeń.contains(tokens[0] + "-" + tokens[1])){
                                    mapaPowtorzeń.add(tokens[0] + "-" + tokens[1]);
                                    begin[i] = Integer.parseInt(tokens[0]);
                                    end[i] = Integer.parseInt(tokens[1]);
                                    weight[i] = Integer.parseInt(tokens[2]);
                                }
                                else {
                                    System.out.println("Ta para miast ma już połączenie!");
                                    i--;
                                }

                            }

                        }
                        catch (Exception e){
                            System.out.println("Podaj poprawne dane!");
                            System.out.println();
                            lrun = true;
                        }
                    }

                    g = new Graph(names, begin, end, weight);

                }

                case "2" -> {
                    if (g != null) g.graphPrint();
                    else System.out.println("Najpierw stwórz sieć miast!");
                }

                case "3" -> {
                    System.out.println("Podaj miasto początkowe");
                    String miasto = scanner.nextLine();
                    if (mapaMiast.containsKey(miasto)) g.dijkstra(mapaMiast.get(miasto));
                    else System.out.println("Nie ma takiego miasta w sieci!");
                }

                case "4" -> {
                    System.out.println("Kolejne wierchołki: ");
                    g.DFS();
                }

                case "5" -> {
                    scanner.close();
                    run = false;
                }
            }

            System.out.println();
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

}
