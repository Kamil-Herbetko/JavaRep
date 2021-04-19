package AiSD_Ćwiczenia.Ćwiczenia_3.Zadania;

import AiSD_Laboratoria.Laboratoria_3.IStack;
import AiSD_Ćwiczenia.Ćwiczenia_2_2.Exceptions.EmptyStackException;
import AiSD_Ćwiczenia.Ćwiczenia_3.Classes.OneWayLinkedStraightListWithHead;
import AiSD_Ćwiczenia.Ćwiczenia_3.Interfaces.IList;

public class ListStack<E> implements IStack<E> {
    private IList<E> _list;

    public ListStack(){
        this._list = new OneWayLinkedStraightListWithHead<E>();
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
    public E pop() throws EmptyStackException {
        E value=_list.delete(0);
        if(value==null) throw new EmptyStackException();
        return value;
    }

    @Override
    public void push(E elem){
        _list.insert(0,elem);
    }

    @Override
    public int size() {
        return _list.size();
    }

    @Override
    public E top() throws EmptyStackException {
        E value=_list.get(0);
        if(value==null) throw new EmptyStackException();
        return value;
    }
}
