package AiSD_Laboratoria.Laboratoria_1;

import java.io.Serial;

public class PracownikGodzinowy extends Pracownik{
    @Serial
    private static final long serialVersionUID = -8877524697294745061L;
    private double stawka;
    private int liczba_godz;

    public PracownikGodzinowy(String nazwisko, String imię, long pesel, String stanowisko, int staż, double stawka, int liczba_godz) {
        super(nazwisko, imię, pesel, stanowisko, staż);
        this.stawka = stawka;
        this.liczba_godz = liczba_godz;
    }

    public PracownikGodzinowy() {
        super();
        this.stawka = 0;
        this.liczba_godz = 0;
    }

    public double getStawka() {
        return stawka;
    }

    public void setStawka(double stawka) {
        this.stawka = stawka;
    }

    public int getLiczba_godz() {
        return liczba_godz;
    }

    public void setLiczba_godz(int liczba_godz) {
        this.liczba_godz = liczba_godz;
    }

    @Override
    public String toString() {
        return String.format("%s %10.2f |", super.toString(), this.pensja());
    }

    @Override
    public double pensja() {
        return (this.stawka * (double) this.liczba_godz);
    }
}
