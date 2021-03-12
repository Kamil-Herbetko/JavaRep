package AiSD_Ćwiczenia.Ćwiczenia_2_2;

import AiSD_Ćwiczenia.Ćwiczenia_2_2.Exceptions.EmptyQueueException;
import AiSD_Ćwiczenia.Ćwiczenia_2_2.Exceptions.EmptyStackException;
import AiSD_Ćwiczenia.Ćwiczenia_2_2.Exceptions.FullQueueException;
import AiSD_Ćwiczenia.Ćwiczenia_2_2.Exceptions.FullStackException;
import AiSD_Ćwiczenia.Ćwiczenia_2_2.MyQueues.MyCyclicQueue;
import AiSD_Ćwiczenia.Ćwiczenia_2_2.MyQueues.MyCyclicQueueWithCount;
import AiSD_Ćwiczenia.Ćwiczenia_2_2.MyQueues.MyQueue;
import AiSD_Ćwiczenia.Ćwiczenia_2_2.MyStacks.MyDrowningStack;
import AiSD_Ćwiczenia.Ćwiczenia_2_2.MyStacks.MyStack;

public class Main {
    public static void main(String[] args) throws FullStackException, FullQueueException, EmptyQueueException, EmptyStackException {
        MyStack<Integer> myStack = new MyStack<>(10);
        MyDrowningStack<Integer> myDrowningStack = new MyDrowningStack<>(10);
        MyQueue<Integer> myQueue = new MyQueue<>(10);
        MyCyclicQueue<Integer> myCyclicQueue = new MyCyclicQueue<>(10);
        MyCyclicQueueWithCount<Integer> myCyclicQueueWithCount = new MyCyclicQueueWithCount<>(10);

        //test_Stack(myStack);
        //test_Drownning_Stack(myDrowningStack);
        //test_Queue(myQueue);
        //test_Cyclic_Queue(myCyclicQueue);
        //test_Cyclic_Queue(myCyclicQueueWithCount);
        zmien_na_binarne(15);
    }

    public static void test_Stack(MyStack<Integer> myStack) throws FullStackException, EmptyStackException {
        System.out.println("Stack");
        System.out.println("-------------------------------------------------------");
        System.out.println("IsEmpty: " + myStack.isEmpty());
        System.out.println("IsFull: " + myStack.isFull());
        myStack.push(1);
        myStack.push(2);
        System.out.println("Top: " + myStack.top());
        System.out.println("Pop: " + myStack.pop());
        System.out.println("Top: " + myStack.top());
        for (int i = 0; i < 9; i++) {
            myStack.push(i);
        }
        System.out.println("IsFull: " + myStack.isFull());
        myStack.push(1);
        System.out.println("-------------------------------------------------------");
    }

    public static void test_Drownning_Stack(MyDrowningStack<Integer> myDrowningStack) throws EmptyStackException {
        System.out.println("Drowning stack");
        System.out.println("-------------------------------------------------------");
        System.out.println("IsEmpty: " + myDrowningStack.isEmpty());
        System.out.println("IsFull: " + myDrowningStack.isFull());
        myDrowningStack.push(1);
        myDrowningStack.push(2);
        System.out.println("Top: " + myDrowningStack.top());
        System.out.println("Pop: " + myDrowningStack.pop());
        System.out.println("Top: " + myDrowningStack.top());
        for (int i = 0; i < 9; i++) {
            myDrowningStack.push(i);
        }
        System.out.println("IsFull: " + myDrowningStack.isFull());
        myDrowningStack.push(1);
        int x = myDrowningStack.size();
        for (int i = 0; i < x; i++) {
            System.out.print(myDrowningStack.pop() + " ");
        }
        System.out.println();
        System.out.println("-------------------------------------------------------");
    }

    public static void test_Queue(MyQueue<Integer> myQueue) throws FullQueueException, EmptyQueueException {
        System.out.println("Queue");
        System.out.println("-------------------------------------------------------");
        System.out.println("IsEmpty: " + myQueue.isEmpty());
        System.out.println("IsFull: " + myQueue.isFull());
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        System.out.println("First: " + myQueue.first());
        System.out.println("Dequeue: " + myQueue.dequeue());
        System.out.println("First: " + myQueue.first());
        for (int i = 0; i < 9; i++) {
            myQueue.enqueue(i);
        }
        System.out.println("IsFull: " + myQueue.isFull());
        myQueue.enqueue(1);
        System.out.println("-------------------------------------------------------");
    }

    public static void test_Cyclic_Queue(MyCyclicQueue<Integer> myCyclicQueue) throws FullQueueException, EmptyQueueException {
        System.out.println("Cyclic queue");
        System.out.println("-------------------------------------------------------");
        System.out.println("IsEmpty: " + myCyclicQueue.isEmpty());
        System.out.println("IsFull: " + myCyclicQueue.isFull());
        myCyclicQueue.enqueue(1);
        myCyclicQueue.enqueue(2);
        System.out.println("First: " + myCyclicQueue.first());
        System.out.println("Dequeue: " + myCyclicQueue.dequeue());
        System.out.println("First: " + myCyclicQueue.first());
        for (int i = 0; i < 9; i++) {
            myCyclicQueue.enqueue(i);
        }
        System.out.println("IsFull: " + myCyclicQueue.isFull());
        myCyclicQueue.enqueue(1);
        System.out.println("-------------------------------------------------------");
    }

    public static void test_Cyclic_Queue(MyCyclicQueueWithCount<Integer> myCyclicQueueWithCount) throws FullQueueException, EmptyQueueException {
        System.out.println("Cyclic queue");
        System.out.println("-------------------------------------------------------");
        System.out.println("IsEmpty: " + myCyclicQueueWithCount.isEmpty());
        System.out.println("IsFull: " + myCyclicQueueWithCount.isFull());
        myCyclicQueueWithCount.enqueue(1);
        myCyclicQueueWithCount.enqueue(2);
        System.out.println("First: " + myCyclicQueueWithCount.first());
        System.out.println("Dequeue: " + myCyclicQueueWithCount.dequeue());
        System.out.println("First: " + myCyclicQueueWithCount.first());
        for (int i = 0; i < 9; i++) {
            myCyclicQueueWithCount.enqueue(i);
        }
        System.out.println("IsFull: " + myCyclicQueueWithCount.isFull());
        myCyclicQueueWithCount.enqueue(1);
        System.out.println("-------------------------------------------------------");
    }

    public static void zmien_na_binarne(int n) throws FullStackException, EmptyStackException {
        MyStack<Integer> myStack = new MyStack<>(32);
        while (n >= 1){
            myStack.push(n % 2);
            n /= 2;
        }

        while (!myStack.isEmpty()){
            System.out.print(myStack.pop());
        }
    }
}
