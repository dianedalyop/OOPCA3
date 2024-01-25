package org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class question4 {
    public static boolean isProperlyNested(String[] tags) {
        Stack<String> stack = new Stack<>();

        for (String tag : tags) {
            if (tag.startsWith("</")) {
                // Closing tag
                String openingTag = tag.substring(2, tag.length() - 1);
                if (stack.isEmpty() || !stack.pop().equals(openingTag)) {
                    return false; // Mismatched closing tag
                }
            } else if (tag.startsWith("<")) {
                // Opening tag
                stack.push(tag.substring(1, tag.length() - 1));
            }
        }

        return stack.isEmpty(); // All opening tags should be closed
    }

}
