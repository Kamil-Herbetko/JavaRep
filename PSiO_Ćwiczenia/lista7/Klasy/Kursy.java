package PSiO_Ćwiczenia.lista7.Klasy;

import java.io.Serial;
import java.io.Serializable;

public class Kursy implements Serializable {

    @Serial
    private static final long serialVersionUID = 5401640376275842327L;
    private String nazwa_kursu;
    private int iloscECTS;
    private boolean czyKończySięEgzaminem;

    public Kursy(String nazwa_kursu, int iloscECTS, boolean czyKończySięEgzaminem) {
        this.nazwa_kursu = nazwa_kursu;
        this.iloscECTS = iloscECTS;
        this.czyKończySięEgzaminem = czyKończySięEgzaminem;
    }

    public String getNazwa_kursu() {
        return nazwa_kursu;
    }

    public void setNazwa_kursu(String nazwa_kursu) {
        this.nazwa_kursu = nazwa_kursu;
    }

    public int getIloscECTS() {
        return iloscECTS;
    }

    public void setIloscECTS(int iloscECTS) {
        this.iloscECTS = iloscECTS;
    }

    public boolean isCzyKończySięEgzaminem() {
        return czyKończySięEgzaminem;
    }

    public void setCzyKończySięEgzaminem(boolean czyKończySięEgzaminem) {
        this.czyKończySięEgzaminem = czyKończySięEgzaminem;
    }

    @Override
    public String toString() {
        return "[nazwa_kursu='" + nazwa_kursu + '\'' +
                ", iloscECTS=" + iloscECTS +
                ", czyKończySięEgzaminem=" + czyKończySięEgzaminem + ']';
    }
}
