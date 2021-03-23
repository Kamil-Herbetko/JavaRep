package AiSD_Laboratoria.Laboratoria_3;

import AiSD_Ćwiczenia.Ćwiczenia_2_2.Exceptions.EmptyStackException;
import AiSD_Ćwiczenia.Ćwiczenia_2_2.Exceptions.FullStackException;

import java.util.Scanner;

public class Nawiasy {
    public static void main(String[] args) throws FullStackException, EmptyStackException {
        // Menu
        boolean run = true;
        Scanner scanner = new Scanner(System.in);
        while (run){
            System.out.println("Wybierz opcję");
            System.out.println("1 - sprawdzenie czy wyrażenie ma zrównoważone nawiasy");
            System.out.println("2 - sprawdzenie czy wyrażenie jest palindromem");
            System.out.println("3 - wyjście");

            switch (scanner.nextLine().strip()){
                case "1" ->{
                    System.out.println("Podaj wyrażenie:");
                    String wyrazenie = scanner.nextLine();

                    if (nawiasyZrownowazone(wyrazenie)){
                        System.out.println("Nawiasy są poprawnie zrównoważone");
                    }
                    else {
                        System.out.println("Nawiasy nie są poprawnie zrównoważone");
                    }

                    System.out.println();
                }
                case "2" ->{
                    System.out.println("Podaj wyrażenie:");
                    String wyrazenie = scanner.nextLine();

                    if (czyJestPalindromemZOdwroceniemStosu(wyrazenie)){
                        System.out.println("Wyrażenie jest palindromem");
                    }
                    else {
                        System.out.println("Wyrażenie nie jest palindromem");
                    }

                    System.out.println();
                }
                case "3" ->{
                    run = false;
                    scanner.close();
                }
                default -> System.out.println();
            }

        }
    }

    public static boolean nawiasyZrownowazone(String wyrażenie) throws FullStackException, EmptyStackException {
        ArrayStack<Character> stack = new ArrayStack<Character>(wyrażenie.length());

        for (int i = 0; i < wyrażenie.length(); i++) {
            char ch = wyrażenie.charAt(i);
            if (nawiasOtwierajacy(ch)){
                stack.push(ch);
            }
            else if (nawiasZamykajacy(ch)){
                if (stack.isEmpty()){
                    return false;
                }
                else{
                    if (((stack.top() == '(') && (ch == ')')) || ((stack.top() == '{') && (ch == '}')) || ((stack.top() == '[') && (ch == ']'))){
                        stack.pop();
                    }
                    else {
                        return false;
                    }
                }
            }
        }

        if (!stack.isEmpty()){
            return false;
        }

        return true;
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

    public static boolean czyJestPalindromem(String slowo) throws FullStackException, EmptyStackException {
        ArrayStack<Character> stack = new ArrayStack<>(slowo.length());
        String odwroconeSlowo = "";

        for (char ch : slowo.toCharArray()){
            stack.push(ch);
        }

        while (!stack.isEmpty()){
            odwroconeSlowo += stack.pop();
        }

        if (odwroconeSlowo.equals(slowo)){
            return true;
        }

        return false;
    }

    public static boolean czyJestPalindromemZOdwroceniemStosu(String slowo) throws FullStackException {
        ArrayStack<Character> stack = new ArrayStack<>(slowo.length());
        ArrayStack<Character> copystack = new ArrayStack<>(slowo.length());

        for (char ch : slowo.toCharArray()){
            stack.push(ch);
            copystack.push(ch);
        }
        copystack.reverseStack();

        if (copystack.equals(stack)){
            return true;
        }

        return false;

    }
}
