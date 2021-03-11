package AiSD_Ćwiczenia.Ćwiczenia_2_1;

import java.util.Iterator;

public class IteratorLiczbowy implements Iterator<Integer> {
    private int current;
    private int max;

    public IteratorLiczbowy(int bottom, int up){
        this.max = up;
        this.current = bottom;
    }

    @Override
    public boolean hasNext() {
        if (current < max){
            return true;
        }
        return false;
    }

    @Override
    public Integer next(){
        return current++;
    }
}
