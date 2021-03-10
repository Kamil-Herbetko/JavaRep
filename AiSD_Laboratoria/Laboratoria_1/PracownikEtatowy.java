package AiSD_Laboratoria.Laboratoria_1;

import java.io.Serial;

public class PracownikEtatowy extends  Pracownik{
    @Serial
    private static final long serialVersionUID = 9189146607368875260L;
    private double etat;
    private double stawka;

    public PracownikEtatowy(String nazwisko, String imię, long pesel, String stanowisko, int staż, double etat, double stawka) {
        super(nazwisko, imię, pesel, stanowisko, staż);
        this.etat = etat;
        this.stawka = stawka;
    }

    public PracownikEtatowy() {
        super();
        this.etat = 0;
        this.stawka = 0;
    }

    public double getEtat() {
        return etat;
    }

    public void setEtat(double etat) {
        this.etat = etat;
    }

    public double getStawka() {
        return stawka;
    }

    public void setStawka(double stawka) {
        this.stawka = stawka;
    }

    @Override
    public double pensja() {
        return (this.stawka * this.etat);
    }

    @Override
    public String toString() {
        return String.format("%s %10.2f |", super.toString(), this.pensja());
    }
}
