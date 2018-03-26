package com.sort;

/**
 * @author liuzhengyang
 */
public class QuickSort implements Sort {
    @Override
    public void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private void sort(int[] array, int p, int r) {
        if (p < r) {
            int q = partition(array, p, r);
            sort(array, p, q - 1);
            sort(array, q + 1, r);
        }
    }

    /**
     * 两个index同时向右移动，如果遇到大于pivot的，则i++,这样最终形成了以pivot为界的两边，最终再替换i和pivot所在位置
     * @param array
     * @param p
     * @param r
     * @return
     */
    private int partition(int[] array, int p, int r) {
        int x = array[r];
        int i = p;
        for (int j = p; j < r; j++) {
            if (array[j] <= x) {
                swap(array, i++, j);
            }
        }
        swap(array, i, r);
        return i;
    }

    public static void main(String[] args) {
        new QuickSort().test();
    }
}
