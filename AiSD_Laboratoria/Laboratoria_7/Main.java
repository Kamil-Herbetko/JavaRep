package AiSD_Laboratoria.Laboratoria_7;

import AiSD_Laboratoria.Laboratoria_7.Algorytmy_sortowania.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        testDlaN(50000);

    }

    public static void testDlaN(int N){
        Random random = new Random();

        int[] list = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = random.nextInt(N);
        }

        System.out.println("Dane losowe:");

        long time = System.nanoTime();
        HeapSort.heapSort(list.clone());
        System.out.printf("Czas sortowania heapsort: %.4fs", (Double)((System.nanoTime() - time)/1000000000.0));
        System.out.println();

        time = System.nanoTime();
        QuickSort.quickSort(list.clone());
        System.out.printf("Czas sortowania quicksort: %.4fs", (Double)((System.nanoTime() - time)/1000000000.0));
        System.out.println();

        time = System.nanoTime();
        MergeSort.mergeSort(list.clone());
        System.out.printf("Czas sortowania mergesort: %.4fs", (Double)((System.nanoTime() - time)/1000000000.0));
        System.out.println();

        time = System.nanoTime();
        BubbleSort.bubbleSort(list.clone());
        System.out.printf("Czas sortowania bubblesort: %.4fs", (Double)((System.nanoTime() - time)/1000000000.0));
        System.out.println();

        time = System.nanoTime();
        SelectSort.selectSort(list.clone());
        System.out.printf("Czas sortowania selectsort: %.4fs", (Double)((System.nanoTime() - time)/1000000000.0));
        System.out.println();

        time = System.nanoTime();
        InsertSort.insertSort(list.clone());
        System.out.printf("Czas sortowania insertsort: %.4fs", (Double)((System.nanoTime() - time)/1000000000.0));
        System.out.println();

        System.out.println();

        for (int i = 0; i < N; i++) {
            list[i] = i + 1;
        }

        System.out.println("Dane posortowane rosnąco:");

        time = System.nanoTime();
        HeapSort.heapSort(list.clone());
        System.out.printf("Czas sortowania heapsort: %.4fs", (Double)((System.nanoTime() - time)/1000000000.0));
        System.out.println();

        time = System.nanoTime();
        QuickSort.quickSort(list.clone());
        System.out.printf("Czas sortowania quicksort: %.4fs", (Double)((System.nanoTime() - time)/1000000000.0));
        System.out.println();

        time = System.nanoTime();
        MergeSort.mergeSort(list.clone());
        System.out.printf("Czas sortowania mergesort: %.4fs", (Double)((System.nanoTime() - time)/1000000000.0));
        System.out.println();

        time = System.nanoTime();
        BubbleSort.bubbleSort(list.clone());
        System.out.printf("Czas sortowania bubblesort: %.4fs", (Double)((System.nanoTime() - time)/1000000000.0));
        System.out.println();

        time = System.nanoTime();
        SelectSort.selectSort(list.clone());
        System.out.printf("Czas sortowania selectsort: %.4fs", (Double)((System.nanoTime() - time)/1000000000.0));
        System.out.println();

        time = System.nanoTime();
        InsertSort.insertSort(list.clone());
        System.out.printf("Czas sortowania insertsort: %.4fs", (Double)((System.nanoTime() - time)/1000000000.0));
        System.out.println();

        System.out.println();

        for (int i = 0; i < N; i++) {
            list[i] = N - i;
        }

        System.out.println("Dane posortowane malejąco:");

        time = System.nanoTime();
        HeapSort.heapSort(list.clone());
        System.out.printf("Czas sortowania heapsort: %.4fs", (Double)((System.nanoTime() - time)/1000000000.0));
        System.out.println();

        time = System.nanoTime();
        QuickSort.quickSort(list.clone());
        System.out.printf("Czas sortowania quicksort: %.4fs", (Double)((System.nanoTime() - time)/1000000000.0));
        System.out.println();

        time = System.nanoTime();
        MergeSort.mergeSort(list.clone());
        System.out.printf("Czas sortowania mergesort: %.4fs", (Double)((System.nanoTime() - time)/1000000000.0));
        System.out.println();

        time = System.nanoTime();
        BubbleSort.bubbleSort(list.clone());
        System.out.printf("Czas sortowania bubblesort: %.4fs", (Double)((System.nanoTime() - time)/1000000000.0));
        System.out.println();

        time = System.nanoTime();
        SelectSort.selectSort(list.clone());
        System.out.printf("Czas sortowania selectsort: %.4fs", (Double)((System.nanoTime() - time)/1000000000.0));
        System.out.println();

        time = System.nanoTime();
        InsertSort.insertSort(list.clone());
        System.out.printf("Czas sortowania insertsort: %.4fs", (Double)((System.nanoTime() - time)/1000000000.0));
        System.out.println();

        System.out.println();
    }
}
