package org.example;
import java.io.File;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class question3 {

    public static void main(String[] args) {

        File inputFile = new File("javafile.java");

        try {
            Scanner scanner = new Scanner(inputFile); // reading file input
            scanner.useDelimiter("[^A-Za-z0-9_]+"); //specify that the delimiter should be any character that is not an alphanumeric character or an underscore.

            Map<String, StringBuilder> identifierIndex = new HashMap<>();// storing the identifiers and their occurences
            int lineNumber = 0; // keeping the track of the line number


            while (scanner.hasNextLine()) {
                lineNumber++;
                String line = scanner.nextLine();//while loop to iterate over each line of the input file as long as there is another line to read.

                Scanner lineScanner = new Scanner(line);// scanning current line
                while (lineScanner.hasNext()) { // another while loop to iterate over each token (word) in the current line.
                    String identifier = lineScanner.next(); // next token from the current line and store it in a string variable identifier.
                    if (isIdentifier(identifier)) {
                        //  adding a line number to the identifier
                        identifierIndex.computeIfAbsent(identifier, k -> new StringBuilder())
                                .append("Line ").append(lineNumber).append(": ").append(line).append("\n");
                    }
                }
            }

            // Print the index
            for (Map.Entry<String, StringBuilder> entry : identifierIndex.entrySet()) {//iterating over each entry (identifier and its occurrences) in the identifierIndex map.
                System.out.println("Identifier: " + entry.getKey()); // print the identifier and its occurrences (lines where it appears) to the console.
                System.out.println(entry.getValue());
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + inputFile.getPath());
        }
    }

    private static boolean isIdentifier(String str) {

        return str.matches("[A-Za-z0-9_]+");//true if the string consists of only alphanumeric characters and underscores
    }
}
