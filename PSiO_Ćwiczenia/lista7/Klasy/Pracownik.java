package PSiO_Ćwiczenia.lista7.Klasy;


public abstract class Pracownik extends Osoba {
    private int pensja;
    private int lataPracy;

    public Pracownik(String imie, String nazwisko, int PESEL, double wiek, int wzrost, int waga, int pensja, int lataPracy) {
        super(imie, nazwisko, PESEL, wiek, wzrost, waga);
        this.pensja = pensja;
        this.lataPracy = lataPracy;
    }

    public int getPensja() {
        return pensja;
    }

    public void setPensja(int pensja) {
        this.pensja = pensja;
    }

    public int getLataPracy() {
        return lataPracy;
    }

    public void setLataPracy(int lataPracy) {
        this.lataPracy = lataPracy;
    }

    @Override
    public String toString() {
        return super.toString() + "    Pensja: " + pensja +
                "    Lata pracy: " + lataPracy;
    }
}
