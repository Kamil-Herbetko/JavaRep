package PSiO_Ćwiczenia.Program_Główny;

import PSiO_Ćwiczenia.Biblioteka.Biblioteka;

public class Main {
    public static void main(String[] args){
        System.out.println(Biblioteka.cos(5.0));
        System.out.println(Biblioteka.cos(5.0, 20));
        System.out.println(Biblioteka.sin(8.3));
        System.out.println(Biblioteka.sin(8.3, 20));
        System.out.println(Biblioteka.exp(60.0));
        System.out.println(Biblioteka.exp(60.0, 20));
    }
}
