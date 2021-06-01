package AiSD_Laboratoria.Laboratoria_11;

public interface Queue<T> {
    boolean isEmpty();

    boolean isFull();

    T dequeue() throws EmptyQueueException;

    void enqueue(T elem) throws FullQueueException;

    int size();

    T first() throws EmptyQueueException;

}
