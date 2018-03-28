package com.ch6.heap;

import java.util.Arrays;

/**
 * Not ThreadSafe
 * child of index i is 2 * i + 1, 2 * i + 2
 * @author liuzhengyang
 */
@SuppressWarnings("unchecked")
public class PriorityQueue<E extends Comparable<E>> {
    public static final Object[] DATA = new Object[0];
    private Object[] data;
    private int size;
    private int capacity;

    public PriorityQueue() {
        this.data = DATA;
        this.capacity = 0;
        this.size = 0;
    }

    public void add(E element) {
        int i = size;
        if (++size > capacity) {
            resize();
        }
        data[i] = element;
        siftUp(element, i);
    }

    private void resize() {
        if (capacity == 0) {
            capacity = 1;
            data = new Object[1];
        }
        int newCapacity = capacity * 2;
        Object[] newArray = new Object[newCapacity];
        System.arraycopy(data, 0, newArray, 0, capacity);
        data = newArray;
        capacity = newCapacity;
    }

    private void siftUp(E key, int index) {
        int i = index;
        while (i > 0) {
            E parentElement = (E) data[parent(i)];
            if (key.compareTo(parentElement) < 0) {
                data[i] = parentElement;
                i = parent(i);
            } else {
                break;
            }
        }
        data[i] = key;
    }

    private int left(int index) {
        return (index << 1) + 1;
    }

    private int right(int index) {
        return (index << 1) + 2;
    }

    private int parent(int index) {
        return (index -1) >>> 1;
    }

    private void heapify() {

    }

    private void validate() {
        int index = 0;
        validate(index);
    }

    void validate(int index) {
        E element = (E) data[index];
        if (left(index) < size ) {
            E left = (E) data[left(index)];
            if (element.compareTo(left) > 0) {
                throw new IllegalStateException();
            }
            validate(left(index));
        }
        if (right(index) < size) {
            E right = (E) data[right(index)];
            if (element.compareTo(right) > 0) {
                throw new IllegalStateException();
            }
            validate(right(index));
        }

    }

    private void printTree() {
        int powerOf2 = 1;
        for (int i = 0; i < size; i++) {
            if (i == powerOf2 - 1) {
                powerOf2 *= 2;
                System.out.println("");
            }
            System.out.printf(" " + data[i]);
        }
    }

    // help GC

    @Override
    public String toString() {
        printTree();
        return "PriorityQueue{" +
               "data=" + Arrays.toString(data) +
               ", size=" + size +
               ", capacity=" + capacity +
               '}';
    }
}
