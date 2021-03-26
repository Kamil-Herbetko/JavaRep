package AiSD_Ćwiczenia.Ćwiczenia_3;

import AiSD_Ćwiczenia.Ćwiczenia_2_2.Exceptions.EmptyQueueException;
import AiSD_Ćwiczenia.Ćwiczenia_2_2.Exceptions.EmptyStackException;
import AiSD_Ćwiczenia.Ćwiczenia_2_2.Exceptions.FullQueueException;
import AiSD_Ćwiczenia.Ćwiczenia_3.Classes.OneWayLinkedListStraightWithSentinel;
import AiSD_Ćwiczenia.Ćwiczenia_3.Classes.OneWayLinkedStraightListWithHead;
import AiSD_Ćwiczenia.Ćwiczenia_3.Classes.TwoWayCycledListWithHead;
import AiSD_Ćwiczenia.Ćwiczenia_3.Zadania.ListQueue;
import AiSD_Ćwiczenia.Ćwiczenia_3.Zadania.ListStack;
import AiSD_Ćwiczenia.Ćwiczenia_3.Zadania.Merge2WayCycledLists;
import AiSD_Ćwiczenia.Ćwiczenia_3.Zadania.RecursivePrint;


public class Main {
    public static void main(String[] args) throws FullQueueException, EmptyQueueException, EmptyStackException {
        try2WCLWH();
    }

    public static void tryRecursivePrint(){
        OneWayLinkedStraightListWithHead<String> linkedlist = new OneWayLinkedStraightListWithHead<>();
        linkedlist.insert("A");
        linkedlist.insert("B");
        linkedlist.insert("C");
        RecursivePrint.recursivePrintFromBeginning(linkedlist);
        RecursivePrint.recursivePrintFromEnd(linkedlist);
    }

    public static void try1WLLSWSaH(){
        OneWayLinkedListStraightWithSentinel<String> llista = new OneWayLinkedListStraightWithSentinel<>();
        llista.insert("A");
        llista.insert("B");
        llista.insert("C");
        llista.wyswietlListe();
        llista.insert(0, "D");
        llista.wyswietlListe();
        llista.insert(2, "E");
        llista.wyswietlListe();
        llista.delete("E");
        llista.wyswietlListe();
        llista.delete(3);
        llista.wyswietlListe();
        llista.clear();
        llista.wyswietlListe();
    }

    public static void try2WCLWH(){
        TwoWayCycledListWithHead<String> doublelist1 = new TwoWayCycledListWithHead<>();
        TwoWayCycledListWithHead<String> doublelist2 = new TwoWayCycledListWithHead<>();
        doublelist1.insert("A");
        doublelist1.insert("B");
        doublelist1.insert("C");
        doublelist1.insert("D");
        doublelist2.insert("F");
        doublelist2.insert("G");
        doublelist2.insert("H");
        doublelist2.insert("I");
        Merge2WayCycledLists.merge2toEndOf1(doublelist1, doublelist2).wyswietlListe();
        Merge2WayCycledLists.merge2toAnywhereIn1(doublelist1, doublelist2, 2).wyswietlListe();
    }
}
