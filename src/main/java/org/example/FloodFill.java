package org.example;
public class FloodFill {


    static int[][] matrix = new int[5][5];

    static void floodFill(int x, int y, int targetColor, int replacementColor) {
        // Base cases
        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length)
            return;
        if (matrix[x][y] != targetColor)
            return;

        // Replace the target color at (x, y) with replacement color
        matrix[x][y] = replacementColor;

        // Recursive calls to adjacent cells
        floodFill(x + 1, y, targetColor, replacementColor); // Right
        floodFill(x - 1, y, targetColor, replacementColor); // Left
        floodFill(x, y + 1, targetColor, replacementColor); // Down
        floodFill(x, y - 1, targetColor, replacementColor); // Up
    }

    public static void main(String[] args) {
        // Initialize the matrix with some values
        int[][] matrix = {
                {1, 1, 1, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 1, 0, 0, 1},
                {1, 0, 1, 1, 1},
                {0, 0, 0, 0, 1}
        };

        // Perform flood fill starting from position (2, 2) with target color 0 and replacement color 2
        floodFill(2, 2, 0, 2);

        // Print the resulting matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
