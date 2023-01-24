
package tutorial2.problem2;

public class Main {
      // Recursion Method Function with M and N as parameters
    public static int recursion(int m, int n) {
        // Checks if N is equal to 1
        if (n == 1)
            return m;
        else
            // Return the value of M and N - 1 untill N is equal to 1
            System.out.println(m + recursion(m, n - 1));
        return m + recursion(m, n - 1);
    }
    
      public static void main(String[] args) throws Exception {
        // Calling the recursion method with 3 and 4 as sample values for the parameters
        System.out.println(recursion(3, 4));
    }
}
