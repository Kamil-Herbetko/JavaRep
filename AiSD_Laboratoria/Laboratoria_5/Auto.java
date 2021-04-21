package AiSD_Laboratoria.Laboratoria_5;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Auto implements Serializable {

    @Serial
    private static final long serialVersionUID = 4163796131816322049L;
    public static int number = 0;
    private int NR_SILNIKA;
    private String marka;
    private String typ;
    private int data_produkcji;
    private int cena;
    private String kolor;
    private int skladowanie;
    private double przecena;

    public Auto(String marka, String typ, int data_produkcji, int cena, String kolor, int skladowanie) {
        ++number;
        this.NR_SILNIKA = number;
        this.marka = marka;
        this.typ = typ;
        this.data_produkcji = data_produkcji;
        this.cena = cena;
        this.kolor = kolor;
        this.skladowanie = skladowanie;
        if (skladowanie >= 15){
            this.przecena = 0.85 * this.cena;
        }
        else if ((6 <= skladowanie) && (skladowanie < 15)){
            this.przecena = 0.94 * this.cena;
        }
        else {
            this.przecena = cena;
        }
    }

    public int getNR_SILNIKA() {
        return NR_SILNIKA;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public int getData_produkcji() {
        return data_produkcji;
    }

    public void setData_produkcji(int data_produkcji) {
        this.data_produkcji = data_produkcji;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public String getKolor() {
        return kolor;
    }

    public void setKolor(String kolor) {
        this.kolor = kolor;
    }

    public int getSkladowanie() {
        return skladowanie;
    }

    public void setSkladowanie(int skladowanie) {
        this.skladowanie = skladowanie;
    }

    public double getPrzecena() {
        return przecena;
    }

    public void setPrzecena() {
        if (this.skladowanie >= 15){
            this.przecena = 0.85 * this.cena;
        }
        else if ((6 <= this.skladowanie) && (this.skladowanie < 15)){
            this.przecena = 0.94 * this.cena;
        }
        else {
            this.przecena = cena;
        }
    }

    @Override
    public String toString() {
        return String.format("| %-13d | %-11s | %-9s | %-14d | %-6d | %-12s | %-11d | %-9.2f |", this.NR_SILNIKA, this.marka, this.typ, this.data_produkcji, this.cena, this.kolor, this.skladowanie, this.przecena);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auto auto = (Auto) o;
        return NR_SILNIKA == auto.NR_SILNIKA && data_produkcji == auto.data_produkcji && cena == auto.cena && skladowanie == auto.skladowanie && Double.compare(auto.przecena, przecena) == 0 && Objects.equals(marka, auto.marka) && Objects.equals(typ, auto.typ) && Objects.equals(kolor, auto.kolor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(NR_SILNIKA, marka, typ, data_produkcji, cena, kolor, skladowanie, przecena);
    }
}
