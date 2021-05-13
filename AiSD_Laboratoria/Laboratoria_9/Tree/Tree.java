package AiSD_Laboratoria.Laboratoria_9.Tree;

import AiSD_Ćwiczenia.Ćwiczenia_2_2.Exceptions.EmptyQueueException;
import AiSD_Ćwiczenia.Ćwiczenia_2_2.Exceptions.FullQueueException;
import AiSD_Ćwiczenia.Ćwiczenia_2_2.MyQueues.MyQueue;

import java.util.Stack;

public class Tree {
    class Node{
        String value;
        Node left;
        Node right;
        Node(String str){
            value = str;
            left = null;
            right = null;
        }
        Node(String obj, Node rightNode, Node leftNode){
            value = obj;
            left = leftNode;
            right = rightNode;
        }
    }

    private Node _root;
    public Tree(){
        _root = null;
    }

    public void createTree(String[] list){
        Stack<Node> stack = new Stack<>();
        for (String s : list) {
            if ("+-*/%".indexOf(s) != -1) {
                Node node1 = new Node(s, stack.pop(), stack.pop());
                stack.push(node1);
            } else {
                stack.push(new Node(s));
            }
        }
        _root = stack.pop();
    }

    public void calculate(){
        System.out.println("Wartość wyrażenia:");
        System.out.println(calculate(_root));
    }

    private int calculate(Node node){
        if (_root == null){
            return 0;
        }

        if ((node.left == null) && (node.right == null)){
            return Integer.parseInt(node.value);
        }

        switch (node.value){
            case "+" -> {
                return calculate(node.left) + calculate(node.right);
            }
            case "-" -> {
                return calculate(node.left) - calculate(node.right);
            }
            case "*" -> {
                return calculate(node.left) * calculate(node.right);
            }
            case "/" -> {
                return calculate(node.left) / calculate(node.right);
            }
            case "%" -> {
                return calculate(node.left) % calculate(node.right);
            }
        }

        throw new IllegalArgumentException("Złe wyrażenie");
    }

    public void wyswietlInfiks(){
        System.out.println("Wyrażenie w postaci infiksowej:");
        System.out.println(wyswietlInfiks("", _root) + " = " + calculate(_root));
    }

    public void wyswietlPostfiks(){
        System.out.println("Wyrażenie w postaci postfiksowej:");
        System.out.println(wyswietlPostfiks("", _root) + " = " + calculate(_root));
    }

    public void wyswietlLiscie(){
        System.out.println("Liczba liści: " + leafCount(_root));
    }

    public void wyswietlWezly(){
        System.out.println("Liczba węzłów: " + nodeCount(_root));
    }

    public void wyswietlWysokosc(){
        System.out.println("Wysokość: " + height(_root));
    }

    private int height(Node node){
        if ((node.left == null) && (node.right == null)){
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    private int nodeCount(Node node){
        if ((node.left == null) && (node.right == null)){
            return 0;
        }
        return 1 + nodeCount(node.left) + nodeCount(node.right);
    }

    private int leafCount(Node node){
        if ((node.left == null) && (node.right == null)){
            return 1;
        }
        return leafCount(node.left) + leafCount(node.right);
    }

    private String wyswietlPostfiks(String string, Node node){
        if (node != null){
            string =  string + wyswietlPostfiks(string, node.left)  + " " + wyswietlPostfiks(string, node.right) + " " + node.value;
        }
        return string;
    }

    public void przechodzenieWszerz() throws FullQueueException, EmptyQueueException {
        MyQueue<Node> kolejka = new MyQueue<>();
        kolejka.enqueue(_root);
        while (!kolejka.isEmpty()){
            Node node = kolejka.dequeue();
            System.out.print(node.value + " ");
            if (node.left != null){
                kolejka.enqueue(node.left);
            }
            if (node.right != null){
                kolejka.enqueue(node.right);
            }
        }
        System.out.println();
    }

    private String wyswietlInfiks(String string, Node node){
        if (node != null){
            string =  string + "(" + wyswietlInfiks(string, node.left) + node.value + wyswietlInfiks(string, node.right) + ")";
        }
        return string;
    }

}
