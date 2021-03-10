package PSiO;

public class Zad_2 {
    public static void Iloraz_Cał(int x, int y){
        if (y==0){
            System.out.println("Nie można dzielić przez zero");
        } else{
            int iloraz = 0;
            while (x>y){
                x-=y;
                iloraz++;
            }
            System.out.println(iloraz);
        }
    }
}
