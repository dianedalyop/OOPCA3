package org.example;
import java.io.File;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class question3 {

    public static void main(String[] args) {
        // Replace "YourJavaFile.java" with the path to your Java source file
        File inputFile = new File("YourJavaFile.java");

        try {
            Scanner scanner = new Scanner(inputFile);
            scanner.useDelimiter("[^A-Za-z0-9_]+");

            Map<String, StringBuilder> identifierIndex = new HashMap<>();
            int lineNumber = 0;

            while (scanner.hasNextLine()) {
                lineNumber++;
                String line = scanner.nextLine();

                Scanner lineScanner = new Scanner(line);
                while (lineScanner.hasNext()) {
                    String identifier = lineScanner.next();
                    if (isIdentifier(identifier)) {
                        // Add or append line number to the identifier's occurrence list
                        identifierIndex.computeIfAbsent(identifier, k -> new StringBuilder())
                                .append("Line ").append(lineNumber).append(": ").append(line).append("\n");
                    }
                }
            }

            // Print the index
            for (Map.Entry<String, StringBuilder> entry : identifierIndex.entrySet()) {
                System.out.println("Identifier: " + entry.getKey());
                System.out.println(entry.getValue());
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + inputFile.getPath());
        }
    }

    private static boolean isIdentifier(String str) {
        // Check if the string consists only of letters, numbers, and underscores
        return str.matches("[A-Za-z0-9_]+");
    }
}
