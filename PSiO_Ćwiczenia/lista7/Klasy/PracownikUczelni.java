package PSiO_Ćwiczenia.lista7.Klasy;

public class PracownikUczelni extends Pracownik {
    private String stanowisko;
    private static final long serialVersionUID = 3895670990255762290L;

    public PracownikUczelni(String imie, String nazwisko, int PESEL, double wiek, int wzrost, int waga, int pensja, int lataPracy, String stanowisko) {
        super(imie, nazwisko, PESEL, wiek, wzrost, waga, pensja, lataPracy);
        this.stanowisko = stanowisko;
    }

    public String getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

    @Override
    public String toString() {
        return super.toString() +
                "    Stanowisko: '" + stanowisko + '\'';
    }

    @Override
    public void przedstawSie() {
        super.przedstawSie();
        System.out.println(" Pracuję na uczelni jako " + getStanowisko() + '.');
    }
}
