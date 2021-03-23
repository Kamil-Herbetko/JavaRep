package AiSD_Laboratoria.Laboratoria_3;

import AiSD_Ćwiczenia.Ćwiczenia_2_2.Exceptions.EmptyStackException;
import AiSD_Ćwiczenia.Ćwiczenia_2_2.Exceptions.FullStackException;

import java.util.Arrays;
import java.util.Objects;

public class ArrayStack<T> implements IStack<T>{
    private static final int DEFAULT_CAPACITY = 1024;
    private T array[];
    private int topIndex;

    @SuppressWarnings("unchecked")
    public ArrayStack(int initialSize) {
        this.array = (T[]) (new Object[initialSize]);
        this.topIndex = 0;
    }

    public ArrayStack(){
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

    public void reverseStack(){
        for (int i = 0; i < topIndex/2; i++) {
            T temp = array[topIndex-1-i];
            array[topIndex-1-i] = array[i];
            array[i] = temp;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayStack<?> that = (ArrayStack<?>) o;
        return topIndex == that.topIndex && Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(topIndex);
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }


}
