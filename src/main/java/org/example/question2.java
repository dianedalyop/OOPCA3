package org.example;
import java.util.*;

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class question2
{
    public static void floodFill(int[][] matrix, int startRow, int startCol) {
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(startRow, startCol));
        int count = 1;

        while (!stack.isEmpty()) {
            Pair currentPair = stack.pop();
            int x = currentPair.x;
            int y = currentPair.y;

            if (matrix[x][y] == 0) {
                matrix[x][y] = count;
                count++;

                // Check and push unfilled neighbors
                if (x > 0 && matrix[x - 1][y] == 0) {
                    stack.push(new Pair(x - 1, y)); // North
                }
                if (y < matrix[0].length - 1 && matrix[x][y + 1] == 0) {
                    stack.push(new Pair(x, y+ 1)); // East
                }
                if (x < matrix.length - 1 && matrix[x + 1][y] == 0) {
                    stack.push(new Pair(x + 1, y)); // South
                }
                if (y > 0 && matrix[x][y - 1] == 0) {
                    stack.push(new Pair(x, y - 1)); // West
                }
            }
        }

        // 2D array
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = new int[10][10];

        System.out.print("Starting row (0-9):");
        int startRow = scanner.nextInt();
        System.out.print("Starting column (0-9):");
        int startCol = scanner.nextInt();

        floodFill(matrix, startRow, startCol);
    }
}
