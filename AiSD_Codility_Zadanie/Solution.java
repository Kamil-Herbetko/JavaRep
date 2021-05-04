package AiSD_Codility_Zadanie;

import java.util.Arrays;

public class Solution {
    public int solution(int[] A, int L, int R) {
        Arrays.sort(A);
        int length = A.length;
        int answear1 = 0;
        int answear2 = 0;
        int L2 = L;
        int R2 = R;
        int[] B = A.clone();

        for (int i = 0; i < length; i++) {
            if (B[length - 1 - i] < L){
                L = B[length - 1 - i];
                B[length - 1 - i] = -1;
                answear1++;
            }
        }

        for (int i = 0; i < length; i++) {
            if (B[i] > R){
                R = B[i];
                answear1++;
            }
        }

        for (int i = 0; i < length; i++) {
            if (A[i] > R2){
                R2 = A[i];
                A[i] = -1;
                answear2++;
            }
        }

        for (int i = 0; i < length; i++) {
            if ((-1 < A[length - 1 - i]) && ( A[length - 1 - i] < L2)){
                L2 = A[length - 1 - i];
                answear2++;
            }
        }

        if (answear1 > answear2){
            return answear1;
        }
        return answear2;
    }
}
