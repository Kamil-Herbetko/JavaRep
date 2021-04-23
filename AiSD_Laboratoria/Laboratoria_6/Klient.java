package AiSD_Laboratoria.Laboratoria_6;

import AiSD_Ćwiczenia.Ćwiczenia_2_2.Exceptions.EmptyQueueException;
import AiSD_Ćwiczenia.Ćwiczenia_2_2.Exceptions.FullQueueException;

import java.util.Objects;

public class Klient {
    private String nazwa_klient;
    private ListQueue<Zamówienie> zamówienia;

    public Klient(String nazwa_klient, String[] nazwy, int[] ilości, double[] ceny) throws FullQueueException {
        this.nazwa_klient = nazwa_klient;
        this.zamówienia = new ListQueue<>();

        for (int i = 0; i < nazwy.length; i++) {
            this.zamówienia.enqueue(new Zamówienie(nazwy[i], ilości[i], ceny[i]));
        }
    }

    public String getNazwa_klient() {
        return nazwa_klient;
    }

    public void setNazwa_klient(String nazwa_klient) {
        this.nazwa_klient = nazwa_klient;
    }

    public ListQueue<Zamówienie> getZamówienia() {
        return zamówienia;
    }

    public void setZamówienia(ListQueue<Zamówienie> zamówienia) {
        this.zamówienia = zamówienia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Klient klient = (Klient) o;
        return Objects.equals(nazwa_klient, klient.nazwa_klient) && Objects.equals(zamówienia, klient.zamówienia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nazwa_klient, zamówienia);
    }

    @Override
    public String toString() {
        return String.format("| %-9s | Zamówienia: %s", nazwa_klient, zamówienia.toString());
    }

    public double do_zapłaty() throws EmptyQueueException {
        double zapłata = 0;
        while(!zamówienia.isEmpty()){
            Zamówienie z = zamówienia.dequeue();
            zapłata += z.getLiczba_sztuk() * z.getCena_jednostkowa();
        }
        return zapłata;
    }
}
