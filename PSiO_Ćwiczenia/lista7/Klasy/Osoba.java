package PSiO_Ćwiczenia.lista7.Klasy;


import java.io.Serializable;

public abstract class Osoba implements Serializable{
    private String imie;
    private String nazwisko;
    private int PESEL;
    private double wiek;
    private int wzrost;
    private int waga;

    public Osoba(String imie, String nazwisko, int PESEL, double wiek, int wzrost, int waga) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.PESEL = PESEL;
        this.wiek = wiek;
        this.wzrost = wzrost;
        this.waga = waga;
    }

    public Osoba() {
        this.imie = "";
        this.nazwisko = "";
        this.PESEL = -1;
        this.wiek = -1;
        this.wzrost = -1;
        this.waga = -1;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public int getPESEL() {
        return PESEL;
    }

    public void setPESEL(int PESEL) {
        this.PESEL = PESEL;
    }

    public double getWiek() {
        return wiek;
    }

    public void setWiek(double wiek) {
        this.wiek = wiek;
    }

    public int getWzrost() {
        return wzrost;
    }

    public void setWzrost(int wzrost) {
        this.wzrost = wzrost;
    }

    public int getWaga() {
        return waga;
    }

    public void setWaga(int waga) {
        this.waga = waga;
    }

    public String toString() {
        return "Imię: " + getImie() + "    Nazwisko: " + getNazwisko() + "    Wiek: " + getWiek() +
        "    Wzrost(cm): " + getWzrost() + "    Waga(kg): " + getWaga() + "    PESEL: " + getPESEL();
    }

    public void przedstawSie(){
        System.out.print("Witaj! Nazywam się " + getImie() + ' ' + getNazwisko() + '.');
    }

}
