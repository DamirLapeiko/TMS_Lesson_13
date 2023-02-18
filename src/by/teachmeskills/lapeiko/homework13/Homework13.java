package by.teachmeskills.lapeiko.homework13;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class Homework13 {

    public static boolean isReliableForCoding(String line) {
        char[] chars = line.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] > '0' || chars[i] <= '9') {
                if (Character.isWhitespace(chars[i + 1])) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write some numbers through space which you want to be in your list:");
        String line = scanner.nextLine();
        isReliableForCoding(line);
        String strArr[] = line.split(" ");
        int numArr[] = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            numArr[i] = Integer.parseInt(strArr[i]);
        }
        IntList intList = new IntList(numArr);
        System.out.println(
                """
                        Choose task what you want to do with your list:
                        1. ToString (Deduce your list in console)
                        2. Get value by index
                        3. Set new value on given index
                        4. Size of list
                        5. Add element in end of list
                        6. Remove element with given index
                        7. Sublist with given index (inclusively) and given index (exclusively)
                        8. Sublist with given index (inclusively)
                        9. LastIndexOf (search last entry given element in list)
                        10. Sort your list
                        0. Exit"""
        );
        while (true) {
            System.out.println("Your array is: " + intList.toString(numArr));
            System.out.print("Task number: ");
            int taskNumber = scanner.nextInt();

            switch (taskNumber) {
                case 1 -> {
                    System.out.print(intList.toString(numArr));
                }
                case 2 -> {
                    System.out.print("Write index of any element: ");
                    int index = scanner.nextInt();
                    System.out.println("Your number is: " + intList.get(index));
                }
                case 3 -> {
                    System.out.print("Write index of any element: ");
                    int index = scanner.nextInt();
                    System.out.print("Write element: ");
                    int element = scanner.nextInt();
                    System.out.println("Your element " + intList.set(index, element) +
                            " replaced by " + element);
                    System.out.println(intList.toString(numArr));
                }
                case 4 -> {
                    System.out.println("Size of your array is: " + intList.size());
                }
                case 5 -> {
                    System.out.print("Write a number which you want to add: ");
                    int element = scanner.nextInt();
                    System.out.print("Your new array is: ");
                    intList.add(element);
                }
                case 6 -> {
                    System.out.print("Write an index of number which you want to remove: ");
                    int index = scanner.nextInt();
                    System.out.println("Your element " + intList.remove(index) +
                            " with index " + index + " was removed");
                }
                case 7 -> {
                    System.out.print("Write left bound: ");
                    int leftBound = scanner.nextInt();
                    System.out.print("Write right bound: ");
                    int rightBound = scanner.nextInt();
                    System.out.print("Your new array is: ");
                    intList.subList(leftBound, rightBound);
                }
                case 8 -> {
                    System.out.print("Write begin bound: ");
                    int beginBound = scanner.nextInt();
                    System.out.print("Your new array is: ");
                    intList.subList(beginBound);
                }
                case 9 -> {
                    System.out.print("Write element which you want to verify: ");
                    int element = scanner.nextInt();
                    System.out.println("Last entry of this element (index) is: " +
                            intList.lastIndexOf(element));
                }
                case 10 -> {
                    System.out.println("Before sorting: " + intList.toString(numArr));
                    intList.sort();
                    System.out.println("After sorting: " + intList.toString(numArr));
                }
                case 0 -> {
                    return;
                }
                default -> System.err.println("Task doesn't exist");
            }
            System.out.println();
        }
    }
}
