package PSiO;

public class Zad_3 {
    public static double Calc(double x, double y , char operator){
        double wynik = 0.0;
        switch(operator){
            case '+':
                wynik = x+y;
                break;
            case '-':
                wynik = x-y;
                break;
            case '*':
                wynik = x*y;
                break;
            case '/':
                if (y==0){
                    throw new ArithmeticException("You can't divide by 0");
                }else{
                    wynik = x / y;
                    break;
                }

        }
        return wynik;
    }
}