package AiSD_Ćwiczenia.Ćwiczenia_2_1;

import java.util.Iterator;

public final class IteratorFiltrujący<T> implements Iterator<T> {
    private IteratorTablicy<T> iteratorTablicy;
    private Predicate<T> predicate;

    private T elemNext = null;
    private boolean bHasNext = true;

    public IteratorFiltrujący(IteratorTablicy<T> iteratorTablicy, Predicate<T> predicate) {
        super();
        this.iteratorTablicy = iteratorTablicy;
        this.predicate = predicate;
        filter();
    }

    @Override
    public boolean hasNext() {
        return bHasNext;
    }

    public void filter(){
        while (iteratorTablicy.hasNext()){
            elemNext = iteratorTablicy.next();
            if (predicate.accept(elemNext)) {
                return;
            }
        }
        bHasNext = false;
        elemNext = null;
    }

    @Override
    public T next() {
        T nextValue = elemNext;
        filter();
        return nextValue;
    }

    @Override
    public void remove() throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }

}
