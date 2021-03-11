package AiSD_Ćwiczenia.Ćwiczenia_2_1;

public class Zadanie_2 {
    public static void main(String[] args) {
        IteratorLiczbowyFiltrujący iteratorLiczbowyFiltrujący1 = new IteratorLiczbowyFiltrujący(new IteratorLiczbowy(-1000, 100), new CzyJestLiczbąPierwszą());
        IteratorLiczbowyFiltrujący iteratorLiczbowyFiltrujący2 = new IteratorLiczbowyFiltrujący(new IteratorLiczbowy(1, 100), new Predicate<Integer>() {
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
        });
        IteratorLiczbowyFiltrujący iteratorLiczbowyFiltrujący3 = new IteratorLiczbowyFiltrujący(new IteratorLiczbowy(1, 100), object -> {
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
        });


        while (iteratorLiczbowyFiltrujący1.hasNext()){
            System.out.print(iteratorLiczbowyFiltrujący1.next() + " ");
        }

        System.out.println();

        while (iteratorLiczbowyFiltrujący2.hasNext()){
            System.out.print(iteratorLiczbowyFiltrujący2.next() + " ");
        }

        System.out.println();

        while (iteratorLiczbowyFiltrujący3.hasNext()){
            System.out.print(iteratorLiczbowyFiltrujący3.next() + " ");
        }
    }
}
