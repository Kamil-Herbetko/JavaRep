package AiSD_Ćwiczenia.Ćwiczenia_3.Zadania;

import AiSD_Ćwiczenia.Ćwiczenia_2_2.Exceptions.EmptyQueueException;
import AiSD_Ćwiczenia.Ćwiczenia_2_2.Exceptions.EmptyStackException;
import AiSD_Ćwiczenia.Ćwiczenia_2_2.Exceptions.FullQueueException;
import AiSD_Ćwiczenia.Ćwiczenia_2_2.Interfaces.IQueue;
import AiSD_Ćwiczenia.Ćwiczenia_3.Classes.OneWayLinkedStraightListWithHead;
import AiSD_Ćwiczenia.Ćwiczenia_3.Interfaces.IList;

public class ListQueue<T> implements IQueue<T> {
    private IList<T> _list;

    public ListQueue() {
        this._list = new OneWayLinkedStraightListWithHead<T>();
    }

    @Override
    public boolean isEmpty() {
        return _list.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public T dequeue() throws EmptyQueueException {
        T value = _list.delete(_list.size() - 1);
        if(value==null) throw new EmptyQueueException();
        return value;
    }

    @Override
    public void enqueue(T elem) throws FullQueueException {
        _list.insert(0, elem);
    }

    @Override
    public int size() {
        return _list.size();
    }

    @Override
    public T first() throws EmptyQueueException {
        T value=_list.get(0);
        if(value==null) throw new EmptyQueueException();
        return value;
    }
}
