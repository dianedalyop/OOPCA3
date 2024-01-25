package org.example;

import java.util.Scanner;
import java.util.Stack;

class Pair {
    int row, col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class FloodFill {
    public static void main(String[] args) {
        int[][] matrix = new int[10][10];

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter starting row (0-9): ");
        int startRow = scanner.nextInt();

        System.out.print("Enter starting column (0-9): ");
        int startCol = scanner.nextInt();

        Stack<Pair> stack = new Stack<>();
        int order = 1;

        stack.push(new Pair(startRow, startCol));

        while (!stack.isEmpty()) {
            Pair current = stack.pop();

            if (matrix[current.row][current.col] == 0) {
                matrix[current.row][current.col] = order++;
                fillNeighbors(matrix, current.row, current.col, stack);
            }
        }

        // Print the resulting matrix
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    private static void fillNeighbors(int[][] matrix, int row, int col, Stack<Pair> stack) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if (isValid(matrix, newRow, newCol)) {
                matrix[newRow][newCol] = matrix[row][col] + 1;
                stack.push(new Pair(newRow, newCol));
            }
        }
    }

    private static boolean isValid(int[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length && matrix[row][col] == 0;
    }
}

