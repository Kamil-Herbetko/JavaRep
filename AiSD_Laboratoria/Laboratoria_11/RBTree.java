package AiSD_Laboratoria.Laboratoria_11;

import java.util.ArrayList;
import java.util.Comparator;


public class RBTree<T> {
    private class Node{
        private T key;
        private ArrayList<Integer> value;
        private Node parent;
        private Node left;

        public ArrayList<Integer> getWiersze() {
            return wiersze;
        }

        @Override
        public String toString() {
            return key + " ";
        }

        private Node right;
        private int color;//1-red 0-black
        private ArrayList<Integer> wiersze;

        public Node(T key) {
            this.key=key;
            wiersze = new ArrayList<>();
            this.color=1;
        }
        public Node() {
            this.left=null;
            this.right=null;
            this.color=0;
        }
    }
    private Comparator<T> comparator;
    private Node root;
    private Node NULL;

    public RBTree(Comparator<T> comparator) {
        this.comparator = comparator;
        this.NULL=new Node();
        this.root=NULL;
    }



    private void rbTransplant(Node u, Node v){
        if (u.parent == null) {
            root = v;
        } else if (u == u.parent.left){
            u.parent.left = v;
        } else {
            u.parent.right = v;
        }
        v.parent = u.parent;
    }

    public T remove(T key){
        Node del=searchRB(key);
        if(del==NULL){
            return null;
        }
        else{
            Node y,x;
            y = del;
            int yOriginalColor = y.color;
            if (del.left == NULL) {
                x = del.right;
                rbTransplant(del, del.right);
            } else if (del.right == NULL) {
                x = del.left;
                rbTransplant(del, del.left);
            } else {
                y = TreeMinimum(del.right);
                yOriginalColor = y.color;
                x = y.right;
                if (y.parent == del) {
                    x.parent = y;
                } else {
                    rbTransplant(y, y.right);
                    y.right = del.right;
                    y.right.parent = y;
                }

                rbTransplant(del, y);
                y.left = del.left;
                y.left.parent = y;
                y.color = del.color;
            }
            if (yOriginalColor == 0){
                RBdeleteFixup(x);
            }
            return y.key;
        }
    }
    private void RBdeleteFixup(Node x){
        while(x!=root && x.color==0){
            if(x==x.parent.left) {
                Node s= x.parent.right;
                if(s.color==1) {
                    s.color = 0;
                    x.parent.color = 1;
                    leftRotate(x.parent);
                    s = x.parent.right;
                }
                if(s.left.color==0 && s.right.color==0){
                    s.color=1;
                    x=x.parent;
                }
                else {
                    if (s.right.color == 0) {
                        s.left.color = 0;
                        s.color = 1;
                        rightRotate(s);
                        s = x.parent.right;
                    }
                    s.color = x.parent.color;
                    x.parent.color = 0;
                    s.right.color = 0;
                    leftRotate(x.parent);
                    x = root;
                }
            }
            else{
                Node s= x.parent.left;
                if(s.color==1) {
                    s.color = 0;
                    x.parent.color = 1;
                    rightRotate(x.parent);
                    s = x.parent.left;
                }
                if(s.left.color==0 && s.right.color==0){
                    s.color=1;
                    x=x.parent;
                }
                else {
                    if (s.left.color == 0) {
                        s.right.color = 0;
                        s.color = 1;
                        leftRotate(s);
                        s = x.parent.left;
                    }
                    s.color = x.parent.color;
                    x.parent.color = 0;
                    s.left.color = 0;
                    rightRotate(x.parent);
                    x = root;
                }
            }
        }
        x.color=0;
    }

    public void search2(T key, int x){

        Node node =searchRB(key);

        if(node.getWiersze().size() > 0)
        {
            if(x != node.getWiersze().get(node.getWiersze().size() - 1));
                node.getWiersze().add(x);
        }
        else
        {
            node.getWiersze().add(x);
        }
    }

    public void inorder()
    {
        dfs(root);

    }

    private void dfs(Node node)
    {
        if( node != NULL )
        {
            dfs(node.left);
            System.out.println(node.key + " " + node.wiersze.toString());
            dfs(node.right);
        }

    }

    public void wszerz() throws EmptyQueueException, FullQueueException {
        wszerzOrder(root);

    }





    private void wszerzOrder(Node node) throws FullQueueException, EmptyQueueException {
        IQueue<Node> kolejka = new IQueue<>();
        kolejka.enqueue(root);
        while (!kolejka.isEmpty()) {
            if (kolejka.first().left != NULL)
                kolejka.enqueue(kolejka.first().left);

            if (kolejka.first().right != NULL)
                kolejka.enqueue(kolejka.first().right);

            System.out.print(kolejka.dequeue().toString() + " ");

        }
    }



    private Node searchRB(T key){
        Node node=root;
        int cmp=0;
        if(root==null)
            return node;
        while(node!=NULL &&  (cmp=comparator.compare(key, node.key))!=0)
            node=cmp<0? node.left:node.right;
        return node;
    }
    private Node TreeMinimum(Node node){
        while (node.left!=NULL){
            node=node.left;
        }
        return node;
    }
    public void insert(T key){
        Node node=new Node(key);
        node.parent=null;
        node.left=NULL;
        node.right=NULL;

        Node y = null;
        Node x = this.root;

        while (x != NULL) {
            y = x;
            if (comparator.compare(node.key, x.key)<0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        node.parent = y;
        if (y == null) {
            root = node;
        } else if (comparator.compare(node.key, y.key)<0) {
            y.left = node;
        } else {
            y.right = node;
        }

        if (node.parent == null){
            node.color = 0;
            return;
        }

        if (node.parent.parent == null) {
            return;
        }

        RBinsert(node);
    }

    private void RBinsert(Node x) {
        Node y;
        while (x.parent.color == 1) {
            if (x.parent == x.parent.parent.right) {
                y = x.parent.parent.left;
                if (y.color == 1) {
                    y.color = 0;
                    x.parent.color = 0;
                    x.parent.parent.color = 1;
                    x = x.parent.parent;
                } else {
                    if (x == x.parent.left) {
                        x = x.parent;
                        rightRotate(x);
                    }
                    x.parent.color = 0;
                    x.parent.parent.color = 1;
                    leftRotate(x.parent.parent);
                }
            }
            else{
                y = x.parent.parent.right;
                if (y.color == 1) {
                    y.color = 0;
                    x.parent.color = 0;
                    x.parent.parent.color = 1;
                    x = x.parent.parent;
                } else {
                    if (x == x.parent.right) {
                        x = x.parent;
                        leftRotate(x);
                    }
                    x.parent.color = 0;
                    x.parent.parent.color = 1;
                    rightRotate(x.parent.parent);
                }
            }
            if(x==root)
                break;

        }
        root.color=0;
    }
    private void leftRotate(Node x){
        Node y=x.right;
        x.right=y.left;
        if(y.left!=NULL)
            y.left.parent=x;
        y.parent=x.parent;
        if(x.parent==null)
            this.root=y;
        else if(x==x.parent.left)
            x.parent.left=y;
        else
            x.parent.right=y;
        y.left=x;
        x.parent=y;
    }
    private void rightRotate(Node x){
        Node y=x.left;
        x.left=y.right;
        if(y.right!=NULL)
            y.right.parent=x;
        y.parent=x.parent;
        if(x.parent==null)
            this.root=y;
        else if(x==x.parent.right)
            x.parent.right=y;
        else
            x.parent.left=y;
        y.right=x;
        x.parent=y;
    }


}
