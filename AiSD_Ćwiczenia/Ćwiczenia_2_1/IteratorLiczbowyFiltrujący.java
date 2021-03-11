package AiSD_Ćwiczenia.Ćwiczenia_2_1;

import java.util.Iterator;

public class IteratorLiczbowyFiltrujący implements Iterator<Integer> {
    private IteratorLiczbowy iteratorLiczbowy;
    private Predicate<Integer> predicate;

    private Integer elemNext = null;
    private boolean bHasNext = true;

    public IteratorLiczbowyFiltrujący(IteratorLiczbowy iteratorLiczbowy, Predicate<Integer> predicate) {
        super();
        this.iteratorLiczbowy = iteratorLiczbowy;
        this.predicate = predicate;
        filter();
    }

    public void filter(){
        while (iteratorLiczbowy.hasNext()){
            elemNext = iteratorLiczbowy.next();
            if (predicate.accept(elemNext)){
                return;
            }
        }
        bHasNext = false;
        elemNext = null;
    }

    @Override
    public boolean hasNext() {
        return bHasNext;
    }

    @Override
    public Integer next() {
        Integer nextValue = elemNext;
        filter();
        return nextValue;
    }
}
