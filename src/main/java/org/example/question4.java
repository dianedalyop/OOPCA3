
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

        // Split the string by spaces to extract individual tags
        String[] tags = html.split("\\s+");

        for (String tag : tags) {
            if (tag.startsWith("</")) {
                // If it's a closing tag, check if it matches the top of the stack
                String openingTag = stack.pop();
                if (!tag.substring(2, tag.length() - 1).equals(openingTag)) {
                    return false;
                }
            } else if (tag.startsWith("<")) {
                // If it's an opening tag, push it onto the stack
                stack.push(tag.substring(1, tag.length() - 1));
            }
        }

        // If the stack is empty, all tags were properly matched
        return stack.isEmpty();
    }
}
