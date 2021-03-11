package AiSD_Ćwiczenia.Ćwiczenia2;

public class Student {
    private int numer_indeksu;
    private String nazwisko;
    private String imie;
    private double ocena;

    public Student(int numer_indeksu, String nazwisko, String imie, double ocena) {
        this.numer_indeksu = numer_indeksu;
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.ocena = ocena;
    }

    public int getNumer_indeksu() {
        return numer_indeksu;
    }

    public void setNumer_indeksu(int numer_indeksu) {
        this.numer_indeksu = numer_indeksu;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public double getOcena() {
        return ocena;
    }

    public void setOcena(double ocena) {
        this.ocena = ocena;
    }

    @Override
    public String toString() {
        return String.format("| %13d | %-20s | %-15s | %1.1f |", this.numer_indeksu, this.nazwisko, this.imie, this.ocena);
    }
}
