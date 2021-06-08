package AiSD_Laboratoria.Laboratoria_12;

import java.util.Comparator;
import java.util.Objects;

public class Element<E> {
    private E value;
    private int weight;
    private Element next;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Element(E value, int weight) {
        this.value = value;
        this.weight = weight;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public Element getNext() {
        return next;
    }

    public void setNext(Element next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Element<?> element = (Element<?>) o;
        return weight == element.weight && Objects.equals(value, element.value) && Objects.equals(next, element.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
