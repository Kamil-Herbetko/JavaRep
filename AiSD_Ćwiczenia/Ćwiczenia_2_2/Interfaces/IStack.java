package AiSD_Ćwiczenia.Ćwiczenia_2_2.Interfaces;

import AiSD_Ćwiczenia.Ćwiczenia_2_2.Exceptions.EmptyStackException;
import AiSD_Ćwiczenia.Ćwiczenia_2_2.Exceptions.FullStackException;

public interface IStack<T> {
    boolean isEmpty();
    boolean isFull();
    T pop() throws EmptyStackException;
    void push(T elem) throws FullStackException;
    int size();
    T top() throws EmptyStackException;
}
