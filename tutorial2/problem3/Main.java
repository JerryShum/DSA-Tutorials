package tutorial2.problem3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();
        System.out.println("The reversed string is: " + reverseString(str));
        scanner.close();
    }

    public static String reverseString(String str) {
        if (str.length() == 1) {
            System.out.println("String is only 1 character long.");
            return str;
        } else {
            return reverseString(str.substring(1)) + str.charAt(0);
        }
    }

}
