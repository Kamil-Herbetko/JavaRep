package AiSD_Ćwiczenia.Ćwiczenia_3.Zadania;

import AiSD_Ćwiczenia.Ćwiczenia_3.Classes.OneWayLinkedStraightListWithHead;

public class RecursivePrint {
    public static <T> void recursivePrintFromBeginning(OneWayLinkedStraightListWithHead<T> _list, int...args){
        if (args.length == 0){
            System.out.println(_list.get(0).toString());
            recursivePrintFromBeginning(_list, 1);
        }
        else {
            if (args[0] < _list.size()){
                System.out.println(_list.get(args[0]).toString());
                recursivePrintFromBeginning(_list, args[0] + 1);
            }
        }

    }

    public static <T> void recursivePrintFromEnd(OneWayLinkedStraightListWithHead<T> _list, int...args){
        if (args.length == 0){
            System.out.println(_list.get(_list.size() - 1).toString());
            recursivePrintFromEnd(_list, _list.size() - 2);
        }
        else {
            if (args[0] > 0){
                System.out.println(_list.get(args[0]).toString());
                recursivePrintFromEnd(_list, args[0] - 1);
            }
            else {
                System.out.println(_list.get(args[0]).toString());
            }
        }
    }
}
