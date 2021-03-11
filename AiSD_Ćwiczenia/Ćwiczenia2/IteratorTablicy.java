package AiSD_Ćwiczenia.Ćwiczenia2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorTablicy implements Iterator<Student> {
    private Student[] array;
    private int pos;

    public IteratorTablicy(Student[] array) {
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
    public Student next() throws NoSuchElementException {
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
