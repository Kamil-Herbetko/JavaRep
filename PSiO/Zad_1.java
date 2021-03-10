package PSiO;

public class Zad_1 {
    public static void Zmienna_Max(int a, int b, int c){
        int x;
        if (a>b){
            if (a>c){
                x = a;
            } else{
                x = c;
            }
        } else{
            if (b>c){
                x = b;
            } else{
                x = c;
            }
        }
        System.out.println(x);
    }
}
