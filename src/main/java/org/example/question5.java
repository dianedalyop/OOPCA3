package org.example;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class question5 {
    public static void main(String[] args) {
        Queue<String> takeoffQueue = new LinkedList<>();
        Queue<String> landingQueue = new LinkedList<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("==============================");
            System.out.println("Enter command\n" +
                    "takeoff \n" +
                    "land \n" +
                    "next \n" +
                    "quit ");
            System.out.println("==============================");
            String command = scanner.next();

            if (command.equals("takeoff")) {
                System.out.println("Enter flight Number");
                String flightnumber = scanner.next();
                takeoffQueue.offer(flightnumber);
                System.out.println("Flight " + flightnumber + " queued for takeoff.");
            } else if (command.equals("land")) {
                System.out.println("Enter flight number to land");
                String flightnumber = scanner.next();
                landingQueue.offer(flightnumber);
                System.out.println("Flight " + flightnumber + " queued for landing.");
            } else if (command.equals("next")) {
                if (!landingQueue.isEmpty()) {
                    System.out.println("Landing " + landingQueue.poll() + " completed.");
                } else if (!takeoffQueue.isEmpty()) {
                    System.out.println("Takeoff " + takeoffQueue.poll() + " completed.");
                } else {
                    System.out.println("No flights in the queues.");
                }
            } else if (command.equals("quit")) {
                System.out.println("Exiting");
                break;
            } else {
                System.out.println("Invalid command.");
            }
        }

        scanner.close();
    }
}

