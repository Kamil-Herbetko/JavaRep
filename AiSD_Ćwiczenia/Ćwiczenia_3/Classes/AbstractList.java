package AiSD_Ćwiczenia.Ćwiczenia_3.Classes;

import AiSD_Ćwiczenia.Ćwiczenia_3.Interfaces.IList;

import java.util.Iterator;

public abstract class AbstractList<T> implements IList<T> {
    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("[");
        if (!isEmpty()){
            for (T item : this){
                buffer.append(item).append(", ");
                buffer.setLength(buffer.length() - 2);
            }
        }
        buffer.append(']');
        return buffer.toString();
    }

    @Override
    public int hashCode() {
        int hashCode = 0;
        for (T item:this) {
            hashCode ^= item.hashCode();
        }
        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        if (getClass() != obj.getClass()){
            return false;
        }
        return equals((IList<T>) obj);
    }

    public boolean equals(IList<T> other){
        if (other == null || size() != other.size()){
            return false;
        }
        else {
            Iterator<T> i = iterator();
            Iterator<T> j = other.iterator();
            for (;i.hasNext() && j.hasNext() && i.next().equals(j.next());) {
                
            }
            return !i.hasNext() && !j.hasNext();
        }
    }
}
