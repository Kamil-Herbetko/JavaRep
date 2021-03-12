package AiSD_Ćwiczenia.Ćwiczenia_2_2.MyQueues;

import AiSD_Ćwiczenia.Ćwiczenia_2_2.Exceptions.EmptyQueueException;
import AiSD_Ćwiczenia.Ćwiczenia_2_2.Exceptions.FullQueueException;
import AiSD_Ćwiczenia.Ćwiczenia_2_2.Interfaces.IQueue;

public class MyCyclicQueueWithCount<T> implements IQueue<T> {
    private static final int DEFAULT_CAPACITY = 1024;
    private T array[];
    private int beginIndex = 0;
    private int endIndex = 0;
    private int numer_of_elements = 0;

    public MyCyclicQueueWithCount(int size) {
        array=(T[])new Object[size];
    }

    public MyCyclicQueueWithCount(){
        this(DEFAULT_CAPACITY);
    }

    @Override
    public boolean isEmpty() {
        return numer_of_elements == 0;
    }

    @Override
    public boolean isFull() {
        return numer_of_elements == array.length;
    }

    @Override
    public T dequeue() throws EmptyQueueException {
        if(isEmpty()) {
            throw new EmptyQueueException();
        }
        T retValue = array[beginIndex++];
        beginIndex %= array.length;
        numer_of_elements -= 1;
        return retValue;
    }

    @Override
    public void enqueue(T elem) throws FullQueueException {
        if(isFull())
            throw new FullQueueException();
        array[endIndex++] = elem;
        endIndex %= array.length;
        numer_of_elements += 1;
    }

    @Override
    public int size() {
        return numer_of_elements;
    }

    @Override
    public T first() throws EmptyQueueException {
        if(isEmpty()) {
            throw new EmptyQueueException();
        }
        return array[beginIndex];
    }
}
