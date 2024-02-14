
package org.example;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class question4 {

    public static void main(String[] args) {

        File inputFile = new File("HTMLtags.txt");

        try {
            Scanner scanner = new Scanner(inputFile);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();

                if (isValidHTML(line)) {
                    System.out.println("The HTML tags are properly nested.");
                } else {
                    System.out.println("The HTML tags are not properly nested.");
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + inputFile.getPath());
        }
    }

    private static boolean isValidHTML(String html) {
        Stack<String> stack = new Stack<>();

        String[] tags = html.split("\\s+"); //splits the input string html into an array of strings, using whitespace as the delimiter.
        // This assumes that each tag is separated by whitespace.

        for (String tag : tags) {
            if (tag.startsWith("</")) {
                String openingTag = stack.pop();
                if (!tag.substring(2, tag.length() - 1).equals(openingTag)) {
                    return false;
                }
            } else if (tag.startsWith("<")) {
                stack.push(tag.substring(1, tag.length() - 1));
            }
        }

        return stack.isEmpty();
    }
}
