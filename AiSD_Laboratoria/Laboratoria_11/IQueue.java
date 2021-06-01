package AiSD_Laboratoria.Laboratoria_11;

public class IQueue<T> implements Queue<T> {
    private static final int DEFAULT_CAPACITY = 50;
    T array[];
    int beginIndex;
    int endIndex;

    @SuppressWarnings("unchecked")
    public IQueue(int size) {
        array = (T[]) new Object[size + 1];
    }

    public IQueue() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public boolean isEmpty() {
        return beginIndex == endIndex;
    }

    @Override
    public boolean isFull() {
        return beginIndex == (endIndex + 1) % array.length;
    }

    @Override
    public T dequeue() throws EmptyQueueException {
        if (isEmpty())
            throw new EmptyQueueException();
        T retValue = array[beginIndex++];
        beginIndex %= array.length;

        return retValue;
    }

    @Override
    public void enqueue(T elem) throws FullQueueException {
        if (isFull())
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
        if (isEmpty())
            throw new EmptyQueueException();
        return array[beginIndex];
    }
}
