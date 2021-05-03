package AiSD_Laboratoria.Laboratoria_7.Algorytmy_sortowania;

public class MergeSort {
    public static int[] mergeSort(int[] list){
        return sort(list, 0, list.length - 1);
    }

    private static int[] sort(int[] list, int startIndex, int endIndex){
        if (startIndex == endIndex) {
            int[] result = new int[1];
            result[0] = list[startIndex];
            return result;
        }
        int splitIndex = startIndex + (endIndex - startIndex) / 2;
        return merge(sort(list, startIndex, splitIndex),
                sort(list, splitIndex + 1, endIndex));

    }

    private static int[] merge(int[] left, int[] right){
        int lengthL = left.length, lengthR = right.length;
        int[] result = new int[lengthL + lengthR];
        int elemL = 0, elemR = 0, i = 0;
        while ((elemL < lengthL) && (elemR < lengthR)){
            if (left[elemL] <= right[elemR]){
                result[i++] = left[elemL++];
                if (elemL == lengthL){
                    result[i++] = right[elemR++];
                }
            }
            else {
                result[i++] = right[elemR++];
                if (elemR == lengthR){
                    result[i++] = left[elemL++];
                }
            }
        }
        while (elemL < lengthL) result[i++] = left[elemL++];
        while (elemR < lengthR) result[i++] = right[elemR++];

        return result;
    }
}
