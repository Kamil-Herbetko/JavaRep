package PSiO_Ćwiczenia.Biblioteka;

public class Biblioteka {

    private static double sinus(double x, int n){
        double suma = x;
        double tmp = x;

        for (int i = 1; i <= n; i++) {
            tmp *= (-1) * x * x / (2 * i * (2 * i + 1));
            suma += tmp;
        }

        return suma;
    }

    private static double cosinus(double x, int n){
        double suma = 1.0;
        double tmp = 1.0;

        for (int i = 1; i <= n; i++) {
            tmp *= (-1) * x * x / (2 * i * (2 * i - 1));
            suma += tmp;
        }

        return suma;
    }
    private static double exponent(double x, int n){
        double suma = 1.0;
        double tmp = 1.0;

        for (int i = 1; i <= n; i++){
            tmp *= x/i;
            suma +=  tmp;
        }

        return suma;
    }


    public static double sin(double x, int n) {
        return sinus(x,  n);
    }

    public static double sin(double x){
        return sinus(x, 1000);
    }

    public static double cos(double x, int n) {
        return cosinus(x, n);
    }

    public static double cos(double  x){
        return cosinus(x, 1000);
    }

    public static double exp(double x, int n){
        return exponent(x, n);
    }

    public static double exp(double x){
        return exponent(x, 1000);
    }
}