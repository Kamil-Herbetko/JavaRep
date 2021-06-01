package AiSD_Ćwiczenia.Ćwiczenia_2_2.Interfaces;

import AiSD_Laboratoria.Laboratoria_10.Node;
import AiSD_Ćwiczenia.Ćwiczenia_2_2.Exceptions.EmptyQueueException;
import AiSD_Ćwiczenia.Ćwiczenia_2_2.Exceptions.FullQueueException;

public interface IQueue<T> {
    boolean isEmpty();
    boolean isFull();
    T dequeue() throws EmptyQueueException;
    void enqueue(T elem) throws FullQueueException;
    int size();
    T first() throws EmptyQueueException;
}
