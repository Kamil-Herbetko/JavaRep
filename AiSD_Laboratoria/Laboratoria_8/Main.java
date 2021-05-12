package AiSD_Laboratoria.Laboratoria_8;

import AiSD_Laboratoria.Laboratoria_8.Algorytmy.Version1;
import AiSD_Laboratoria.Laboratoria_8.Algorytmy.Version2;
import AiSD_Laboratoria.Laboratoria_8.Algorytmy.Version3;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        testDlaN(5000);
    }

    public static void testDlaN(int N){
        // Przygotowanie tablic
        Random random = new Random();

        int[] list = new int[N];
        ArrayList<Integer> lista = new ArrayList<>();
        ArrayList<Integer> listb = new ArrayList<>();
        ArrayList<Integer> listc = new ArrayList<>();
        ArrayList<Integer> listd = new ArrayList<>();
        ArrayList<Integer> listdod = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list[i] = random.nextInt(N);
        }

        // Ciąg a:
        int h = 1;
        while (h <= N){
            lista.add(h);
            h = 3*h + 1;
        }

        // Ciąg b:

        h = 1;
        int k = 2;
        while (h <= N){
            listb.add(h);
            h += k;
            k *= 2;
        }

        // Ciąg c:
        listc.add(1);
        h = 3;
        k = 2;
        while (h <= N){
            listc.add(h);
            h += k;
            k *= 2;
        }

        // Ciąg d:
        k = 1;
        h = 2;
        int temp;
        listd.add(1);
        while (h <= N){
            listd.add(h);
            temp = h;
            h = k+h;
            k = temp;
        }

        // Ciąg dodatkowy:
        h = N/2;
        while (h > 0){
            listdod.add(0, h);
            h = 3*h/4;
        }

        // Czas dla ciągu a:
        System.out.println("Dla ciągu a: ");
        long time = System.nanoTime();
        Version1.shellSort(list.clone(), lista);
        System.out.printf("Czas sortowania wersji pierwszej shellsort: %.1fms", (Double)((System.nanoTime() - time)/1000000.0));
        System.out.println();

        time = System.nanoTime();
        Version2.shellSort(list.clone(), lista);
        System.out.printf("Czas sortowania wersji drugiej shellsort: %.1fms", (Double)((System.nanoTime() - time)/1000000.0));
        System.out.println();

        time = System.nanoTime();
        Version3.shellSort(list.clone(), lista);
        System.out.printf("Czas sortowania wersji trzeciej shellsort: %.1fms", (Double)((System.nanoTime() - time)/1000000.0));
        System.out.println();

        System.out.println();

        // Czas dla ciągu b:
        System.out.println("Dla ciągu b: ");
        time = System.nanoTime();
        Version1.shellSort(list.clone(), listb);
        System.out.printf("Czas sortowania wersji pierwszej shellsort: %.1fms", (Double)((System.nanoTime() - time)/1000000.0));
        System.out.println();

        time = System.nanoTime();
        Version2.shellSort(list.clone(), listb);
        System.out.printf("Czas sortowania wersji drugiej shellsort: %.1fms", (Double)((System.nanoTime() - time)/1000000.0));
        System.out.println();

        time = System.nanoTime();
        Version3.shellSort(list.clone(), listb);
        System.out.printf("Czas sortowania wersji trzeciej shellsort: %.1fms", (Double)((System.nanoTime() - time)/1000000.0));
        System.out.println();

        System.out.println();

        // Czas dla ciągu c:
        System.out.println("Dla ciągu c: ");
        time = System.nanoTime();
        Version1.shellSort(list.clone(), listc);
        System.out.printf("Czas sortowania wersji pierwszej shellsort: %.1fms", (Double)((System.nanoTime() - time)/1000000.0));
        System.out.println();

        time = System.nanoTime();
        Version2.shellSort(list.clone(), listc);
        System.out.printf("Czas sortowania wersji drugiej shellsort: %.1fms", (Double)((System.nanoTime() - time)/1000000.0));
        System.out.println();

        time = System.nanoTime();
        Version3.shellSort(list.clone(), listc);
        System.out.printf("Czas sortowania wersji trzeciej shellsort: %.1fms", (Double)((System.nanoTime() - time)/1000000.0));
        System.out.println();

        System.out.println();

        // Czas dla ciągu d:
        System.out.println("Dla ciągu d: ");
        time = System.nanoTime();
        Version1.shellSort(list.clone(), listd);
        System.out.printf("Czas sortowania wersji pierwszej shellsort: %.1fms", (Double)((System.nanoTime() - time)/1000000.0));
        System.out.println();

        time = System.nanoTime();
        Version2.shellSort(list.clone(), listd);
        System.out.printf("Czas sortowania wersji drugiej shellsort: %.1fms", (Double)((System.nanoTime() - time)/1000000.0));
        System.out.println();

        time = System.nanoTime();
        Version3.shellSort(list.clone(), listd);
        System.out.printf("Czas sortowania wersji trzeciej shellsort: %.1fms", (Double)((System.nanoTime() - time)/1000000.0));
        System.out.println();

        System.out.println();

        // Czas dla ciągu dodatkowego:
        System.out.println("Dla ciągu dodatkowego: ");
        time = System.nanoTime();
        Version1.shellSort(list.clone(), listdod);
        System.out.printf("Czas sortowania wersji pierwszej shellsort: %.1fms", (Double)((System.nanoTime() - time)/1000000.0));
        System.out.println();

        time = System.nanoTime();
        Version2.shellSort(list.clone(), listdod);
        System.out.printf("Czas sortowania wersji drugiej shellsort: %.1fms", (Double)((System.nanoTime() - time)/1000000.0));
        System.out.println();

        time = System.nanoTime();
        Version3.shellSort(list.clone(), listdod);
        System.out.printf("Czas sortowania wersji trzeciej shellsort: %.1fms", (Double)((System.nanoTime() - time)/1000000.0));
        System.out.println();

        System.out.println();
    }
}
