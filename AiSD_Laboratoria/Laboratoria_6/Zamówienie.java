package AiSD_Laboratoria.Laboratoria_6;

import java.util.Objects;

public class Zamówienie {
    private String nazwa;
    private int liczba_sztuk;
    private double cena_jednostkowa;

    public Zamówienie(String nazwa, int liczba_sztuk, double cena_jednostkowa) {
        this.nazwa = nazwa;
        this.liczba_sztuk = liczba_sztuk;
        this.cena_jednostkowa = cena_jednostkowa;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getLiczba_sztuk() {
        return liczba_sztuk;
    }

    public void setLiczba_sztuk(int liczba_sztuk) {
        this.liczba_sztuk = liczba_sztuk;
    }

    public double getCena_jednostkowa() {
        return cena_jednostkowa;
    }

    public void setCena_jednostkowa(double cena_jednostkowa) {
        this.cena_jednostkowa = cena_jednostkowa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zamówienie that = (Zamówienie) o;
        return liczba_sztuk == that.liczba_sztuk && Double.compare(that.cena_jednostkowa, cena_jednostkowa) == 0 && Objects.equals(nazwa, that.nazwa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nazwa, liczba_sztuk, cena_jednostkowa);
    }

    @Override
    public String toString() {
        return String.format("| %-9s | %-9d | %-9.2f |", nazwa, liczba_sztuk, cena_jednostkowa);
    }
}
