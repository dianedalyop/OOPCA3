package org.example;
import java.util.*;

class Pair {
    int row;
    int col;

    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class FloodFill {
    public static void main(String[] args) {
        int[][] array = new int[10][10];
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter starting row (0-9): ");
        int startRow = scanner.nextInt();
        System.out.print("Enter starting column (0-9): ");
        int startCol = scanner.nextInt();

        floodFill(array, startRow, startCol);

        // Print the entire 2D array
        for (int[] row : array) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void floodFill(int[][] array, int startRow, int startCol) {
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(startRow, startCol));
        int count = 1;

        while (!stack.isEmpty()) {
            Pair current = stack.pop();
            int row = current.row;
            int col = current.col;

            if (array[row][col] == 0) {
                array[row][col] = count++;

                // Check and push unfilled neighbors onto the stack
                if (row > 0 && array[row - 1][col] == 0) {
                    stack.push(new Pair(row - 1, col));
                }
                if (row < 9 && array[row + 1][col] == 0) {
                    stack.push(new Pair(row + 1, col));
                }
                if (col > 0 && array[row][col - 1] == 0) {
                    stack.push(new Pair(row, col - 1));
                }
                if (col < 9 && array[row][col + 1] == 0) {
                    stack.push(new Pair(row, col + 1));
                }
            }
        }
    }
}
