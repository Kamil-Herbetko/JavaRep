package AiSD_Ćwiczenia.Ćwiczenia_3.Zadania;

import AiSD_Ćwiczenia.Ćwiczenia_3.Classes.TwoWayCycledListWithHead;

public class Merge2WayCycledLists {
    public static <T> TwoWayCycledListWithHead<T> merge2toEndOf1(TwoWayCycledListWithHead<T> list1, TwoWayCycledListWithHead<T> list2){
        if (list1.isEmpty()){
            return list2;
        }
        else if (list2.isEmpty()){
            return list1;
        }
        else{
            for (int i = 0; i < list2.size(); i++) {
                list1.insert(list2.get(i));
            }
        }
        return list1;
    }

    public static <T> TwoWayCycledListWithHead<T> merge2toAnywhereIn1(TwoWayCycledListWithHead<T> list1, TwoWayCycledListWithHead<T> list2, int index){
        if (index < 0) return null;

        if (list1.isEmpty()){
            return list2;
        }
        else if (list2.isEmpty()){
            return list1;
        }
        else {
            for (int i = 0; i < list2.size(); i++) {
                list1.insert(index, list2.get(i));
            }
        }
        return list1;
    }
}
