package AiSD_Ćwiczenia.Ćwiczenia_2_1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorTablicy<T> implements Iterator<T> {
    private final T[] array;
    private int pos;

    public IteratorTablicy(T[] array) {
        this.array = array;
        this.pos = 0;
    }

    @Override
    public boolean hasNext() {
        if (pos < array.length){
            return true;
        }
        return false;
    }

    @Override
    public T next() throws NoSuchElementException {
        if (hasNext()){
            return array[pos++];
        }
        else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public void remove() throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }


}
