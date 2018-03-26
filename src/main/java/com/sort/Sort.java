package com.sort;

import java.util.Arrays;
import java.util.Random;

public interface Sort {
    /**
     *
     * @param array not null
     * Throw NullPointerException else
     */
    void sort(int[] array);

    default void swap(int[] array, int from, int to) {
        int temp = array[from];
        array[from] = array[to];
        array[to] = temp;
    }

    default void test() {
        for (int k = 0; k < 1000; k++) {
            int length = new Random().nextInt(10);
            int[] array = new int[length];
            for (int i = 0; i < length; i++) {
                array[i] = new Random().nextInt(100);
            }
            System.out.println(Arrays.toString(array));
            int[] copiedArray = Arrays.copyOf(array, array.length);
            sort(array);
            Arrays.sort(copiedArray);
            System.out.println(Arrays.toString(array));
            if (!Arrays.equals(array, copiedArray)) {
                throw new IllegalStateException(" " + Arrays.toString(array) + " " + Arrays.toString(copiedArray));
            }
            System.out.println(Arrays.equals(array, copiedArray));
        }
    }

    static void main(String[] args) {
        System.out.println("Hello");
    }
}
