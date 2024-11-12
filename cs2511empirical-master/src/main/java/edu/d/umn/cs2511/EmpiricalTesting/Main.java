package edu.d.umn.cs2511.EmpiricalTesting;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    private static ArrayList<String> readFile(String filePath) throws IOException {
        Scanner fileScanner = new Scanner(new FileReader(filePath));
        String s;
        ArrayList<String> strs = new ArrayList<>();
        while (fileScanner.hasNext()) {
            s = fileScanner.next();
            strs.add(s);
        }
        return strs;
    }

    public static void main(String[] args) {
        String fileName = "linuxwords.txt";

        try {
            ArrayList<String> aLongListOfStrings = readFile(fileName);
            SortedArrayOfStrings sortedArray = new SortedArrayOfStrings();
            SortedLinkedListOfStrings sortedLinkedList = new SortedLinkedListOfStrings();
            sortedArray.addAll(aLongListOfStrings);
            sortedLinkedList.addAll(aLongListOfStrings);
            ArrayList<String> unsortedArray = new ArrayList<>();
            LinkedList<String> unsortedLinkedList = new LinkedList<>();
            unsortedArray.addAll(aLongListOfStrings);
            unsortedLinkedList.addAll(aLongListOfStrings);
            Scanner input = new Scanner(System.in);
            String s;
            do {
                long startTime;
                long endTime;
                System.out.print("String to insert: ");
                s = input.next();
                System.out.println("Getting Index Of: " + s);
                // Sorted Array Time
                startTime = System.nanoTime();
                // All Unit Tests
                 sortedArray.add(s);
                // sortedArray.remove(0);
                //  sortedArray.remove(sortedArray.size() - 1);
                // sortedArray.remove(s);
                // sortedArray.indexOf(s);
                endTime = System.nanoTime();

                System.out.println("Sorted Array add time: " + (endTime - startTime) + " nanoseconds");
                // Unsorted Array Time
                startTime = System.nanoTime();
                // All Unit Tests
                unsortedArray.add(s);
                // unsortedArray.remove(0);
                //  unsortedArray.remove(unsortedArray.size() - 1);
                // unsortedArray.remove(s);
                // unsortedArray.indexOf(s);
                endTime = System.nanoTime();
                System.out.println("Unsorted Array add time: " + (endTime - startTime) + " nanoseconds");
                // Sorted LinkedList Time
                startTime = System.nanoTime();
                // All Unit Tests
                sortedLinkedList.add(s);
                // sortedLinkedList.remove(0);
                // sortedLinkedList.remove(sortedLinkedList.size() - 1);
                // sortedLinkedList.remove(s);
                // sortedLinkedList.indexOf(s);
                endTime = System.nanoTime();
                System.out.println("Sorted LinkedList add time: " + (endTime - startTime) + " nanoseconds");
                // Unsorted LinkedList Time
                startTime = System.nanoTime();
                // All Unit Tests
                unsortedLinkedList.add(s);
                // unsortedLinkedList.remove(0);
                // unsortedLinkedList.remove(unsortedLinkedList.size() - 1);
                // unsortedLinkedList.remove(s);
                // unsortedLinkedList.indexOf(s);
                endTime = System.nanoTime();
                System.out.println("Unsorted LinkedList add time: " + (endTime - startTime) + " nanoseconds");

                System.out.println(sortedArray.indexOf("hello"));
                boolean sameArray = true;
                if (sortedArray.size() != unsortedArray.size()) {
                    System.out.println("The arrays are no longer the same size " + sortedArray.size() + " " + unsortedArray.size());
                }
                else {
                    for (int i = 0; i < sortedArray.size(); i++) {
                        if (!unsortedArray.contains(sortedArray.get(i))) {
                            System.err.println("Unsorted does not have " + sortedArray.get(i));
                            sameArray = false;
                        }
                    }
                }
            } while (!s.equalsIgnoreCase("quit"));
        } catch (IOException e) {
            System.err.println("Problem opening " + fileName);
        }
    }
}