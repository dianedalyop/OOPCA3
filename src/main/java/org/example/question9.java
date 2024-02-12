package org.example;

import java.util.Scanner;
import java.util.Stack;

public class question9 {
    private int[][] maze;
    private int rows;
    private int cols;
    private boolean[][] visited;
    private Stack<int[]> path;
    private StringBuilder directions;

    public question9(int[][] maze) {
        this.maze = maze;
        this.rows = maze.length;
        this.cols = maze[0].length;
        this.visited = new boolean[rows][cols];
        this.path = new Stack<>();
        this.directions = new StringBuilder();
    }

    private boolean isValidMove(int row, int col) {
        return 0 <= row && row < rows && 0 <= col && col < cols && !visited[row][col] && maze[row][col] == 0;
    }

    public boolean findPath(int startRow, int startCol, int endRow, int endCol) {
        path.push(new int[]{startRow, startCol});

        while (!path.isEmpty()) {
            int[] currentPosition = path.pop();
            int currentRow = currentPosition[0];
            int currentCol = currentPosition[1];

            if (currentRow == endRow && currentCol == endCol) {
                return true;
            }

            visited[currentRow][currentCol] = true;

            // Try moving in all possible directions
            int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            String[] directionNames = {"right", "down", "left", "up"};
            for (int i = 0; i < directions.length; i++) {
                int nextRow = currentRow + directions[i][0];
                int nextCol = currentCol + directions[i][1];
                if (isValidMove(nextRow, nextCol)) {
                    path.push(new int[]{nextRow, nextCol});
                    this.directions.append(directionNames[i]).append(", ");
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] maze = {
                {0, 1, 0, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0}
        };

        question9 solver = new question9(maze);

        System.out.print("Enter starting row: ");
        int startRow = scanner.nextInt();
        System.out.print("Enter starting column: ");
        int startCol = scanner.nextInt();
        int endRow = 4;
        int endCol = 4;

        if (solver.findPath(startRow, startCol, endRow, endCol)) {
            System.out.println("Path found! Directions taken: " + solver.getDirections());
        } else {
            System.out.println("No path found.");
        }
    }

    public String getDirections() {
        return directions.toString();
    }
}
