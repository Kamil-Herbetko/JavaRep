package AiSD_Laboratoria.Laboratoria_1;

import java.io.Serializable;

public abstract class Pracownik implements Serializable {
    private String nazwisko;
    private String imię;
    private long pesel;
    private String stanowisko;
    private int staż;

    public Pracownik(String nazwisko, String imię, long pesel, String stanowisko, int staż) {
        this.nazwisko = nazwisko;
        this.imię = imię;
        this.pesel = pesel;
        this.stanowisko = stanowisko;
        this.staż = staż;
    }

    public Pracownik() {
        this.nazwisko = "";
        this.imię = "";
        this.pesel = 0L;
        this.stanowisko = "";
        this.staż = 0;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getImię() {
        return imię;
    }

    public void setImię(String imię) {
        this.imię = imię;
    }

    public long getPesel() {
        return pesel;
    }

    public void setPesel(long pesel) {
        this.pesel = pesel;
    }

    public String getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

    public int getStaż() {
        return staż;
    }

    public void setStaż(int staż) {
        this.staż = staż;
    }

    public abstract double pensja();

    public void wyświetl(){
        System.out.printf("| %-25s | %-15s | %11d | %-15s | %7d | %n", this.nazwisko, this.imię, this.pesel, this. stanowisko, this.staż);
    }

    @Override
    public String toString() {
        return String.format("| %-25s | %-15s | %11d | %-15s | %7d |", this.nazwisko, this.imię, this.pesel, this. stanowisko, this.staż);
    }
}
