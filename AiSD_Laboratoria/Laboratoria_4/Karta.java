package AiSD_Laboratoria.Laboratoria_4;

public class Karta {
    public static final String[] wartości = {"as", "2", "3", "4", "5", "6", "7", "8", "9", "10", "walet", "dama", "król"};
    public static final String[] kolory = {"kier", "karo", "trefl", "pik"};
    private int wartosc;
    private int kolor;
    private boolean znacznik;

    public Karta(int wartosc, int kolor) {
        this.wartosc = wartosc;
        this.kolor = kolor;

        if (wartosc != 14) {
            this.znacznik = true;
        }
        else {
            this.znacznik = false;
        }

    }

    public boolean isZnacznik() {
        return znacznik;
    }

    public void setZnacznik(boolean znacznik) {
        this.znacznik = znacznik;
    }

    public int getWartosc() {
        return wartosc;
    }

    public void setWartosc(int wartosc) {
        this.wartosc = wartosc;
    }

    public int getKolor() {
        return kolor;
    }

    public void setKolor(int kolor) {
        this.kolor = kolor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Karta karta = (Karta) o;
        return wartosc == karta.wartosc && kolor == karta.kolor;
    }



    @Override
    public String toString() {
        if (this.znacznik){
            return String.format("| %-7s | %-7s |", wartości[wartosc - 1], kolory[kolor]);
        }
        else {
            return "()";
        }
    }
}
