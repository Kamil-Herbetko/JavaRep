package AiSD_Laboratoria.Laboratoria_7.Algorytmy_sortowania;

public class HeapSort {

    public static void heapSort(int[] list){
        sort(list, list.length);
    }

    private static void sort(int[] list, int n){
        heapAdjustment(list, n);
        for (int i = n-1; i > 0; i--) {
            swap(list, i, 0);
            sink(list, 0 ,i);
        }
    }

    private static void swap(int[] list, int left, int right){
        int temp = list[left];
        list[left] = list[right];
        list[right] = temp;
    }

    private static void sink(int[] list, int idx, int n){
        int idxOfBigger = 2*idx + 1;
        if (idxOfBigger < n){
            if ((idxOfBigger + 1 < n) && (list[idxOfBigger] < list[idxOfBigger + 1])){
                idxOfBigger++;
            }
            if (list[idx] < list[idxOfBigger]){
                swap(list, idx, idxOfBigger);
                sink(list, idxOfBigger, n);
            }
        }
    }

    private static void heapAdjustment(int[] list, int n){
        for (int i = (n-1)/2; i >= 0; i--) {
            sink(list, i, n);
        }
    }

}
