package AiSD_Laboratoria.Laboratoria_7.Algorytmy_sortowania;

public class SelectSort {
    public static void selectSort(int[] list) {
        int size = list.length;
        for (int slot = 0; slot < size - 1; ++slot) {
            int smallest = slot; // pozycja wartości minimalnej
            for (int check = slot + 1; check < size; ++check)
                if (list[check] < list[smallest]){
                    smallest = check;
                }
            swap(list, smallest, slot);
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
