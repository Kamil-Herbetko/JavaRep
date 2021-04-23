package AiSD_Ćwiczenia.Ćwiczenia_3.Classes;

import java.util.Iterator;
import java.util.ListIterator;

public class OneWayLinkedListStraightWithHeadAndTail<T> extends AbstractList<T>{
    Element head = null;
    Element tail = null;

    public OneWayLinkedListStraightWithHeadAndTail() {}

    private Element getElement(int index){
        Element actElem=head;
        while(index>0 && actElem!=null){
            index--;
            actElem=actElem.getNext();
        }
        return actElem;
    }

    @Override
    public boolean insert(T e) {
        Element newElem = new Element(e);
        if (head==null){
            head = newElem;
            tail = newElem;
            return true;
        }
        tail.setNext(newElem);
        tail = newElem;
        return true;
    }

    @Override
    public boolean insert(int index, T data) {
        if (index < 0) return false;

        Element newElem = new Element(data);

        if (index == 0){
            newElem.setNext(head);
            head = newElem;
            return true;
        }

        Element actElem = getElement(index - 1);
        if (actElem == null) return false;

        newElem.setNext(actElem.getNext());
        actElem.setNext(newElem);

        if (actElem == tail) tail = newElem;
        return true;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
    }

    @Override
    public boolean contains(T element) {
        return indexOf(element) >= 0;
    }

    @Override
    public T get(int index) {
        Element actElem = getElement(index);
        return actElem==null?null:actElem.getValue();
    }

    @Override
    public T set(int index, T data) {
        Element actElem = getElement(index);
        if (actElem == null)
            return null;

        T elemData = actElem.getValue();
        actElem.setValue(data);
        return elemData;
    }

    @Override
    public int indexOf(T data) {
        int pos = 0;
        Element actElem = head;

        while (actElem != null){
            if (actElem.getValue().equals(data)) return pos;
            pos++;
            actElem = actElem.getNext();
        }

        return -1;
    }

    @Override
    public boolean isEmpty() {
        return head==null;
    }

    @Override
    public Iterator<T> iterator() {
        return new InnerIterator();
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public T delete(int index) {
        if (head == null) return null;
        if (index == 0){
            T retValue = head.getValue();
            head = head.getNext();
            return retValue;
        }
        Element actElem = getElement(index-1);

        if ((actElem == null) || (actElem.getNext() == null)) return null;

        T retValue = actElem.getNext().getValue();

        if (actElem.getNext() == tail) tail = actElem;

        actElem.setNext(actElem.getNext().getNext());
        return retValue;
    }

    @Override
    public boolean delete(T element) {
        if (head == null) return false;
        if (head.getValue().equals(element)){
            head=head.getNext();
            return true;
        }
        Element actElem = head;

        while ((actElem.getNext()) != null && !actElem.getNext().getValue().equals(element))
            actElem = actElem.getNext();

        if (actElem.getNext() == null) return false;
        if (actElem.getNext() == tail) tail = actElem;

        actElem.setNext(actElem.getNext().getNext());
        return true;
    }

    @Override
    public int size() {
        int pos = 0;
        Element actElem = head;
        while (actElem != null){
            pos++;
            actElem = actElem.getNext();
        }

        return pos;
    }

    @Override
    public void wyswietlListe() {
        Element element = head;
        System.out.println("[");
        while (element != null){
            System.out.print(element.getValue().toString());
            element = element.getNext();
        }
        System.out.println("]");
    }

    private class Element{
        private T value;
        private Element next;

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Element getNext() {
            return next;
        }

        public void setNext(Element next) {
            this.next = next;
        }

        public Element(T value) {
            this.value = value;
        }
    }

    private class InnerIterator implements Iterator<T>{
        OneWayLinkedListStraightWithHeadAndTail.Element actElem;

        public InnerIterator() {
            this.actElem = head;
        }

        @Override
        public boolean hasNext() {
            return actElem != null;
        }

        @Override
        public T next() {
            T value = (T) actElem.getValue();
            actElem = actElem.getNext();
            return value;
        }
    }

    @Override
    public String toString() {
        String str = "[";
        Element actElem = head;
        while (actElem != null){
            str += actElem.getValue().toString() + ", ";
            actElem = actElem.next;
        }
        str += "]";
        return str;
    }
}
