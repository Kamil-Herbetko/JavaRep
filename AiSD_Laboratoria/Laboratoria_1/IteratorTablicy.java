package AiSD_Laboratoria.Laboratoria_1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorTablicy implements Iterator<Pracownik> {
    private Pracownik[] array;
    private int pos;

    public IteratorTablicy(Pracownik[] array) {
        this.array = array;
        this.pos = 0;
    }

    @Override
    public boolean hasNext() {
        if ((array[pos] != null) && (pos < array.length)){
            return true;
        }
        return false;
    }

    @Override
    public Pracownik next() throws NoSuchElementException {
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
