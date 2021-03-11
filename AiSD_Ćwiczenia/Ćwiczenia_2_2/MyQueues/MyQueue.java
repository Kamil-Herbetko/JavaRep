package AiSD_Ćwiczenia.Ćwiczenia_2_2.MyQueues;

import AiSD_Ćwiczenia.Ćwiczenia_2_2.Exceptions.EmptyQueueException;
import AiSD_Ćwiczenia.Ćwiczenia_2_2.Exceptions.FullQueueException;
import AiSD_Ćwiczenia.Ćwiczenia_2_2.Interfaces.IQueue;

public class MyQueue<T> implements IQueue<T> {
    private static final int DEFAULT_CAPACITY = 1024;
    private T array[];
    private int endIndex = 0;

    @SuppressWarnings("unchecked")
    public MyQueue(int size) {
        array=(T[])new Object[size];
    }

    public MyQueue() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public boolean isEmpty() {
        return endIndex == 0;
    }

    @Override
    public boolean isFull() {
        return endIndex == array.length;
    }

    @Override
    public T dequeue() throws EmptyQueueException {
        if(isEmpty()) {
            throw new EmptyQueueException();
        }
        T retValue = array[0];
        for (int i = 0; i < endIndex - 1; i++) {
            array[i] = array[i+1];
        }
        endIndex -= 1;
        return retValue;
    }

    @Override
    public void enqueue(T elem) throws FullQueueException {
        if(isFull()) {
            throw new FullQueueException();
        }
        array[endIndex++] = elem;

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public T first() throws EmptyQueueException {
        if(isEmpty()) {
            throw new EmptyQueueException();
        }
        return array[0];
    }
}
