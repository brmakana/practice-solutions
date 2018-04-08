package makana.practice.stacks;

import java.util.Scanner;
import java.util.Stack;

public class BalancedString {
    public static void main(String[] argh) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input = sc.next();
            System.out.println(isBalanced(input) ? "true" : "false");
        }

    }

    public static boolean isBalanced(String input) {
        if (input == null || input.isEmpty()) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        char[] charArray = input.toCharArray();
        for (int x = 0; x < charArray.length; x++) {
            if (isStartOfPair(charArray[x])) {
                stack.push(charArray[x]);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character c = stack.pop();
                switch (c) {
                    case '(':
                        if (!(charArray[x] == ')')) return false;
                        break;
                    case '[':
                        if (!(charArray[x] == ']')) return false;
                        break;
                    case '{':
                        if (!(charArray[x] == '}')) return false;
                        break;
                }
            }

        }
        return stack.isEmpty();
    }

    public static boolean isStartOfPair(char character) {
        return (character == '(' ||
                character == '[' ||
                character == '{');
    }
}
