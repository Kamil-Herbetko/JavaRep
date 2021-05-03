package AiSD_Laboratoria.Laboratoria_7.Algorytmy_sortowania;

import java.util.Random;

public class QuickSort {
    public static void quickSort(int[] list){
        sort(list, 0, list.length);
    }

    private static void sort(int[] list, int startIndex, int endIndex){
        Random random = new Random();
        if (endIndex > startIndex) {
            int partition = partition(list, startIndex, endIndex, random);
            sort(list, startIndex, partition );
            sort(list, partition + 1, endIndex);}
    }

    private static int partition(int[] list, int nFrom, int nTo, Random random){
        int rnd = nFrom + random.nextInt(nTo - nFrom);
        swap(list, nFrom, rnd);
        int value = list[nFrom];
        int idxBigger = nFrom+1, idxLower = nTo-1;
        do{
            while( (idxBigger <= idxLower) && (list[idxBigger] <= value)) {
                idxBigger++;
            }
            while(list[idxLower] > value) {
                idxLower--;
            }

            if (idxBigger < idxLower) {
                swap(list, idxBigger, idxLower);
            }
        } while (idxBigger < idxLower);
        swap(list, idxLower, nFrom);
        return idxLower;
    }


    private static void swap(int[] list, int left, int right){
        if (left != right) {
            int temp = list[left];
            list[left] = list[right];
            list[right] = temp;
        }
    }

}
