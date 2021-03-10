package PSiO_Ćwiczenia.lista7.Comparators;

import PSiO_Ćwiczenia.lista7.Klasy.Kursy;
import PSiO_Ćwiczenia.lista7.Klasy.Osoba;
import PSiO_Ćwiczenia.lista7.Klasy.Pracownik;

import java.util.Comparator;

public class ComparatorOsob {
    private Compare_Nazwisko compare_nazwisko;
    private Compare_Imie compare_imie;
    private Compare_NazwiskoIImie compare_nazwiskoIImie;
    private Compare_Wiek compare_wiek;
    private Compare_Zarobki compare_zarobki;
    private Compare_Staż compare_staż;
    private Compare_Kursy compare_kursy;

    public ComparatorOsob(){
        this.compare_imie = new Compare_Imie();
        this.compare_nazwisko = new Compare_Nazwisko();
        this.compare_nazwiskoIImie = new Compare_NazwiskoIImie();
        this.compare_wiek = new Compare_Wiek();
        this.compare_zarobki = new Compare_Zarobki();
        this.compare_staż = new Compare_Staż();
        this.compare_kursy = new Compare_Kursy();
    }




    class Compare_Nazwisko implements Comparator<Osoba> {

        @Override
        public int compare(Osoba o1, Osoba o2) {
            return o1.getNazwisko().compareTo(o2.getNazwisko());
        }
    }

    class Compare_Imie implements Comparator<Osoba> {

        @Override
        public int compare(Osoba o1, Osoba o2) {
            return o1.getImie().compareTo(o2.getImie());
        }
    }

    class Compare_NazwiskoIImie implements Comparator<Osoba> {

        @Override
        public int compare(Osoba o1, Osoba o2) {
            return (o1.getNazwisko() + o1.getImie()).compareTo(o2.getNazwisko() + o2.getImie());
        }
    }

    class Compare_Wiek implements Comparator<Osoba> {

        @Override
        public int compare(Osoba o1, Osoba o2) {
            if (o1.getWiek() < o2.getWiek()){
                return -1;
            }
            if (o1.getWiek() > o2.getWiek()){
                return 1;
            }
            return 0;
        }
    }

    class Compare_Zarobki implements Comparator<Pracownik> {

        @Override
        public int compare(Pracownik o1, Pracownik o2) {
            if (o1.getPensja() < o2.getPensja()){
                return -1;
            }
            if (o1.getPensja() > o2.getPensja()){
                return 1;
            }
            return 0;
        }
    }

    class Compare_Staż implements Comparator<Pracownik> {

        @Override
        public int compare(Pracownik o1, Pracownik o2) {
            if (o1.getLataPracy() < o2.getLataPracy()){
                return -1;
            }
            if (o1.getLataPracy() > o2.getLataPracy()){
                return 1;
            }
            return 0;
        }
    }

    class Compare_Kursy implements Comparator<Kursy> {

        @Override
        public int compare(Kursy o1, Kursy o2) {
            return o1.getNazwa_kursu().compareTo(o2.getNazwa_kursu());
        }
    }

    public Compare_Nazwisko getCompare_nazwisko() {
        return compare_nazwisko;
    }

    public Compare_Imie getCompare_imie() {
        return compare_imie;
    }

    public Compare_NazwiskoIImie getCompare_nazwiskoIImie() {
        return compare_nazwiskoIImie;
    }

    public Compare_Wiek getCompare_wiek() {
        return compare_wiek;
    }

    public Compare_Zarobki getCompare_zarobki() {
        return compare_zarobki;
    }

    public Compare_Staż getCompare_staż() {
        return compare_staż;
    }

    public Compare_Kursy getCompare_kursy() {
        return compare_kursy;
    }

    public void setCompare_nazwisko(Compare_Nazwisko compare_nazwisko) {
        this.compare_nazwisko = compare_nazwisko;
    }

    public void setCompare_imie(Compare_Imie compare_imie) {
        this.compare_imie = compare_imie;
    }

    public void setCompare_nazwiskoIImie(Compare_NazwiskoIImie compare_nazwiskoIImie) {
        this.compare_nazwiskoIImie = compare_nazwiskoIImie;
    }

    public void setCompare_wiek(Compare_Wiek compare_wiek) {
        this.compare_wiek = compare_wiek;
    }

    public void setCompare_zarobki(Compare_Zarobki compare_zarobki) {
        this.compare_zarobki = compare_zarobki;
    }

    public void setCompare_staż(Compare_Staż compare_staż) {
        this.compare_staż = compare_staż;
    }

    public void setCompare_kursy(Compare_Kursy compare_kursy) {
        this.compare_kursy = compare_kursy;
    }
}
