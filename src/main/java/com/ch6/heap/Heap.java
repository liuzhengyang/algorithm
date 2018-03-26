package com.ch6.heap;

/**
 * 树的跟为A[1]
 * 堆数据结构，完全二叉树, 树的每一层都是填满的，最后一层可能除外
 * 可以看做一颗二叉树和一个数组
 * 最大堆、最小堆
 * 最大堆: 除了根节点意外的每个节点i, 有A[parent(i)] >= A[i]
 * @author liuzhengyang
 */
public class Heap<T extends Comparable<T>> {
    private T[] array;
    private int heapSize;

    public Heap(T[] array) {
        this.array = array;
    }

    private int parent(int i) {
        return i/2;
    }

    private int left(int i) {
        return 2 * i;
    }

    private int right(int i) {
        return 2 * i + 1;
    }

    private int heapSize() {
        return heapSize;
    }

    private void minHeapify(int i) {
        int left = left(i);
        int right = right(i);
        int smallest;
        if (left <= heapSize() && array[left].compareTo(array[i]) < 0) {
            smallest = left;
        } else {
            smallest = i;
        }

        if (right <= heapSize() && array[right].compareTo(array[i]) < 0) {
            smallest = right;
        }
        if (smallest != i) {
            T temp = array[i];
            array[i] = array[smallest];
            array[smallest] = temp;
            minHeapify(i);
        }
    }

    private void maxHeapify(T[] array, int i) {
        int left = left(i);
        int right = right(i);
        int largest = 0;
        if (left <= heapSize() && array[left].compareTo(array[i]) > 0) {
            largest = left;
        } else {
            largest = i;
        }
        if (right <= heapSize() && array[right].compareTo(array[largest]) > 0) {
            largest = right;
        }
        if (largest != i) {
            T temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            maxHeapify(array, largest);
        }
    }

    private void buildMaxHeap() {
        heapSize = array.length;
        for (int i = array.length/2; i >= 1; i--) {
            maxHeapify(array, i);
        }
    }

    private static <T extends Comparable<T>> void heapSort(T[] array) {
        Heap<T> heap = new Heap<T>(array);
        heap.buildMaxHeap();
        for (int i = array.length; i >= 2 ; i++) {
            T temp = array[1];
            array[1] = array[i];
            array[i] = temp;
            heap.heapSize -= 1;
            heap.maxHeapify(array, 1);
        }
    }


    private class Node<T> {

    }
}
