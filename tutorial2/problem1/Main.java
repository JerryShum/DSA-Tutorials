
package tutorial2.problem1;

// 1. Describe a way to use recursion to compute the sum of all the elements in an nxn (two-dimensional) array of integers.

public class Main {

    public static void main(String[] args) {
        // sum of this matrix is 13
        int[][] matrix = {
                { 0, 0, 1 }, // [0, 0, 1]
                { 1, 2, 3 }, // [1, 2, 3]
                { 4, 1, 1 }  // [4, 1, 1]
        };
        int s = sum(matrix, 0, 0, matrix.length, matrix[0].length);
        System.out.println(s); // 13
    }
    
    // sum recursive
    public static int sum(int[][] matrix, int row, int col, final int ROW_SIZE, final int COL_SIZE) {
        // if at the end of the matrix with no recursive call
        if (row == ROW_SIZE - 1 && col == COL_SIZE - 1) {
            return matrix[ROW_SIZE - 1][COL_SIZE - 1];
        }

        // if we're at the last column, increment row and start at col 0
        if (col == COL_SIZE - 1) {
            return matrix[row][col] + sum(matrix, row + 1, 0, ROW_SIZE, COL_SIZE);
        }

        // base case, we're still accumulating the sum of a row
        return matrix[row][col] + sum(matrix, row, col + 1, ROW_SIZE, COL_SIZE);
    }
}