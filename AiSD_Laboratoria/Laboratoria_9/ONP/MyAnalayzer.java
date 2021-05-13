package AiSD_Laboratoria.Laboratoria_9.ONP;

import AiSD_Laboratoria.Laboratoria_3.ArrayStack;
import AiSD_Laboratoria.Laboratoria_3.IStack;
import AiSD_Ćwiczenia.Ćwiczenia_2_2.Exceptions.EmptyQueueException;
import AiSD_Ćwiczenia.Ćwiczenia_2_2.Exceptions.FullQueueException;
import AiSD_Ćwiczenia.Ćwiczenia_2_2.Exceptions.FullStackException;
import AiSD_Ćwiczenia.Ćwiczenia_2_2.Interfaces.IQueue;


import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.EmptyStackException;

public class MyAnalayzer {
    private static class Operator{
        final char _ch;
        public Operator(char ch) {
            _ch=ch;
        }
        int getPriority(){
            if(_ch=='*' || _ch=='/' || _ch=='%') return 2;
            if(_ch=='+' || _ch=='-') return 1;
            return 0;
        }
        @Override
        public String toString() {
            return ""+_ch;
        }
    }
    private static class LeftBracket{
        @Override
        public String toString() {
            return "(";
        }
    }
    // na razie mamy tylko implementacje stosu i kolejki
    // o ograniczonej pojemności
    public static final int MAX_NUMBER_OF_TOKENS=1000;

    public static IQueue<Object> analize(String inputStr){
        StreamTokenizer st= new StreamTokenizer(new StringReader(inputStr));
        st.ordinaryChar('/'); // traktuj ‘/’ jako zwykły znak
        st.ordinaryChar('-'); // traktuj ‘-’ jako zwykły znak
        st.ordinaryChar('%'); // traktuj ‘%’ jako zwykły znak
        IQueue<Object> queue=new ArrayQueue<Object>(MAX_NUMBER_OF_TOKENS);
        IStack<Object> stack=new ArrayStack<Object>(MAX_NUMBER_OF_TOKENS);
        try {
            while (st.nextToken() != st.TT_EOF){
                if (st.ttype == st.TT_NUMBER){queue.enqueue( (int) st.nval);}
                else if(st.ttype=='(') stack.push(new LeftBracket());
                else if(st.ttype==')'){
                    Object elem;
                    do{
                        elem=stack.pop();
                        if(!(elem instanceof LeftBracket)) queue.enqueue(elem);
                    }while(!(elem instanceof LeftBracket));}
                else // Operator
                {
                    Operator oper1=new Operator((char)st.ttype);
                    int priorityOper1=oper1.getPriority();
                    Object topElem;
                    while(!stack.isEmpty() &&
                            ((topElem=stack.top()) instanceof Operator) &&
                            ((Operator) topElem).getPriority()>=priorityOper1){
                        queue.enqueue(stack.pop());}
                    stack.push(oper1);}}
            // na koniec przerzucenie elementów ze stosu na koniec kolejki
            while(!stack.isEmpty()){queue.enqueue(stack.pop());}
        } catch (IOException | FullQueueException | EmptyStackException | FullStackException | AiSD_Ćwiczenia.Ćwiczenia_2_2.Exceptions.EmptyStackException e){
            e.printStackTrace();}
        return queue;}

    // przydałby się iterator w kolejce
    static public String toRPNString(IQueue<Object> queue){
        StringBuffer buffer = new StringBuffer();
        IQueue<Object> copyQueue=new ArrayQueue<Object>();
        try {
            while(!queue.isEmpty()){
                Object elem;
                elem = queue.dequeue();
                buffer.append(elem).append(", ");
                copyQueue.enqueue(elem);
            }
            while(!copyQueue.isEmpty())
                queue.enqueue(copyQueue.dequeue());
        } catch (EmptyQueueException | FullQueueException e) {
            e.printStackTrace();
        }
        buffer.setLength(buffer.length() - 2);
        return buffer.toString();
    }

    public static void main(String[] args) {
        String inputStr = "(2+4)*(3.7-9/3)";
        System.out.println("for: " + inputStr);
        IQueue<Object> queue = analize(inputStr);
        String stringi = toRPNString(queue);
        System.out.println(stringi);
        String[] lista = stringi.split(", ");
    }

}
