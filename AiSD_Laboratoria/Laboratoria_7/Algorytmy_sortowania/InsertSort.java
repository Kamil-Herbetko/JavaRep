package AiSD_Laboratoria.Laboratoria_7.Algorytmy_sortowania;

public class InsertSort {
    public static void insertSort(int[] list){
        for (int i = 1; i < list.length; ++i) {
            int value = list[i], temp;
            int j; // będzie wykorzystywane poza pętlą
            for (j = i; (j > 0) && (value < (temp = list[j - 1])); --j)
                list[j] = temp;
            list[j] =  value;
        }
    }
}
