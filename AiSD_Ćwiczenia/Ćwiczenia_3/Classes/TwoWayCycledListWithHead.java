package AiSD_Ćwiczenia.Ćwiczenia_3.Classes;

import java.util.Iterator;
import java.util.ListIterator;

public class TwoWayCycledListWithHead<T> extends AbstractList<T>{
    Element head = null;

    public Element getHead() {
        return head;
    }

    public void setHead(Element head) {
        this.head = head;
    }

    public TwoWayCycledListWithHead(){}

    private Element getElement(int index){
        if (head == null){
            return null;
        }
        if (index == 0){
            return head;
        }
        Element elem = head.getNext();
        int counter=1;

        while(elem!=head && counter<index){
            counter++;
            elem=elem.getNext();
        }

        if(elem==head)
            throw new IndexOutOfBoundsException();
        return elem;
    }

    private Element getElement(T value){
        if (head == null){
            return null;
        }
        if (head.getValue() == value){
            return head;
        }
        Element elem=head.getNext();
        int counter=1;
        while(elem!=head && !value.equals(elem.getValue())){
            counter++;
            elem=elem.getNext();}
        if(elem==head)
            return null;
        return elem;
    }

    @Override
    public boolean insert(T e) {
        Element newElem = new Element(e);
        if (head == null){
            head = newElem;
            newElem.setNext(newElem);
            newElem.setPrev(newElem);
            return true;
        }
        head.insertBefore(newElem);
        return true;

    }

    @Override
    public boolean insert(int index, T data) {
        if(index<0) return false;

        Element newElem = new Element(data);
        if (head == null && index == 0){
            head = newElem;
            newElem.setNext(newElem);
            newElem.setPrev(newElem);
            return true;
        }
        if (index == 0){
            head.insertBefore(newElem);
            head = newElem;
            return true;
        }
        else {
            Element element = getElement(index - 1);
            if (element == null) return false;
            element.insertAfter(newElem);
        }
        return true;
    }

    @Override
    public void clear() {
        head = null;
    }

    @Override
    public boolean contains(T element) {
        return indexOf(element) != -1;
    }

    @Override
    public T get(int index) {
        Element elem = getElement(index);
        if (elem == null){
            return null;
        }

        return elem.getValue();
    }

    @Override
    public T set(int index, T data) {
        Element elem = getElement(index);
        if (elem == null){
            return null;
        }
        T retValue = elem.getValue();
        elem.setValue(data);
        return retValue;
    }

    @Override
    public int indexOf(T data) {
        if (head == null) return -1;
        Element element = head.getNext();
        int counter = 0;

        while (element!= head && !element.getValue().equals(data)){
            counter++;
            element = element.getNext();
        }
        if (element==head) return -1;
        return counter;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public T delete(int index) {
        Element element = getElement(index);
        if (element == null) return null;
        element.remove();
        return element.getValue();
    }

    @Override
    public boolean delete(T element) {
        Element elem = getElement(element);
        if (elem == null) return false;
        elem.remove();
        return true;
    }

    @Override
    public int size() {
        if (head == null) return 0;
        Element element = head.getNext();
        int counter = 1;
        while (element != head){
            counter++;
            element = element.getNext();
        }
        return counter;
    }

    @Override
    public void wyswietlListe() {

        Element element = head;
        System.out.print("[");
        while (element.getNext() != head){
            System.out.print(element.getValue() + ", ");
            element = element.getNext();
        }
        System.out.println(element.getValue() + "]");
    }

    private class Element{
        private T value;
        private Element next;
        private Element prev;
        public T getValue() { return value; }
        public void setValue(T value) { this.value = value; }
        public Element getNext() {return next;}
        public void setNext(Element next) {this.next = next;}
        public Element getPrev() {return prev;}
        public void setPrev(Element prev) {this.prev = prev;}
        Element(T data){this.value=data;
        }

        public void insertAfter(Element elem){
            elem.setNext(this.getNext());
            elem.setPrev(this);
            this.getNext().setPrev(elem);
            this.setNext(elem);
        }

        public void insertBefore(Element elem){
            elem.setNext(this);
            elem.setPrev(this.getPrev());
            this.getPrev().setNext(elem);
            this.setPrev(elem);
        }

        public void remove(){
            this.getNext().setPrev(this.getPrev());
            this.getPrev().setNext(this.getNext());
        }
    }
}
