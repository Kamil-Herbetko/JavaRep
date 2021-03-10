package PSiO;

public class Zad_5 {
    public static void PoleTrójkąta(int a, int b, int c){
        if (Math.abs(b-c)<a & a<b+c){
            double p = (a+b+c)/2;
            double pole = Math.sqrt(p*(p-a)*(p-b)*(p-c));
            System.out.println("Pole trójkąta wynosi: " + pole);
        } else{
            System.out.println("Z podanych boków nie można zbudować trójkąta");
        }
    }
}
