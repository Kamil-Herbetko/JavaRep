package AiSD_Ćwiczenia.Ćwiczenia_2_2.MyStacks;

import AiSD_Ćwiczenia.Ćwiczenia_2_2.Exceptions.EmptyStackException;
import AiSD_Ćwiczenia.Ćwiczenia_2_2.Exceptions.FullStackException;
import AiSD_Ćwiczenia.Ćwiczenia_2_2.IStack;

public class MyDrowningStack<T> implements IStack<T> {
    private static final int DEFAULT_CAPACITY = 1024;
    private T array[];
    private int topIndex;

    @SuppressWarnings("unchecked")
    public MyDrowningStack(int initialSize) {
        this.array = (T[]) (new Object[initialSize]);
        this.topIndex = 0;
    }

    public MyDrowningStack(){
        this(DEFAULT_CAPACITY);
    }

    @Override
    public boolean isEmpty() {
        return topIndex == 0;
    }

    @Override
    public boolean isFull() {
        return topIndex == array.length;
    }

    @Override
    public T pop() throws EmptyStackException {
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return array[--topIndex];
    }

    @Override
    public void push(T elem){
        if (isFull()){
            for (int i = 0; i < array.length - 1; i++) {
                array[i] = array[i+1];
            }

            array[topIndex - 1] = elem;
        }
        else {
            array[topIndex++] = elem;
        }

    }

    @Override
    public int size() {
        return topIndex;
    }

    @Override
    public T top() throws EmptyStackException {
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return array[topIndex-1];
    }
}
