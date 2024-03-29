package AiSD_Ćwiczenia.Ćwiczenia_2_2.MyQueues;

import AiSD_Ćwiczenia.Ćwiczenia_2_2.Exceptions.EmptyQueueException;
import AiSD_Ćwiczenia.Ćwiczenia_2_2.Exceptions.FullQueueException;
import AiSD_Ćwiczenia.Ćwiczenia_2_2.Interfaces.IQueue;

public class MyCyclicQueue<T> implements IQueue<T> {
    private static final int DEFAULT_CAPACITY = 1024;
    private T array[];
    private int beginIndex = 0;
    private int endIndex = 0;

    @SuppressWarnings("unchecked")
    public MyCyclicQueue(int size) {
        array=(T[])new Object[size+1];
    }

    public MyCyclicQueue() {
        this(DEFAULT_CAPACITY);
    }


    @Override
    public boolean isEmpty() {
        return beginIndex == endIndex;
    }

    @Override
    public boolean isFull() {
        return beginIndex == (endIndex+1)%array.length;
    }

    @Override
    public T dequeue() throws EmptyQueueException {
        if(isEmpty()) {
            throw new EmptyQueueException();
        }
        T retValue = array[beginIndex++];
        beginIndex %= array.length;
        return retValue;
    }

    @Override
    public void enqueue(T elem) throws FullQueueException {
        if(isFull())
            throw new FullQueueException();
        array[endIndex++] = elem;
        endIndex %= array.length;
    }

    @Override
    public int size() {
        return (endIndex + array.length - beginIndex) % array.length;
    }

    @Override
    public T first() throws EmptyQueueException {
        if(isEmpty()) {
            throw new EmptyQueueException();
        }
        return array[beginIndex];
    }
}
