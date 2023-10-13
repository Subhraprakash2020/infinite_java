package com.java.Day1;

public class PriorityQueue {
    public static void main(String[] args) {
        // Creating a PriorityQueue
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        // Adding elements to the PriorityQueue
        priorityQueue.add(5);
        priorityQueue.add(3);
        priorityQueue.add(8);
        priorityQueue.add(1);
        priorityQueue.add(2);

        // Printing elements in natural order (ascending)
        System.out.println("PriorityQueue elements in natural order: " + priorityQueue);

        // Removing elements from the PriorityQueue
        while (!priorityQueue.isEmpty()) {
            System.out.println("Removed element: " + priorityQueue.poll());
        }
    }
}
