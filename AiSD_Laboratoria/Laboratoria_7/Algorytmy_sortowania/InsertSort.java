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

    public static void insertSort(int[] list, int h){
        int len = list.length;
        if (h >= len){
            return;
        }
        if (len%h == 0){
            for (int z = 0; z < h; z++){
                for (int i = h; i < len; ++i) {
                    int value = list[i], temp;
                    int j; // będzie wykorzystywane poza pętlą
                    for (j = i; (j > 0) && (j - h > 0) && (value < (temp = list[j - h])); j -= h)
                        list[j] = temp;
                    list[j] =  value;
                }
                h++;
            }
        }
        else {
            for (int z = 0; z < (len/h + h - (len%h)); z++){
                for (int i = h; i < len; ++i) {
                    int value = list[i], temp;
                    int j; // będzie wykorzystywane poza pętlą
                    for (j = i; (j > 0) && (j - h > 0) && (value < (temp = list[j - h])); j -= h)
                        list[j] = temp;
                    list[j] =  value;
                }
                h++;
            }
        }


    }
}
