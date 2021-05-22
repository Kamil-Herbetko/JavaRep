package AiSD_Laboratoria.Laboratoria_10;

public class Node {
    private String chars;
    private int weight;
    private Node left;
    private Node right;

    public Node(String chars, int weight) {
        this.chars = chars;
        this.weight = weight;
    }

    public Node(String chars, int weight, Node left, Node right) {
        this.chars = chars;
        this.weight = weight;
        this.left = left;
        this.right = right;
    }

    public String getChars() {
        return chars;
    }

    public void setChars(String chars) {
        this.chars = chars;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
