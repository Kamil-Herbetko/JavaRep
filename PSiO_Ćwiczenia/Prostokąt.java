package PSiO_Ćwiczenia;

import java.util.Scanner;

public class Prostokąt {

    private Punkt pkt1;
    private Punkt pkt2;
    private int width;
    private int height;

    public Prostokąt(int xpos1, int ypos1, int xpos2, int ypos2){
            pkt1 = new Punkt(xpos1, ypos1);
            pkt2 = new Punkt(xpos2, ypos2);
            width = Math.abs(pkt1.getX() - pkt2.getX());
            height = Math.abs(pkt1.getY() - pkt2.getY());
        }

    public Prostokąt(){
        pkt1 = new Punkt(0, 0);
        pkt2 = new Punkt(2, 1);
        width = 2;
        height = 1;
    }
    public int getPole(){
        return width*height;
    }
    public int  getObwód(){
        return 2*width + 2*height;
    }
    public double getPrzekątna(){
        return Math.sqrt(width*width + height*height);
    }

    public static void main(String[] args){
        int x1 = 0;
        int x2 = 0;
        int y1 = 0;
        int y2 = 0;
        do {
            Scanner scn = new Scanner(System.in);
            x1 = scn.nextInt();
            x2 = scn.nextInt();
            y1 = scn.nextInt();
            y2 = scn.nextInt();

            if ((x1 == x2) || (y1 == y2)){
                System.out.println("Bok prostokąta musi być większy od 0");
            }
        }while ((x1 == x2) || (y1 ==y2));

        Prostokąt prs1 = new Prostokąt(x1, y1, x2, y2);
        System.out.println("Obwód:");
        System.out.println(prs1.getObwód());
        System.out.println("Pole:");
        System.out.println(prs1.getPole());
        System.out.println("Przekątne:");
        System.out.println(prs1.getPrzekątna());

    }

}
