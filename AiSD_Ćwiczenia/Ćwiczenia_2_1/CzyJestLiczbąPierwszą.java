package AiSD_Ćwiczenia.Ćwiczenia_2_1;

public class CzyJestLiczbąPierwszą implements Predicate<Integer>{
    @Override
    public boolean accept(Integer object) {
        if ((Math.abs(object) == 1) || (object == 0)){
            return false;
        }
        else {
            for (int i = 2; i <= (int) Math.floor(Math.sqrt(Math.abs(object))); i++) {
                if (Math.abs(object) % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
