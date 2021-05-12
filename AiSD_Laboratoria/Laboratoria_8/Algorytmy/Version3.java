package AiSD_Laboratoria.Laboratoria_8.Algorytmy;

import AiSD_Laboratoria.Laboratoria_7.Algorytmy_sortowania.BubbleSort;
import AiSD_Laboratoria.Laboratoria_7.Algorytmy_sortowania.InsertSort;

import java.util.ArrayList;

public class Version3 {
    public static void shellSort(int[] list, ArrayList<Integer> ciag){
        for (int i = ciag.size() - 1; i >= 0; i--) {
            int h = ciag.get(i);

            if (h != 1) {
                BubbleSort.bubbleSort(list, h);
            } else {
                InsertSort.insertSort(list);
            }
        }
    }
}
