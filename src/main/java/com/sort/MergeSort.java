package com.sort;

/**
 * @author liuzhengyang
 */
public class MergeSort implements Sort {
    @Override
    public void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private void sort(int[] array, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = (p + r) / 2;
        sort(array, p, q);
        sort(array, q + 1, r);
        merge(array, p, q, r);
    }

    private void merge(int[] array, int p, int q, int r) {
        int[] temp = new int[r - p + 1];
        int i = p;
        int j = q + 1;
        int indexOfTemp = 0;
        while(i <= q && j <= r) {
            if (array[i] > array[j]) {
                temp[indexOfTemp++] = array[j++];
            } else {
                temp[indexOfTemp++] = array[i++];
            }
        }
        while(i <= q) {
            temp[indexOfTemp++] = array[i++];
        }
        while(j <= r) {
            temp[indexOfTemp++] = array[j++];
        }
        System.arraycopy(temp, 0, array, p, temp.length);
    }

    public static void main(String[] args) {
        new MergeSort().test();
    }

}
