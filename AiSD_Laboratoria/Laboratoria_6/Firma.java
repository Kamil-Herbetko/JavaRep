package AiSD_Laboratoria.Laboratoria_6;

import AiSD_Ćwiczenia.Ćwiczenia_2_2.Exceptions.EmptyQueueException;
import AiSD_Ćwiczenia.Ćwiczenia_2_2.Exceptions.FullQueueException;

import java.util.ArrayList;

public class Firma {
    private ArrayList<Magazyn> magazyny;

    public Firma(String[][] nazwyKlientów, String[][][] nazwy, int[][][] ilości, double[][][] ceny) throws FullQueueException {
        this.magazyny = new ArrayList<>();
        for (int i = 0; i < nazwyKlientów.length; i++) {
            magazyny.add(new Magazyn(nazwyKlientów[i], nazwy[i], ilości[i], ceny[i]));
        }
    }

    public void oblicz_przychody() throws EmptyQueueException {
        double przychód_firmy = 0;

        for (int i = 0; i < magazyny.size(); i++) {
            Magazyn magazyn =  magazyny.get(i);
            System.out.println("Magazyn " + (i + 1));
            double przychód = magazyn.zrealizuj();
            przychód_firmy += przychód;
            System.out.println("Przychód z magazynu " + (i + 1) + String.format(". = %.2f", przychód));
        }

        System.out.printf("Przychód firmy = %.2f", przychód_firmy);
        System.out.println();
    }

    public ArrayList<Magazyn> getMagazyny() {
        return magazyny;
    }

    public void setMagazyny(ArrayList<Magazyn> magazyny) {
        this.magazyny = magazyny;
    }
}
