package AiSD_Laboratoria.Laboratoria_7.Algorytmy_sortowania;

public class BubbleSort {
    public static void bubbleSort(int[] list){
        int size = list.length;
        for (int pass = 1; pass < size; ++pass) {
            for (int left = 0; left < (size - pass); ++left) {
                int right = left + 1;
                if (list[left] > list[right]) {
                    swap(list, left, right);
                }
            }
        }

    }

    public static void bubbleSort(int[] list, int h){
        int size = list.length;
        if (h >= size){
            return;
        }
        if (size % h == 0){
            for (int z = 0; z < h; z++){
                for (int pass = h; pass < size; pass += h) {
                    for (int left = 0; left < (size - pass); left+=h) {
                        int right = left + h;
                        if (list[left] > list[right]) {
                            swap(list, left, right);
                        }
                    }
                }
                h++;
            }
        }
        else {
            for (int z = 0; z < (size/h + h - (size%h)); z++){
                for (int pass = h; pass < size; pass += h) {
                    for (int left = 0; left < (size - pass); left+=h) {
                        int right = left + h;
                        if (list[left] > list[right]) {
                            swap(list, left, right);
                        }
                    }
                }
                h++;
            }
        }

    }

    private static void swap(int[] list, int left, int right) {
        if (left != right) {
            int temp = list[left];
            list[left] = list[right];
            list[right] = temp;
        }
    }
}
