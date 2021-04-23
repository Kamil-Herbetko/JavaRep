package AiSD_Laboratoria.Laboratoria_6;

import AiSD_Ćwiczenia.Ćwiczenia_2_2.Exceptions.FullQueueException;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws FullQueueException {

        Magazyn magazyn = new Magazyn(new String[]{}, new String[]{}, new int[]{}, new double[]{});
        Firma firma = new Firma(new String[][]{}, new String[][]{}, new int[][]{}, new double[][]{});

        String[] tablicaNazwKlientów = {"BMW", "Mercedes", "Ford", "Fiat", "Nissan", "Opel", "Dodge", "Audi", "Volkswagen", "Skoda", "Dacia", "Volvo", "Lexus", "Bugatti", "Porsche"};
    }
}
