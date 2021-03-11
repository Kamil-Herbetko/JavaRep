package AiSD_Ćwiczenia.Ćwiczenia_2_2.MyStacks;

import AiSD_Ćwiczenia.Ćwiczenia_2_2.Exceptions.EmptyStackException;
import AiSD_Ćwiczenia.Ćwiczenia_2_2.Exceptions.FullStackException;
import AiSD_Ćwiczenia.Ćwiczenia_2_2.Interfaces.IStack;

public class MyStack<T> implements IStack<T> {
    private static final int DEFAULT_CAPACITY = 1024;
    private T array[];
    private int topIndex;

    @SuppressWarnings("unchecked")
    public MyStack(int initialSize) {
        this.array = (T[]) (new Object[initialSize]);
        this.topIndex = 0;
    }

    public MyStack(){
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
    public void push(T elem) throws FullStackException {
        if (isFull()){
            throw new FullStackException();
        }
        array[topIndex++] = elem;
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
