package AiSD_Laboratoria.Laboratoria_3;

import java.util.Arrays;

public class Nawiasy {

    public static boolean nawiasyZrownowazone(String wyrażenie){
        ArrayStack<Character> stack = new ArrayStack<Character>(wyrażenie.length());

    }

    public static boolean nawiasOtwierajacy(char ch){
        if ((ch == '(') || (ch == '[') || (ch == '{')){
            return true;
        }
        return false;
    }

    public static boolean nawiasZamykajacy(char ch){
        if ((ch == '}') || (ch == ']') || (ch == ')')){
            return true;
        }
        return false;
    }
}
