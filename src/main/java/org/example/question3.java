package org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class question3 {

    public static void main(String[] args) {

        String filePath = "FloodFill.java";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            Scanner scanner = new Scanner(reader);

            scanner.useDelimiter("[^A-Za-z0-9_]+");


            Map<String, StringBuilder> identifierIndex = new HashMap<>();

            int lineNumber = 0;

            while (scanner.hasNextLine()) {
                lineNumber++;
                String line = scanner.nextLine();

                // Scan each line for identifiers
                while (scanner.hasNext()) {
                    String identifier = scanner.next();

                    // Update the index map
                    if (!identifier.isEmpty()) {
                        identifierIndex
                                .computeIfAbsent(identifier, k -> new StringBuilder())
                                .append("Line ").append(lineNumber).append(": ").append(line).append("\n");
                    }
                }

                // Reset scanner for the next line
                scanner = new Scanner(line);
                scanner.useDelimiter("[^A-Za-z0-9_]+");
            }

            // Print the index
            for (Map.Entry<String, StringBuilder> entry : identifierIndex.entrySet()) {
                System.out.println("Identifier: " + entry.getKey());
                System.out.println(entry.getValue());
                System.out.println("-------------");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
