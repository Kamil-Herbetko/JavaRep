package PSiO_Ćwiczenia.lista7.Klasy;

public class PracownikUczelniNaukowo_Dydaktyczny extends Pracownik {
    private double dorobek;
    private String katedra;
    private String stopieńNaukowy;
    private static final long serialVersionUID = 3895234789255762290L;

    public PracownikUczelniNaukowo_Dydaktyczny(String imie, String nazwisko, int PESEL, double wiek, int wzrost, int waga, int pensja, int lataPracy, double dorobek, String katedra, String stopieńNaukowy) {
        super(imie, nazwisko, PESEL, wiek, wzrost, waga, pensja, lataPracy);
        this.dorobek = dorobek;
        this.katedra = katedra;
        this.stopieńNaukowy = stopieńNaukowy;
    }

    public String getStopieńNaukowy() {
        return stopieńNaukowy;
    }

    public void setStopieńNaukowy(String stopieńNaukowy) {
        this.stopieńNaukowy = stopieńNaukowy;
    }

    public double getDorobek() {
        return dorobek;
    }

    public void setDorobek(double dorobek) {
        this.dorobek = dorobek;
    }

    public String getKatedra() {
        return katedra;
    }

    public void setKatedra(String katedra) {
        this.katedra = katedra;
    }

    @Override
    public String toString() {
        return super.toString() +
                "    Dorobek: " + dorobek +
                "    Katedra: '" + katedra + '\'' +
                "    StopieńNaukowy: '" + stopieńNaukowy + '\'';
    }

    @Override
    public void przedstawSie() {
        super.przedstawSie();
        System.out.println(" Pracuję na uczelni w katedrze " + getKatedra() + ", mam stopień " + getStopieńNaukowy() + " oraz mam tyle punktów dorobku naukowego: " + getDorobek() + '.');
    }
}
