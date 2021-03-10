package PSiO_Ćwiczenia.lista7.Klasy;



import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Student extends Osoba {
    private static final long serialVersionUID = 1234560990255762290L;
    private String kierunek;
    private String wydział;
    private int numer_indeksu;
    private ArrayList<Kursy> kursy;

    public Student(String imie, String nazwisko, int PESEL, double wiek, int wzrost, int waga, String kierunek, String wydział, int numer_indeksu, ArrayList<Kursy> kursy) {
        super(imie, nazwisko, PESEL, wiek, wzrost, waga);
        this.kierunek = kierunek;
        this.wydział = wydział;
        this.numer_indeksu = numer_indeksu;
        this.kursy = kursy;
    }

    public Student() {
        super();
    }

    public String getKierunek() {
        return kierunek;
    }

    public void setKierunek(String kierunek) {
        this.kierunek = kierunek;
    }

    public String getWydział() {
        return wydział;
    }

    public void setWydział(String wydział) {
        this.wydział = wydział;
    }

    public int getNumer_indeksu() {
        return numer_indeksu;
    }

    public void setNumer_indeksu(int numer_indeksu) {
        this.numer_indeksu = numer_indeksu;
    }

    public ArrayList<Kursy> getKursy() {
        return kursy;
    }

    public void setKursy(ArrayList<Kursy> kursy) {
        this.kursy = kursy;
    }

    public void dodajKurs(Kursy kurs){
        this.kursy.add(kurs);
    }

    public void usunKurs(int index){
        this.kursy.remove(index);
    }

    public void usunKurs(Kursy kurs){
        this.kursy.remove(kurs);
    }

    @Override
    public String toString() {
        return super.toString() +
                "    Kierunek: '" + kierunek + '\'' +
                "    Wydział: '" + wydział + '\'' +
                "    Numer_indeksu: " + numer_indeksu +
                "    Kursy: " + kursy.toString();
    }

}
