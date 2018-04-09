package makana.practice.stacks;

import java.util.Scanner;
import java.util.Stack;


public class SimpleTextEditor {
    private Stack<String> stack = new Stack<>();
    private String string = "";

    public void append(String s) {
        stack.push(string);
        string = string + s;
    }

    public void delete(int k) {
        stack.push(string);
        string = string.substring(0, string.length()-k);
    }

    public String print(int k) {
        return String.valueOf(string.charAt(k-1));
    }

    public void undo() {
        if (!stack.isEmpty()) {
            string = stack.pop();
        }
    }

    public String toString() {
        return string;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        SimpleTextEditor editor = new SimpleTextEditor();
        for (int x = 0; x < q; x++) {
            int t = in.nextInt();
            switch (t) {
                case 1: editor.append(in.next()); break;
                case 2: editor.delete(in.nextInt()); break;
                case 3: System.out.println(editor.print(in.nextInt())); break;
                case 4: editor.undo(); break;
            }
        }
    }
}
