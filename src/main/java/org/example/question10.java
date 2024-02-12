package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class question10 {
    public static void main(String[] args) {
        String filename = "cities.txt";
        Map<String, TreeSet<DistanceTo>> connections = new HashMap<>();
        String startingPoint = null;
        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(" ");
                String city1 = line[0];
                String city2 = line[1];
                int distance = Integer.parseInt(line[2]);
                if (startingPoint == null) startingPoint = city1;
                connections.computeIfAbsent(city1, k -> new TreeSet<>()).add(new DistanceTo(city2, distance));
                connections.computeIfAbsent(city2, k -> new TreeSet<>()).add(new DistanceTo(city1, distance));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filename);
            e.printStackTrace();
            return;
        }

        // Dijkstra's Algorithm
        PriorityQueue<DistanceTo> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new DistanceTo(startingPoint, 0));
        Map<String, Integer> shortestKnownDistance = new HashMap<>();

        while (!priorityQueue.isEmpty()) {
            DistanceTo current = priorityQueue.poll();
            String currentCity = current.getTarget();
            int currentDistance = current.getDistance();

            if (!shortestKnownDistance.containsKey(currentCity)) {
                shortestKnownDistance.put(currentCity, currentDistance);
                TreeSet<DistanceTo> neighbors = connections.get(currentCity);
                if (neighbors != null) {
                    for (DistanceTo neighbor : neighbors) {
                        priorityQueue.add(new DistanceTo(neighbor.getTarget(), currentDistance + neighbor.getDistance()));
                    }
                }
            }
        }

        // Printing the shortest distance
        for (Map.Entry<String, Integer> entry : shortestKnownDistance.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    static class DistanceTo implements Comparable<DistanceTo> {
        private String target;
        private int distance;

        public DistanceTo(String city, int dist) {
            target = city;
            distance = dist;
        }

        public String getTarget() {
            return target;
        }

        public int getDistance() {
            return distance;
        }

        @Override
        public int compareTo(DistanceTo other) {
            return distance - other.distance;
        }
    }
}
