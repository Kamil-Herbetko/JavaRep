package AiSD_Ćwiczenia.Ćwiczenia_3.Classes;

import java.io.Serial;
import java.io.Serializable;
import java.util.Iterator;
import java.util.ListIterator;

public class TwoWayCycledListWithSentinel<E> extends AbstractList<E> implements Serializable {
    @Serial
    private static final long serialVersionUID = 6779088417156480028L;

    private class Element implements Serializable{

        @Serial
        private static final long serialVersionUID = 6076478991689512669L;
        private E value;
        private Element next;
        private Element prev;
        public E getValue() { return value; }
        public void setValue(E value) { this.value = value; }
        public Element getNext() {return next;}
        public void setNext(Element next) {this.next = next;}
        public Element getPrev() {return prev;}
        public void setPrev(Element prev) {this.prev = prev;}
        Element(E data){this.value=data;}
        /** elem będzie stawiony <b> za this </b>*/
        public void insertAfter(Element elem){
            elem.setNext(this.getNext());
            elem.setPrev(this);
            this.getNext().setPrev(elem);
            this.setNext(elem);}
        /** elem będzie stawiany <b> przed this </b>*/
        public void insertBefore(Element elem){
            elem.setNext(this);
            elem.setPrev(this.getPrev());
            this.getPrev().setNext(elem);
            this.setPrev(elem);}
        /** elem będzie usuwany z listy w której jest <p>
         * <b>Założenie:</b> element jest już umieszczony w liście i nie jest to sentinel */
        public void remove(){
            this.getNext().setPrev(this.getPrev());
            this.getPrev().setNext(this.getNext());
        }
    }

    Element sentinel=null;

    public TwoWayCycledListWithSentinel() {
        sentinel=new Element(null);
        sentinel.setNext(sentinel);
        sentinel.setPrev(sentinel);
    }

    private Element getElement(int index){
        Element elem=sentinel.getNext();
        int counter=0;
        while(elem!=sentinel && counter<index){
            counter++;
            elem=elem.getNext();}
        if(elem==sentinel)
            throw new IndexOutOfBoundsException();
        return elem;
    }

    private Element getElement(E value){
        Element elem=sentinel.getNext();
        int counter=0;
        while(elem!=sentinel && !value.equals(elem.getValue())){
            counter++;
            elem=elem.getNext();}
        if(elem==sentinel)
            return null;
        return elem;
    }

    public boolean isEmpty() {
        return sentinel.getNext()==sentinel;
    }

    public void clear() {
        sentinel.setNext(sentinel);
        sentinel.setPrev(sentinel);
    }

    public boolean contains(E value) {
        return indexOf(value)!=-1;
    }

    public E get(int index) {
        Element elem=getElement(index);
        return elem.getValue();
    }

    public E set(int index, E value) {
        Element elem=getElement(index);
        E retValue=elem.getValue();
        elem.setValue(value);
        return retValue;
    }

    public boolean insert(E value) {
        Element newElem=new Element(value);
        sentinel.insertBefore(newElem);
        return true;
    }

    public boolean insert(int index, E value) {
        Element newElem=new Element(value);
        if(index==0) sentinel.insertAfter(newElem);
        else{
            Element elem=getElement(index-1);
            elem.insertAfter(newElem);}
        return true;
    }

    public int indexOf(E value) {
        Element elem=sentinel.getNext();
        int counter=0;
        while(elem!=sentinel && !elem.getValue().equals(value)){
            counter++;
            elem=elem.getNext();}
        if(elem==sentinel)
            return -1;
        return counter;
    }

    public E delete(int index) {
        Element elem=getElement(index);
        elem.remove();
        return elem.getValue();
    }

    public boolean delete(E value) {
        Element elem=getElement(value);
        if(elem==null) return false;
        elem.remove();
        return true;
    }

    public int size() {
        Element elem=sentinel.getNext();
        int counter=0;
        while(elem!=sentinel){
            counter++;
            elem=elem.getNext();
        }
        return counter;
    }

    @Override
    public void wyswietlListe() {

    }

    public Iterator<E> iterator() {
        return new TWCIterator();
    }

    private class TWCIterator implements Iterator<E>{
        Element _current=sentinel;
        public boolean hasNext() {
            return _current.getNext()!=sentinel;}
        public E next() {
            _current=_current.getNext();
            return _current.getValue();}
    }
    public ListIterator<E> listIterator() {
        return new TWCListIterator();
    }

    private class TWCListIterator implements ListIterator<E>{
        boolean wasNext=false;
        boolean wasPrevious=false;
        /** strażnik */
        Element _current=sentinel;

        public boolean hasNext() {
            return _current.getNext()!=sentinel;
        }

        public boolean hasPrevious() {
            return _current!=sentinel;
        }

        public int nextIndex() {
            throw new UnsupportedOperationException();
        }

        public int previousIndex() {
            throw new UnsupportedOperationException();
        }

        public E next() {
            wasNext=true;
            wasPrevious=false;
            _current=_current.getNext();
            return _current.getValue();
        }

        public E previous() {
            wasNext=false;
            wasPrevious=true;
            E retValue=_current.getValue();
            _current=_current.getPrev();
            return retValue;
        }

        public void remove() {
            if(wasNext){
                Element curr=_current.getPrev();
                _current.remove();
                _current=curr;
                wasNext=false;
            }
            if(wasPrevious){
                _current.getNext().remove();
                wasPrevious=false;
            }
        }

        public void add(E data) {
            Element newElem=new Element(data);
            _current.insertAfter(newElem);
            _current=_current.getNext();
        }

        public void set(E data) {
            if(wasNext){
                _current.setValue(data);
                wasNext=false;
            }
            if(wasPrevious){
                _current.getNext().setValue(data);
                wasNext=false;
            }
        }
    }
}
