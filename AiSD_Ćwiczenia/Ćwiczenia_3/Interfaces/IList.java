package AiSD_Ćwiczenia.Ćwiczenia_3.Interfaces;



import java.util.Iterator;
import java.util.ListIterator;

public interface IList <T> extends Iterable<T>{
    boolean insert(T e);
    boolean insert(int index, T data);
    void clear();
    boolean contains(T element);
    T get(int index);
    T set(int index, T data);
    int indexOf(T data);
    boolean isEmpty();
    Iterator<T> iterator();
    ListIterator<T> listIterator();
    T delete(int index);
    boolean delete(T element);
    int size();
    void wyswietlListe();
}
