package by.teachmeskills.lapeiko.homework13;

import java.util.Arrays;

public class IntList {
    private int[] list;

    public IntList() {
        this.list = new int[]{};
    }

    public IntList(int[] list) {
        this.list = list;
    }

    public String toString(int[] list) {
        return Arrays.toString(list);
    }

    public int get(int index) {
        if (index < 0 || index >= list.length) {
            throw new IllegalArgumentException("Error. Verify your code.");
        }
        return list[index];
    }

    public int set(int index, int element) {
        if (index < 0 || index > list.length) {
            throw new IllegalArgumentException("Error. Verify your code.");
        }
        int previousValue = list[index];
        list[index] = element;
        return previousValue;
    }

    public int size() {
        return list.length;
    }

    public void add(int element) {
        int[] newList;
        if (list.length != 0) {
            newList = new int[list.length + 1];
            System.arraycopy(list, 0, newList, 0, list.length);
            newList[list.length] = element;
            list = newList;
        }
    }

    public int remove(int index) {
        if (index < 0 || index >= list.length) {
            throw new IllegalArgumentException("Error. Verify your code.");
        }
        int[] newList = list.clone();
        list = new int[newList.length - 1];
        int element = 0;
        for (int i = 0; i < newList.length; i++) {
            if (index == i) {
                element = newList[i];
            }
            list = newList;
        }
        return element;
    }

    public IntList subList(int startIndexInclusive, int endIndexExclusive) {
        if (startIndexInclusive < 0 ||
                endIndexExclusive > list.length ||
                startIndexInclusive > endIndexExclusive) {
            throw new IllegalArgumentException("Error. Incorrect first or last index.");
        }
        int[] subList = Arrays.copyOfRange(list, startIndexInclusive, endIndexExclusive);
        return new IntList(subList);
    }

    public IntList subList(int startIndexInclusive) {
        if (startIndexInclusive < 0 ||
                startIndexInclusive > list.length) {
            throw new IllegalArgumentException("Error. Inadmissible value of index.");
        }
        return subList(startIndexInclusive, list.length);
    }

    public int lastIndexOf(int element) {
        if (list.length == 0) {
            throw new IllegalArgumentException("Nothing to search.");
        }
        for (int i = list.length - 1; i >= 0; i--) {
            if (list[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public void sort() {
        if (list.length == 0) {
            throw new IllegalArgumentException("Error. Inadmissible size of array");
        }
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (list[j + 1] < list[j]) {
                    int sort = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = sort;
                }
            }
        }
    }
}
