package AiSD_Ćwiczenia.Ćwiczenia_3.Classes;

import java.util.Iterator;
import java.util.ListIterator;

public class OneWayLinkedStraightListWithHead<T> extends AbstractList<T>{
    Element head = null;

    public OneWayLinkedStraightListWithHead() {}

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
        Element newElem=new Element(e);
        if(head==null){
            head=newElem;
            return true;
        }
        Element tail=head;
        while(tail.getNext()!=null)
            tail=tail.getNext();
        tail.setNext(newElem);
        return true;
    }

    @Override
    public boolean insert(int index, T data) {
        if(index<0) return false;

        Element newElem=new Element(data);

        if(index==0)
        {
            newElem.setNext(head);
            head=newElem;
            return true;
        }
        Element actElem=getElement(index-1);

        if(actElem==null) return false;

        newElem.setNext(actElem.getNext());
        actElem.setNext(newElem);
        return true;
    }

    @Override
    public void clear() {
        head = null;
    }

    @Override
    public boolean contains(T element) {
        return indexOf(element)>=0;
    }

    @Override
    public T get(int index) {
        Element actElem=getElement(index);
        return actElem==null?null:actElem.getValue();
    }

    @Override
    public T set(int index, T data) {
        Element actElem=getElement(index);
        if(actElem==null)
            return null;
        T elemData=actElem.getValue();
        actElem.setValue(data);
        return elemData;
    }

    @Override
    public int indexOf(T data) {
        int pos=0;
        Element actElem=head;
        while(actElem!=null)
        {
            if(actElem.getValue().equals(data))
                return pos;
            pos++;
            actElem=actElem.getNext();
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
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
        if(head==null)
            return null;
        if(index==0){
            T retValue=head.getValue();
            head=head.getNext();
            return retValue;}
        Element actElem=getElement(index-1);
        if(actElem==null || actElem.getNext()==null)
            return null;
        T retValue=actElem.getNext().getValue();
        actElem.setNext(actElem.getNext().getNext());
        return retValue;
    }

    @Override
    public boolean delete(T element) {
        if(head==null)
            return false;
        if(head.getValue().equals(element)){
            head=head.getNext();
            return true;}
        Element actElem=head;
        while(actElem.getNext()!=null && !actElem.getNext().getValue().equals(element))
            actElem=actElem.getNext();
        if(actElem.getNext()==null)
            return false;
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
        System.out.println(this.toString());
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

        Element(T data){
            this.value = data;
        }
    }

    private class InnerIterator implements Iterator<T>{
        OneWayLinkedStraightListWithHead.Element actElem;
        public InnerIterator() {
            actElem=head;
        }
        @Override
        public boolean hasNext() {
            return actElem!=null;
        }
        @Override
        public T next() {
            T value= (T) actElem.getValue();
            actElem=actElem.getNext();
            return value;
        }
    }

}
