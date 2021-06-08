package AiSD_Laboratoria.Laboratoria_12;

import java.util.Iterator;

public class Lista<E> {
    Element head = null;

    public Lista() {
    }

    public boolean isEmpty() {
        return head == null;
    }


    public int size() {
        int pos = 0;
        Element actElem = head;
        while (actElem != null) {
            pos++;
            actElem = actElem.getNext();
        }
        return pos;
    }


    private Element getElement(int index) {
        Element actElem = head;
        while (index > 0 && actElem != null) {
            index--;
            actElem = actElem.getNext();
        }
        return actElem;
    }


    public boolean add(int index, E data,int weight) {
        if (index < 0) return false;
        Element newElem = new Element(data,weight);
        if (index == 0) {
            newElem.setNext(head);
            head = newElem;
            return true;
        }
        Element actElem = getElement(index - 1);
        if (actElem == null)
            return false;
        newElem.setNext(actElem.getNext());
        actElem.setNext(newElem);
        return true;
    }

    private class InnerIterator implements Iterator<Element> {
        Element actElem;

        public InnerIterator() {
            actElem = head;
        }

        @Override
        public boolean hasNext() {
            return actElem != null;
        }

        @Override
        public Element next() {
            Element value = actElem;
            actElem = actElem.getNext();
            return value;
        }
    }

    public Iterator<Element> iterator() {
        return new InnerIterator();
    }
}
