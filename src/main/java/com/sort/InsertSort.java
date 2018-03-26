package com.sort;

/**
 * @author liuzhengyang
 */
public class InsertSort implements Sort {

    @Override
    public void sort(int[] array) {
        int length = array.length;
        if (length <= 1) {
            return;
        }
        for (int i = 0; i < length - 1; i++) {
            int tmp = array[i + 1];
            int j;
            for (j = i + 1; j > 0; j--) {
                if (array[j - 1] > tmp) {
                    array[j] = array[j - 1];
                } else {
                    break;
                }
            }
            array[j] = tmp;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new InsertSort().test();
        }
    }
}
