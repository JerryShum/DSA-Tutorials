package tutorial3.problem1;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        /*
         * Assume your keyboard does not have a backspace key; thus, if you make a data
         * entry error
         * you
         * must use the # character to correct your mistake as follows: Each # erases
         * the previous character
         * entered, but consecutive # characters do not cancel out; instead they are
         * applied in sequence and so
         * erase several characters. For instance if the input line is:
         * abc defgh#2klmn opqr##wxyz
         * the corrected output would be:s
         * abc defg2klmn opwxyz
         * Write a function to perform this correction using stack.
         */

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        // put input into Stack
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        // abc defgh#2klmn opqr##wxyz

        // z
        Stack<Character> stack2 = new Stack<Character>();
        while (!stack.isEmpty()) {
            char c = stack.pop();
            int i = 0;
            while (c == '#') {
                c = stack.pop();
                i++;
            }
            while (i > 0) {
                stack.pop();
                i--;
            }
            stack2.push(c);
        }

        // print out the corrected output
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop());
        }
        System.out.println();
    }

}
