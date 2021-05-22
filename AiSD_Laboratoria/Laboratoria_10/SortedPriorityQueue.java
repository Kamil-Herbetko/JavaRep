package AiSD_Laboratoria.Laboratoria_10;

import AiSD_Ćwiczenia.Ćwiczenia_2_2.Exceptions.EmptyQueueException;
import AiSD_Ćwiczenia.Ćwiczenia_2_2.Exceptions.FullQueueException;
import AiSD_Ćwiczenia.Ćwiczenia_2_2.Interfaces.IQueue;



public class SortedPriorityQueue implements IQueue {
    private Node[] pQueue;
    private Comparator _comparator;
    private int _size;

    public SortedPriorityQueue(int size) {
        this.pQueue = new Node[size];
        this._comparator = new Comparator();
        this._size = 0;
    }

    @Override
    public boolean isEmpty() {
        return pQueue[0] == null;
    }

    @Override
    public boolean isFull() {
        return pQueue.length == _size;
    }

    @Override
    public Node dequeue() throws EmptyQueueException {
        if (isEmpty()) throw new EmptyQueueException();
        Node elem = pQueue[_size - 1];
        pQueue[_size - 1] = null;
        _size--;
        return elem;
    }

    @Override
    public void enqueue(Object elem) throws FullQueueException {
        if (elem instanceof Node){
            if (isFull()) throw new FullQueueException();
            int pos = 0;
            while (pQueue[pos] != null){
                if (_comparator.compare((Node) elem, pQueue[pos]) >= 0){
                    break;
                }
                pos++;
            }
            insert((Node) elem, pos);
            _size++;
        }
    }

    private void insert(Node elem, int index){
        if (isEmpty()){
            pQueue[0] = elem;
            return;
        }
        Node temp = pQueue[index];
        while (pQueue[index + 1] != null) {
            pQueue[index] = elem;
            elem = temp;
            temp = pQueue[++index];
        }
        pQueue[index] = elem;
        pQueue[index + 1] = temp;
    }

    @Override
    public int size() {
        return _size;
    }

    @Override
    public Node first() throws EmptyQueueException {
        if (isEmpty()) throw new EmptyQueueException();
        return pQueue[_size - 1];
    }

    private class Comparator implements java.util.Comparator<Node>{
        @Override
        public int compare(Node o1, Node o2) {
            if (o1.getWeight() > o2.getWeight()){
                return 1;
            }
            else if (o1.getWeight() < o2.getWeight()){
                return -1;
            }
            if (o1.getChars().length() == o2.getChars().length()){
                return 0;
            }
            return ((o1.getChars().length() - o2.getChars().length())/Math.abs(o1.getChars().length() - o2.getChars().length()));
        }
    }
}
